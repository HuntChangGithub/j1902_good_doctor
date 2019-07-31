package com.qf.j1902.mapper;

import com.qf.j1902.pojo.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/24 19:32
 */
@Mapper
public interface DocMapper {
    //得到所有医生信息
    List<Doctor> getAllDoc();
    //根据部门名得到部门下所有医生
    List<Doctor> getDoctorsByDepName(@Param("string") String string);
    //通过doctorid删除医生
    int delDocById(@Param("id")int id);
    //更新doc信息
    boolean UpDocById(@Param("doctor")Doctor doctor);
    List<Doctor> getDoctorsAllByDepName(String deptname);
    //根据doctorid查一个doctor
    public Doctor getDoctorById(Integer doctorid);
}
