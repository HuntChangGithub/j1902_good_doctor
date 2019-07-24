package com.qf.j1902.controller;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.qf.j1902.pojo.User;
import com.qf.j1902.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI50OiPXnu9r7M", "xxvzB7ukfABXay5CQqdGWzd5jbKwbu");
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
        request.putQueryParameter("SignName", "伴我汽车");
        request.putQueryParameter("TemplateCode", "SMS_169101820");
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
    @RequestMapping(value = "/doreg" , method = RequestMethod.POST)
    public String doReg(@RequestParam("username") String username,
                        @RequestParam("upassword") String upassword,
                        @RequestParam("telphone") String telphone,
                        @RequestParam("yzm") String yzm,
                        HttpSession session , Model model){
        User user = new User();
        user.setUsername(username);
        user.setUpassword(upassword);
        user.setTelphone(telphone);
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
    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }

}
