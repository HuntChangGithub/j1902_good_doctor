package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.ProvinceMapper;
import com.qf.j1902.pojo.Province;
import com.qf.j1902.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 赵国林 on 2019/7/25.
 */
@Service
public class ProvinceServiceImpl implements ProvinceService{
    @Autowired
    private ProvinceMapper provinceMapper;
    @Override
    public List<Province> findAll() {
        List<Province> provinceList = provinceMapper.findAll();
        return provinceList;
    }
}
