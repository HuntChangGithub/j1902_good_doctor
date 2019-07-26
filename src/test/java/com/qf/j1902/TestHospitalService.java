package com.qf.j1902;

import com.qf.j1902.mapper.ProvinceMapper;
import com.qf.j1902.pojo.Province;
import com.qf.j1902.service.HospitalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 *
 * @date 2019/7/24 19:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestHospitalService {

    @Autowired
    private HospitalService hospitalService;
    @Test
    public void Testonehhh(){
        int i = hospitalService.countHospitalsByProvince(610000);
        System.out.println(i);
    }

}
