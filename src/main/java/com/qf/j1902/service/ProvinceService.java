package com.qf.j1902.service;

import com.qf.j1902.pojo.Province;

import java.util.List;

/**
 * Created by 赵国林 on 2019/7/25.
 */
public interface ProvinceService {
    public List<Province> findAll();
    //查询provinceID
    public Province getProvByName(String provName);
}
