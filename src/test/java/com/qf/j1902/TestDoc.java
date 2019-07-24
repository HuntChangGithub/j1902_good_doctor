package com.qf.j1902;

import com.qf.j1902.pojo.Doctor;
import com.qf.j1902.service.DoctorService;
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
    @Test
    public void DocTest1(){
        List<Doctor> allDoc = doctorService.getAllDoc();
        System.out.println(allDoc);
    }
}
