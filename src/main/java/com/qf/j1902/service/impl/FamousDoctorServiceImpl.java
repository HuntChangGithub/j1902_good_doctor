package com.qf.j1902.service.impl;
import com.qf.j1902.mapper.FamousDoctorMapper;
import com.qf.j1902.pojo.Doctorsreply;
import com.qf.j1902.service.FamousDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by xiaotaozi on 2019/7/25.
 */
@Service
public class FamousDoctorServiceImpl implements FamousDoctorService{
    @Autowired
    private FamousDoctorMapper famousDoctorMapper;

    @Override
    public List<Doctorsreply> findAll() {
        return famousDoctorMapper.findAll();
    }
}
