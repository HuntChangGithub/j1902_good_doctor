package com.qf.j1902.controller;

import com.qf.j1902.pojo.Doctor;
import com.qf.j1902.service.DoctorService;
import com.qf.j1902.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/25 20:22
 */
@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //请求医生管理界面
    @RequestMapping("/main/docMa")
    public String docMa(){
        return "docMa";
    }

    //请求医生管理数据到前端表格
    @ResponseBody
    @RequestMapping("/main/docMa/data")
    public Object docMaData(){
        List<Doctor> allDoc = doctorService.getAllDoc();
        DataVo infoVo = new DataVo();
        infoVo.setCount(allDoc.size());
        infoVo.setData(allDoc);
        return infoVo;
    }

    //请求更改页面
    @RequestMapping("/main/docMa/docupdate")
    public String docUpdatePage(){
        return "docAdd";
    }

    @ResponseBody
    @RequestMapping("/main/docMa/dodocupdate")
    public String docDoUpdate(Doctor doctor){
        System.out.println(doctor);
        boolean b = doctorService.UpDateById(doctor);
        if (b){
            System.out.println("你吗了个巴子");
            return "0";
        }
        return "1";
    }


}
