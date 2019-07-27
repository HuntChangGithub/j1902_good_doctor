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

    @Override
    public List<Doctor> getAllDoc() {
        return docMapper.getAllDoc();
    }

    @Override
    public List<Doctor> getDoctorsByDepName(String string) {
        List<Doctor> list = docMapper.getDoctorsByDepName(string);
        return list;
    }

    @Override
    public boolean delDocById(int id) {
        int i = docMapper.delDocById(id);
        return i>0;
    }

    @Override
    public boolean UpDateById(Doctor doctor) {
        return docMapper.UpDocById(doctor);
    }


}
