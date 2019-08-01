package com.qf.j1902.service;

import com.qf.j1902.pojo.Doctorsreply;
import com.qf.j1902.pojo.Userquestions;
import com.qf.j1902.vo.FamousDoctorVo;

import java.util.List;

/**
 * Created by xiaotaozi on 2019/7/25.
 */
public interface FamousDoctorService {
    public List<FamousDoctorVo> findAll();
    public FamousDoctorVo findAllByid(Integer id);
    public Doctorsreply findAllById(Integer id);
    public boolean add(Userquestions userquestions);

}
