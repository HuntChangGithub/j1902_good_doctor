package com.qf.j1902;

import com.qf.j1902.pojo.Doctor;
import com.qf.j1902.service.DocDealService;
import com.qf.j1902.service.DoctorService;
import com.qf.j1902.service.impl.DocDealServiceImpl;
import com.qf.j1902.vo.DocDealInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/24 19:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Configuration
public class TestDoc {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DocDealService docDealService;
    @Test
    public void DocTest1(){
        List<Doctor> allDoc = doctorService.getAllDoc();
        System.out.println(allDoc);
    }


  /*  @Test
    public void DocInfoTest1(){
//        List<DocDealInfo> allDocDealInfo = docDealService.getAllDocDealInfo();
//        List<Doctor> allDoc = doctorService.getAllDoc();
//        System.out.println(allDoc);
//        System.out.println(allDocDealInfo);
        Doctor doctor = new Doctor();


        doctor.setDoctorid(1);
        doctor.setDepid(1);
        doctor.setDoctorinfo("222");
        doctor.setHpid(1);
        doctor.setJobtitle("教授");
        doctor.setUsername("wanger");
        doctor.setTelphone("17777777888");

        boolean b = doctorService.UpDateById(doctor);
        System.out.println(b);*/
    /*}*/
}
