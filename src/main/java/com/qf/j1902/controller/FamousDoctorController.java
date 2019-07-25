package com.qf.j1902.controller;

import com.qf.j1902.pojo.Doctorsreply;
import com.qf.j1902.service.FamousDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by xiaotaozi on 2019/7/24.
 */
@Controller
public class FamousDoctorController {
    @RequestMapping("/doctor")
    public String doctor(){return "doctor";}
    @RequestMapping("/Reply")
    public String reply(){return "reply";}
    @RequestMapping("/questionSubmission")
    public String questionSubmission(){return "questionSubmission";}
    @Autowired
    private FamousDoctorService famousDoctorService;
    @RequestMapping("/questionandanswer")
    public String questionandanswer(HttpSession session){
        List<Doctorsreply> doctorsreply = famousDoctorService.findAll();
        session.setAttribute("doctor",doctorsreply);
        return "questionandanswer";
    }


}
