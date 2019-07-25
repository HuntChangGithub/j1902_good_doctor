package com.qf.j1902.service;

import com.qf.j1902.pojo.Healtharticle;

import java.util.List;

/**
 * Created by Administrator on 2019/7/24.
 */
public interface HealthyService {
    List<Healtharticle> getHealthyArticles();
    Healtharticle getHealthyArticleByID(Integer pscienceid);
}
