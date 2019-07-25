package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.CityMapper;
import com.qf.j1902.pojo.City;
import com.qf.j1902.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 赵国林 on 2019/7/25.
 */
@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityMapper cityMapper;
    @Override
    public List<City> findCitysByProvinceId(String provinceId) {
        List<City> cityList = cityMapper.findCitysByProvinceId(provinceId);
        return cityList;
    }
}
