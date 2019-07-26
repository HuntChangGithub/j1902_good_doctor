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

    @RequestMapping("/main/docMa")
    public String docMa(){
        return "docMa";
    }


    @ResponseBody
    @RequestMapping("/main/docMa/data")
    public Object docMaData(){
        List<Doctor> allDoc = doctorService.getAllDoc();
        DataVo infoVo = new DataVo();
        infoVo.setCount(allDoc.size());
        infoVo.setData(allDoc);
        System.out.println(infoVo);
        return infoVo;
    }
}
