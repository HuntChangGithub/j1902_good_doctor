package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.DocMapper;
import com.qf.j1902.pojo.Doctor;
import com.qf.j1902.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/24 19:37
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DocMapper docMapper;

    //获得所有医生信息
    @Override
    public List<Doctor> getAllDoc() {
        return docMapper.getAllDoc();
    }

    //获得部门下所属医生
    @Override
    public List<Doctor> getDoctorsByDepName(String string) {
        List<Doctor> list = docMapper.getDoctorsByDepName(string);
        return list;
    }
    //删除医生信息通过id
    @Override
    public boolean delDocById(int id) {
        int i = docMapper.delDocById(id);
        return i>0;
    }
    //更新医生信息
    @Override
    public boolean UpDateById(Doctor doctor) {
        return docMapper.UpDocById(doctor);
    }

    @Override
    public List<Doctor> getDoctorsAllByDepName(String deptname) {
        List<Doctor> doctorList = docMapper.getDoctorsAllByDepName(deptname);
        return doctorList;
    }

    @Override
    public Doctor getDoctorById(Integer doctorid) {
        Doctor doctor = docMapper.getDoctorById(doctorid);
        return doctor;
    }


}
