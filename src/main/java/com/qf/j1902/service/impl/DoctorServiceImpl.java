package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.DocMapper;
import com.qf.j1902.pojo.Doctor;
import com.qf.j1902.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
