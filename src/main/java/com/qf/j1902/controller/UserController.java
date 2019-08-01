package com.qf.j1902.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.qf.j1902.pojo.Doctor;
import com.qf.j1902.pojo.Healtharticle;
import com.qf.j1902.pojo.User;
import com.qf.j1902.service.DoctorService;
import com.qf.j1902.service.UserPsarticleService;
import com.qf.j1902.service.UserService;
import com.qf.j1902.utils.ImgCode;
import com.qf.j1902.vo.MsgResult;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by asus on 2019/7/23.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private UserPsarticleService userPsarticleService;
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
        String avatar = "defaultAvatar.jpg";
        Double balance = 0.0;
        Md5Hash md5Hash = new Md5Hash(upassword,null,1024);
        String md5str = md5Hash.toString();
        User user = new User();
        user.setUsername(username);
        user.setUpassword(md5str);
        user.setTelphone(telphone);
        user.setAvatar(avatar);
        user.setBalance(balance);
        Date date = new Date();
        user.setRegtime(date);
        String string;
        String sendcode = (String) session.getAttribute("sendyzm");

        if (yzm.equals(sendcode)) {
            boolean isAdd = userService.addUser(user);
            if (isAdd) {
                string = "恭喜你，注册成功！";
                return "regsuccess";
            } else {
                string = "很抱歉，注册失败！";
            }
        } else {
            string = "验证码错误！";
            model.addAttribute("string", string);
        }
        return "reg";
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

        String string1;
        String string2;
        String string3;
        //检验登录验证码
        if (StringUtils.startsWithIgnoreCase(verify, userInfo.getVerifyCode())) {
            if (users.size() != 0) {
                Integer userid = users.get(0).getUserid();
                String roleName = userService.getRoleNameByUid(userid);
                try {
                    Subject subject = SecurityUtils.getSubject();
                    UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getUpassword());
                    subject.login(token);
                    if (subject.isAuthenticated()) {
                        if (roleName.equals("doctor") || roleName.equals("member")) {
                            session.setAttribute("username", userInfo.getUsername());
                            if (substring.equals("/") || substring.equals("/logout") || substring.equals("/regsuccess") || substring.equals("/reg") || substring.equals("/login")) {
                                return "index";
                            } else {
                                return "redirect:" + substring;
                               }
                        } else {
                            return "main";
                        }
                    }
                } catch (Exception e) {
                    string1 = "用户名或密码错误";
                    model.addAttribute("string1", string1);
                }
            } else {
                string3 = "用户名不存在";
                model.addAttribute("string3", string3);
            }
        } else {
            string2 = "验证码错误";
            model.addAttribute("string2", string2);
        }
        return "login";
    }
    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }

    //退出
    @RequestMapping(value = "logout")
    public String logout(HttpSession session){
        session.setAttribute("username","");
        return "index";
    }
    //前往个人中心
    @RequestMapping(value = "personalCenter" , method = RequestMethod.GET)
    public String topPrsonalCenter(HttpSession session , Model model){
        String username = (String) session.getAttribute("username");
        List<User> users = userService.getUserByName(username);
        User user = users.get(0);
        //将数据库的date数据类型转为String
        Date regtime = user.getRegtime();
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
        String times = time.format(regtime);
        model.addAttribute("user",user);
        model.addAttribute("regtime",times);
        return "personalCenter";
    }
    //修改密码   oldupassword  newupassword
    @RequestMapping(value = "/updateUpw" , method = RequestMethod.GET)
    @ResponseBody
    public MsgResult updateUpw(@RequestParam(value = "newupassword")String newupassword ,
                            @RequestParam("oldupassword")String oldupassword ,HttpSession session ){
        //对用户输入的原密码进行加密
        Md5Hash md5Hash = new Md5Hash(oldupassword,null,1024);
        String md5str = md5Hash.toString();
        //对用户输入的新密码进行加密
        Md5Hash md5Hash1 = new Md5Hash(newupassword,null,1024);
        String md5str1 = md5Hash1.toString();
        //通过session中的username获取对象进而获取原密码
        String username = (String) session.getAttribute("username");
        List<User> users = userService.getUserByName(username);
        String upassword = users.get(0).getUpassword();
        Integer userid = users.get(0).getUserid();
        String avatar = users.get(0).getAvatar();
        Double balance = users.get(0).getBalance();
        Date regtime = users.get(0).getRegtime();
        String telphone = users.get(0).getTelphone();
        User user = new User();
        user.setUsername(username);
        user.setUpassword(md5str1);
        user.setUserid(userid);
        user.setRegtime(regtime);
        user.setAvatar(avatar);
        user.setTelphone(telphone);
        user.setBalance(balance);
        MsgResult msgResult = new MsgResult();
        //判断用户输入的原密码是否正确
        if (md5str.equals(upassword)){//用户输入的原密码是否正确，可进行修改业务
            boolean isUpdate = userService.updateUpw( user );
            if (isUpdate) {
                msgResult.setStatus(200);
                msgResult.setMessage("修改成功！");;
            }else {
                msgResult.setStatus(400);
                msgResult.setMessage("修改失败！");;
            }
        }else {
            msgResult.setStatus(500);
            msgResult.setMessage("原密码错误！");;
        }
        return msgResult;
    }
    //修改头像
    @RequestMapping(value = "/updateAvatar" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateAvatar(@RequestParam("file")MultipartFile file, HttpSession session)throws IOException {
        //如果文件内容不为空，则写入上传路径
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        //上传文件路径
        //String path = servletRequest.getServletContext().getRealPath("E:\\IdeaProjects\\j1902_good_doctor\\src\\main\\resources\\static\\userimg");
        String path = new String("E:\\IdeaProjects\\j1902_good_doctor\\src\\main\\resources\\static\\userimg");
        //上传照片原文件名
        String name = file.getOriginalFilename();//上传文件的真实名称
        String suffixName = name.substring(name.lastIndexOf("."));//获取后缀名
        String hash = Integer.toHexString(new Random().nextInt());//自定义随机数（字母+数字）作为文件名
        //加后缀的文件名
        String fileName = hash + suffixName;
        //将新的user信息set进user中
        String username = (String) session.getAttribute("username");
        List<User> users = userService.getUserByName(username);
        String upassword = users.get(0).getUpassword();
        Integer userid = users.get(0).getUserid();
        Double balance = users.get(0).getBalance();
        Date regtime = users.get(0).getRegtime();
        String telphone = users.get(0).getTelphone();
        User user = new User();
        user.setUsername(username);
        user.setUpassword(upassword);
        user.setUserid(userid);
        user.setRegtime(regtime);
        user.setAvatar(fileName);
        user.setTelphone(telphone);
        user.setBalance(balance);

        File filepath = new File(path+fileName);
        //判断路径是否存在，没有就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
       //将上传文件保存到一个目标文档中
        File tempFile = new File(path + File.separator + fileName);
        file.transferTo(tempFile);
        //将进的用户信息写进数据库中
        boolean isUpdate = userService.updateUpw( user );
        resUrl.put("src", tempFile.getPath());
        res.put("code", 0);
        res.put("msg", "");
        res.put("data", resUrl);
        return res;
    }
    //前往个人订阅
    @RequestMapping(value = "mySubscription" , method = RequestMethod.GET)
    public String toMySubscription(HttpSession session , Model model){
        String username = (String) session.getAttribute("username");
        List<User> users = userService.getUserByName(username);
        User user = users.get(0);
        model.addAttribute("user",user);
        Integer userid = user.getUserid();
        List<Healtharticle> healtharticles= userPsarticleService.getHealthyArticlesByUserid(userid);
        model.addAttribute("healtharticles",healtharticles);
        return "mySubscription";
    }
    //前往进行医师资格认证
    @RequestMapping(value = "doctorApplication" , method = RequestMethod.GET)
    public String toDoctorApplication(HttpSession session , Model model){
        String username = (String) session.getAttribute("username");
        List<User> users = userService.getUserByName(username);
        User user = users.get(0);
        model.addAttribute("user",user);

        return "doctorApplication";
    }
    //申请医师--身份证上传图片    upLoadDoctImg
    @RequestMapping( value = "/upLoadIdCard" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject toUpLoadIdCard(@RequestParam("file")MultipartFile file )throws IOException{
        //如果文件内容不为空，则写入上传路径
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        //上传文件路径
        //String path = servletRequest.getServletContext().getRealPath("E:\\IdeaProjects\\j1902_good_doctor\\src\\main\\resources\\static\\userimg");
        String path = new String("E:\\IdeaProjects\\j1902_good_doctor\\src\\main\\resources\\static\\doctorimg");
        //上传照片原文件名  static.doctorimg
        String name = file.getOriginalFilename();//上传文件的真实名称
        String suffixName = name.substring(name.lastIndexOf("."));//获取后缀名
        String hash = Integer.toHexString(new Random().nextInt());//自定义随机数（字母+数字）作为文件名
        //加后缀的文件名
        String fileName = hash + suffixName;
        File filepath = new File(path+fileName);

        //判断路径是否存在，没有就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文档中
        File tempFile = new File(path + File.separator + fileName);
        file.transferTo(tempFile);

        resUrl.put("src", tempFile.getPath());
        res.put("shenfen",fileName);
        res.put("code", 0);
        res.put("msg", "");
        res.put("data", resUrl);
        return res;
    }//申请医师--身份证上传图片
    @RequestMapping( value = "/upLoadDoctImg" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject toUpLoadDoctImg(@RequestParam("file")MultipartFile file )throws IOException{
        //如果文件内容不为空，则写入上传路径
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        //上传文件路径
        //String path = servletRequest.getServletContext().getRealPath("E:\\IdeaProjects\\j1902_good_doctor\\src\\main\\resources\\static\\userimg");
        String path = new String("E:\\IdeaProjects\\j1902_good_doctor\\src\\main\\resources\\static\\doctorimg");
        //上传照片原文件名  static.doctorimg
        String name = file.getOriginalFilename();//上传文件的真实名称
        String suffixName1 = name.substring(name.lastIndexOf("."));//获取后缀名
        String hash = Integer.toHexString(new Random().nextInt());//自定义随机数（字母+数字）作为文件名
        //加后缀的文件名
        String fileName = hash + suffixName1;
        File filepath = new File(path+fileName);

        //判断路径是否存在，没有就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文档中
        File tempFile = new File(path + File.separator + fileName);
        file.transferTo(tempFile);

        resUrl.put("src", tempFile.getPath());
        res.put("zhicheng",suffixName1);
        res.put("code", 0);
        res.put("msg", "");
        res.put("data", resUrl);
        return res;
    }
    //jobtitle
    @RequestMapping(value = "/referDoctor" , method = RequestMethod.POST)
    public String toReferDoctor(@RequestParam("relname")String relname ,
                                @RequestParam("hospatalid")String hospatalid ,
                                @RequestParam("depid")String depid ,
                                @RequestParam("jobtitle")String jobtitle ,
                                @RequestParam("shenfen")String shenfen ,
                                @RequestParam("zhicheng")String zhicheng ,
                                @RequestParam("doctorinfo")String doctorinfo ,HttpSession session){
        String username = (String) session.getAttribute("username");
        List<User> users = userService.getUserByName(username);
        String avatar = users.get(0).getAvatar();
        //处理前台传回的文件名
        int i1 = shenfen.lastIndexOf("\\");
        int length1 = shenfen.length();
        String shenfenImg = shenfen.substring(i1+1, length1);
        int i2 = zhicheng.lastIndexOf("\\");
        int length2 = zhicheng.length();
        String zhichengImg = zhicheng.substring(i2+1, length2);
        Doctor doctor = new Doctor();
        doctor.setUsername(username);
        doctor.setAvatar(avatar);
        doctor.setDepName(depid);
        doctor.setHpName(hospatalid);
        doctor.setIdcard(shenfenImg);
        doctor.setCertificateimg(zhichengImg);
        doctor.setRelname(relname);
        doctor.setJobtitle(jobtitle);
        doctor.setDoctorinfo(doctorinfo);
        boolean isAdd = doctorService.addDoctor(doctor);
        return "redirect:doctorApplication";
    }
}
