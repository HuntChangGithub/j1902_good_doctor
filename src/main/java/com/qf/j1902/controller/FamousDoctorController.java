package com.qf.j1902.controller;

import com.qf.j1902.pojo.Doctorsreply;
import com.qf.j1902.service.FamousDoctorService;
import com.qf.j1902.vo.FamousDoctorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
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
        session.setAttribute("doctor",doctorsreplys);
        return "questionandanswer";
    }
    @RequestMapping("/Reply")
    public String reply(HttpSession session,@RequestParam("id")Integer id){
        FamousDoctorVo famousDoctorVo= famousDoctorService.findAllByid(id);
        session.setAttribute("reply",famousDoctorVo);
        return "Reply";
    }
    @RequestMapping("/doctor")
    public String doctor(HttpSession session,
                         @RequestParam("id")Integer id){
        Doctorsreply doctorsreply = famousDoctorService.findAllById(id);
        session.setAttribute("doctors",doctorsreply);
        return "doctor";
    }
    @RequestMapping("/questionSubmission")
    public String questionSubmission(HttpSession session,
                                     @RequestParam("id")Integer id){
        Doctorsreply allById = famousDoctorService.findAllById(id);
        session.setAttribute("questions",allById);
        return "questionSubmission";
    }
    /*用户主页*/
    @RequestMapping("/personalCenter")
    public String personalCenter(){return "personalCenter";}
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
    /**/

}
