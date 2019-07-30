package com.qf.j1902.service;

import com.qf.j1902.pojo.Doctor;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/24 19:36
 */
public interface DoctorService {
    //获得所有医生
    List<Doctor> getAllDoc();
    //获得部门所属的所有医生
    List<Doctor> getDoctorsByDepName(String string);
    //通过id删除医生
    boolean delDocById(int id);
    //更新医生信息
    boolean UpDateById(Doctor doctor);

}
