package com.qf.j1902.controller;

import com.qf.j1902.pojo.Doctor;
import com.qf.j1902.pojo.TDepartment;
import com.qf.j1902.service.DoctorService;
import com.qf.j1902.service.TDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by asus on 2019/7/26.
 */
@Controller
public class OnlineDoctortController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    TDepartmentService departmentService;
    @RequestMapping(value = "onlinedoctory")
    public String toOnlinedoctory(Model model){
        // 获取外科医生回答数前四名医生的资料doctorsWai
        String string1 = "外科";
        List<Doctor> doctorsWai = doctorService.getDoctorsByDepName(string1);
        model.addAttribute("doctorsWai",doctorsWai);
        //获取外科医生回答数前四名医生的资料doctorsGu
        String string2 = "骨科";
        List<Doctor> doctorsGu = doctorService.getDoctorsByDepName(string2);
        model.addAttribute("doctorsGu",doctorsGu);
        //获取外科医生回答数前四名医生的资料doctorsEr
        String string3 = "儿科";
        List<Doctor> doctorsEr = doctorService.getDoctorsByDepName(string3);
        model.addAttribute("doctorsEr",doctorsEr);
        //获取外科医生回答数前四名医生的资料doctorsPiFu
        String string4 = "皮肤科";
        List<Doctor> doctorsPiFu = doctorService.getDoctorsByDepName(string4);
        model.addAttribute("doctorsPiFu",doctorsPiFu);
        //获取外科医生回答数前四名医生的资料doctorsZhongYi
        String string5 = "中医科";
        List<Doctor> doctorsZhongYi = doctorService.getDoctorsByDepName(string5);
        model.addAttribute("doctorsZhongYi",doctorsZhongYi);
        //获取所有科室信息
        List<TDepartment> depts = departmentService.getDepts();
        TDepartment remove = depts.remove(0);
        model.addAttribute("depts",depts);
        return "onlinedoctory";
    }
    @RequestMapping(value = "getDoctorByDeptName", method = RequestMethod.GET)
    public  String getDoctors(@RequestParam("deptname") String deptname , Model model){
        List<Doctor> doctors = doctorService.getDoctorsAllByDepName(deptname);
        model.addAttribute("doctors",doctors);
        model.addAttribute("deptname",deptname);
        return "chosedoctor";
    }

}
