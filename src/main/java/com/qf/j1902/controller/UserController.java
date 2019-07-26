package com.qf.j1902.controller;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.HttpRequest;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.qf.j1902.pojo.User;
import com.qf.j1902.service.UserService;
import com.qf.j1902.utils.ImgCode;
import com.qf.j1902.vo.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2019/7/23.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "reg")
    public String reg(){
        return "reg";
    }
    //判断用户名是否已存在
    @RequestMapping(value = "/reg/fetchuname" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Boolean> doreg(@RequestParam("username") String username){
        List<User> users = userService.getUsers();
        boolean ishave;
        for (User user: users ) {
            if (user.getUsername().equals(username)) {
                ishave = true;
                return new ResponseEntity<Boolean>(ishave, HttpStatus.OK);
            }
        }
        ishave = false;
        return new ResponseEntity<Boolean>(ishave, HttpStatus.NOT_FOUND);
    }
    //发送验证码
    @RequestMapping(value = "/reg/sendyzm" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Boolean> sendmessage(@RequestParam("telphone") String telphone , HttpSession session){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIP4Ha77WeoXTA", "xm8qYmLjYQBu4Tei9nPgnq05eIkYP4");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        String str = telphone;

        //自定义随机验证码
        int yzm = (int)((Math.random()*9+1)*100000);
        Map<String , Integer> map=new HashMap<>();
        map.put("code",yzm);
        String json = new Gson().toJson(map);
        //将验证码存在session中，方便注册时比对
        String sendyzm = String.valueOf(yzm);
        session.setAttribute("sendyzm",sendyzm);

        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", str);
        request.putQueryParameter("SignName", "健康医生平台");
        request.putQueryParameter("TemplateCode", "SMS_171191648");
        request.putQueryParameter("TemplateParam", json);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
            return new ResponseEntity<Boolean>(false, HttpStatus.FAILED_DEPENDENCY);
    }
    //用户注册
    @RequestMapping(value = "/doreg" , method = RequestMethod.POST)
    public String doReg(@RequestParam("username") String username,
                        @RequestParam("upassword") String upassword,
                        @RequestParam("telphone") String telphone,
                        @RequestParam("yzm") String yzm,
                        HttpSession session , Model model){
        Md5Hash md5Hash = new Md5Hash(upassword,null,1024);
        String md5str = md5Hash.toString();
        User user = new User();
        user.setUsername(username);
        user.setUpassword(md5str);
        user.setTelphone(telphone);
        Date date = new Date();
        user.setRegtime(date);
        String string;
        String sendcode = (String) session.getAttribute("sendyzm");
        if (yzm.equals(sendcode)){
            boolean isAdd = userService.addUser(user);
            string = "恭喜你，注册成功！";
            return "regsuccess";

        }else {
            string = "很抱歉，注册失败！";
            model.addAttribute("string",string);
            return "reg";
        }

    }
    //生成登录时验证码
    @RequestMapping(value="/getImage" ,method=RequestMethod.GET)
    public void getVerifyImage(HttpServletRequest request, HttpServletResponse response){
        ImgCode imgCode = new ImgCode();
        imgCode.getRandcode(request,response);

    }
    //用户登录
    @RequestMapping(value = "/dologin" , method = RequestMethod.POST)
    public String dologin(UserInfo userInfo , Model model , HttpSession session ,String url){
        //解析进入登录页前的页面全路径，获取路径以便动态返回登录前的页面
        int i = url.lastIndexOf("/");
        int length = url.length();
        String substring = url.substring(i, length);
        //从session中获取存储的验证码
        String verify = (String) session.getAttribute(ImgCode.RANDOMCODEKEY);
        List<User> users = userService.getUserByName(userInfo.getUsername());
        //检验登录验证码
        if (StringUtils.startsWithIgnoreCase(verify,userInfo.getVerifyCode())){
            if (users.size() != 0) {
                Integer userid = users.get(0).getUserid();
                String roleName = userService.getRoleNameByUid(userid);
                try {
                    Subject subject = SecurityUtils.getSubject();
                    UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getUpassword());
                    subject.login(token);
                    if (subject.isAuthenticated()) {
                        if (roleName.equals("doctor") || roleName.equals("member")){
                            session.setAttribute("username", userInfo.getUsername());
                            if (substring.equals("/") || substring.equals("/logout") || substring.equals("/regsuccess") || substring.equals("/reg") || substring.equals("/login")){
                                return "index";
                            }else {
                                return substring;
                            }
                        }else {
                            return "main";
                        }
                    }
                } catch (Exception e) {
                    String string1 = "用户名或密码错误";
                    model.addAttribute("string1", string1);
                }
            }else {
                String string3 = "用户名不存在";
                model.addAttribute("string3", string3);
            }
        }else {
            String string2 = "验证码错误";
            model.addAttribute("string2", string2);
        }
        return "login";
    }
    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "onlinedoctory")
    public String toOnlinedoctory(){
        return "onlinedoctory";
    }
    //退出
    @RequestMapping(value = "logout")
    public String logout(HttpSession session){
        session.setAttribute("username","");
        return "index";
    }
}
