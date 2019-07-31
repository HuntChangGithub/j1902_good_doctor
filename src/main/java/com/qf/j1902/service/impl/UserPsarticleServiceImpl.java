package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.UserPsarticleMapper;
import com.qf.j1902.pojo.UserPsarticle;
import com.qf.j1902.pojo.UserPsarticleExample;
import com.qf.j1902.service.UserPsarticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */
@Service
public class UserPsarticleServiceImpl implements UserPsarticleService {
    @Autowired
    private UserPsarticleMapper userPsarticleMapper;
    @Override
    public void addDingYue(UserPsarticle userPsarticle) {
        int insert = userPsarticleMapper.insert(userPsarticle);
    }

    @Override
    public Integer getUserIDbyArticleID(Integer pscienceid) {
        return userPsarticleMapper.getUserIDbyArticleID(pscienceid);
    }

    @Override
    public Integer getArticleIDbyUserID(Integer userid) {
         return userPsarticleMapper.getArticleIDbyUserID(userid);
    }


}
