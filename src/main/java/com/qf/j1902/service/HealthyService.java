package com.qf.j1902.service;

import com.alibaba.fastjson.JSONObject;
import com.qf.j1902.pojo.Healtharticle;
import com.qf.j1902.vo.ArticleVo;
import com.qf.j1902.vo.SolrSearch;

import java.util.List;

/**
 * Created by Administrator on 2019/7/24.
 */
public interface HealthyService {
    List<Healtharticle> getHealthyArticles();

    Healtharticle getHealthyArticleByID(Integer pscienceid);

    List<Healtharticle> getHealthyArticlesTuiJian();

    List<Healtharticle> getHealthyArticlesYtdudong();

    List<Healtharticle> getHealthyArticlesZuiXin();

    List<Healtharticle> getHealthyArticlesZhenXiang();

    List<Healtharticle> getHealthyArticlesZhongLiu();

    List<Healtharticle> getHealthyArticlesManBing();

    //导入solr
    List<Healtharticle> getHealthyArticlesAll();

    List<Healtharticle> getHealthyArticlesByKeywords(String keywords);

    boolean addpsArticle(ArticleVo articleVo);

    Integer getHealthyArticleID();
}
