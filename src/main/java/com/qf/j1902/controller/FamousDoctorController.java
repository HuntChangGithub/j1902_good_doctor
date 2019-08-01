package com.qf.j1902.controller;

import com.alibaba.fastjson.JSONObject;
import com.qf.j1902.pojo.Doctorsreply;
import com.qf.j1902.pojo.Userquestions;
import com.qf.j1902.service.FamousDoctorService;
import com.qf.j1902.vo.ArticleVo;
import com.qf.j1902.vo.FamousDoctorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by xiaotaozi on 2019/7/24.
 */
@Controller
public class FamousDoctorController {
    @Autowired
    private FamousDoctorService famousDoctorService;
    @RequestMapping("/questionandanswer")
    public String questionandanswer(HttpSession session,Model model){
        List<FamousDoctorVo> doctorsreplys = famousDoctorService.findAll();
        model.addAttribute("doctor",doctorsreplys);
        return "questionandanswer";
    }
    @RequestMapping("/Reply")
    public String reply(HttpSession session,Model model,@RequestParam("id")Integer id){
        FamousDoctorVo famousDoctorVo= famousDoctorService.findAllByid(id);
        model.addAttribute("reply",famousDoctorVo);
        return "Reply";
    }
    @RequestMapping("/doctor")
    public String doctor(HttpSession session,
                         Model model,
                         @RequestParam("id")Integer id){
        Doctorsreply doctorsreply = famousDoctorService.findAllById(id);
        model.addAttribute("doctors",doctorsreply);
        return "doctor";
    }
    @RequestMapping("/questionSubmission")
    public String questionSubmission(HttpSession session,
                                     Model model,
                                     @RequestParam("id")Integer id){
        Doctorsreply allById = famousDoctorService.findAllById(id);
        model.addAttribute("questions",allById);
        return "questionSubmission";
    }
    /*用户主页*/
    @RequestMapping("/gerenzhongxin")
    public String gerenzhongxin(){return "gerenzhongxin";}
    /*优惠券页*/
    @RequestMapping("/coupon")
    public String coupon(){return "coupon";}
    /*用户提过的问题页*/
    @RequestMapping("/userQuestions")
    public String userQuestions(){return "userQuestions";}
    /*用户浏览过的问题*/
    @RequestMapping("/browsed")
    public String browsed(){return "browsed";}
    /*用户关注的医生*/
    @RequestMapping("/follow")
    public String follow(){return "follow";}
    /*找医生*/
    @RequestMapping("/seekADoctor")
    public String seekADoctor(){return "seekADoctor";}
    /* 添加提问*/
    @RequestMapping("/gerenzhongxing")
    public String gerenzhongxin(@RequestParam("concreteProblems")String concreteProblems){
        Userquestions userquestions = new Userquestions();
        userquestions.setConcreteProblems(concreteProblems);
        boolean add = famousDoctorService.add(userquestions);
        System.out.println(add);
        return "questionandanswer";
    }

}
