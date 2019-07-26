package com.qf.j1902;

import com.qf.j1902.mapper.ProvinceMapper;
import com.qf.j1902.pojo.Doctor;
import com.qf.j1902.pojo.Province;
import com.qf.j1902.service.DoctorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 *
 * @date 2019/7/24 19:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestProvinceMapper {

    @Autowired
    private ProvinceMapper provinceMapper;
    @Test
    public void Testone(){
        List<Province> provinces = provinceMapper.findAll();
        System.out.println(provinces);
    }
}
