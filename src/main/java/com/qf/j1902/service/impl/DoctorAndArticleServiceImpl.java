package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.DoctorAndArticleMapper;
import com.qf.j1902.pojo.DoctorAndArticle;
import com.qf.j1902.service.DoctorAndArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/7/31.
 */
@Service
public class DoctorAndArticleServiceImpl implements DoctorAndArticleService {
    @Autowired
    private DoctorAndArticleMapper doctorAndArticleMapper;
    @Override
    public boolean addDoctorAndArticle(DoctorAndArticle doctorAndArticle) {
       boolean add=doctorAndArticleMapper.addDoctorAndArticle(doctorAndArticle);
        return add;
    }
}
