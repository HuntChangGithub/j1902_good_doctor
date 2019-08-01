package com.qf.j1902.service;

import com.qf.j1902.pojo.THospitals;
import org.apache.ibatis.annotations.Param;

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
    //地区的医院数据计数
    public int countHospitalsByProvince(@Param("prov") Integer provId);
    //根据provId查询医院列表
    public List<THospitals> findHospitalsByProvId(String provId);
    public THospitals getHospitalsById(Integer id);
    //根据科室名称模糊查询专长此科的医院
    public List<THospitals> findHospitalsByDepName(String depName);
    //根据城市id获取医院列表
    public List<THospitals> findHospitalsByCityid(String cityid);
}
