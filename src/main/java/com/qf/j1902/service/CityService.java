package com.qf.j1902.service;

import com.qf.j1902.pojo.City;

import java.util.List;

/**
 * Created by 赵国林 on 2019/7/25.
 */
public interface CityService {
    //根据provinceid查询city列表
    public List<City> findCitysByProvinceId(String provinceId);
}
