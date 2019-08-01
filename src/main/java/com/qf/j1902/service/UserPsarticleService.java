package com.qf.j1902.service;

import com.qf.j1902.pojo.UserPsarticle;

import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */
public interface UserPsarticleService {
    void addDingYue(UserPsarticle userPsarticle);
    Integer getUserIDbyArticleID(Integer pscienceid);

    Integer getArticleIDbyUserID(Integer userid);
}
