package com.qf.j1902.service;

import com.qf.j1902.pojo.THospitals;

import java.util.List;

/**
 * Created by 赵国林 on 2019/7/24.
 */
public interface HospitalService {
    //全查分页
    public List<THospitals> findAll();
    //修改医院信息
    public int updateHospital(THospitals tHospital);
    //删除医院信息
    public boolean delHospital(List<Integer> hpid);
    //增加一条医院数据
    public int addHospital(THospitals hospital);
}
