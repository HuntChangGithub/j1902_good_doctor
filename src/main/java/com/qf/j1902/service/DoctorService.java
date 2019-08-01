package com.qf.j1902.service;

import com.qf.j1902.pojo.Doctor;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/24 19:36
 */
public interface DoctorService {
    List<Doctor> getAllDoc();
    //查询科室回答数在前四的医生
    List<Doctor> getDoctorsByDepName(String string);
    boolean delDocById(int id);
    boolean UpDateById(Doctor doctor);
    //查询科室所有医生
    List<Doctor> getDoctorsAllByDepName(String deptname);
    //根据doctorid查一个doctor
    public Doctor getDoctorById(Integer doctorid);
    //用户进行医生认证
    public  boolean addDoctor(Doctor doctor);
}
