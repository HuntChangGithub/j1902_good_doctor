package com.qf.j1902.service;

import com.qf.j1902.pojo.TDepartment;

import java.util.List;

/**
 * Created by asus on 2019/7/26.
 */
public interface TDepartmentService {
    //获取科室表信息
    public List<TDepartment> getDepts();
    //获取科室信息
    public TDepartment findDepartById(String depid);
}
