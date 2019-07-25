package com.qf.j1902;

import com.qf.j1902.mapper.CityMapper;
import com.qf.j1902.mapper.ProvinceMapper;
import com.qf.j1902.pojo.City;
import com.qf.j1902.pojo.Province;
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
public class TestCityMapper {

    @Autowired
    private CityMapper cityMapper;
    @Test
    public void Testonee(){
        List<City> cityList = cityMapper.findCitysByProvinceId("610000");
        System.out.println(cityList);
    }
}
