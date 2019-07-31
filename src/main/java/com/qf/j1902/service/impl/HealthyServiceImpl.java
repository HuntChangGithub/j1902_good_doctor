package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.HealtharticleMapper;
import com.qf.j1902.pojo.Healtharticle;
import com.qf.j1902.pojo.HealtharticleExample;
import com.qf.j1902.service.HealthyService;
import com.qf.j1902.vo.ArticleVo;
import com.qf.j1902.vo.SolrSearch;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/24.
 */
@Service
public class HealthyServiceImpl implements HealthyService {

    @Autowired
    private HealtharticleMapper healtharticleMapper;
    @Override
    public List<Healtharticle> getHealthyArticles() {
        HealtharticleExample example = new HealtharticleExample();
        HealtharticleExample.Criteria criteria = example.createCriteria();
        criteria.andFenleiEqualTo("两性");
        List<Healtharticle> articles = healtharticleMapper.selectByExample(example);
        return articles;
    }

    @Override
    public Healtharticle getHealthyArticleByID(Integer pscienceid) {
        HealtharticleExample example = new HealtharticleExample();
        Healtharticle article = healtharticleMapper.selectByPrimaryKey(pscienceid);
        return article;
    }

    @Override
    public List<Healtharticle> getHealthyArticlesTuiJian() {
        HealtharticleExample example = new HealtharticleExample();
        HealtharticleExample.Criteria criteria = example.createCriteria();
        criteria.andFenleiEqualTo("推荐");
        List<Healtharticle> articles = healtharticleMapper.selectByExample(example);
        return articles;
    }

    @Override
    public List<Healtharticle> getHealthyArticlesYtdudong() {
        HealtharticleExample example = new HealtharticleExample();
        HealtharticleExample.Criteria criteria = example.createCriteria();
        criteria.andFenleiEqualTo("一图读懂");
        List<Healtharticle> articles = healtharticleMapper.selectByExample(example);
        return articles;
    }

    @Override
    public List<Healtharticle> getHealthyArticlesZuiXin() {
        HealtharticleExample example = new HealtharticleExample();
        HealtharticleExample.Criteria criteria = example.createCriteria();
        criteria.andFenleiEqualTo("最新");
        List<Healtharticle> articles = healtharticleMapper.selectByExample(example);
        return articles;
    }

    @Override
    public List<Healtharticle> getHealthyArticlesZhenXiang() {
        HealtharticleExample example = new HealtharticleExample();
        HealtharticleExample.Criteria criteria = example.createCriteria();
        criteria.andFenleiEqualTo("真相");
        List<Healtharticle> articles = healtharticleMapper.selectByExample(example);
        return articles;
    }

    @Override
    public List<Healtharticle> getHealthyArticlesZhongLiu() {
        HealtharticleExample example = new HealtharticleExample();
        HealtharticleExample.Criteria criteria = example.createCriteria();
        criteria.andFenleiEqualTo("肿瘤");
        List<Healtharticle> articles = healtharticleMapper.selectByExample(example);
        return articles;
    }

    @Override
    public List<Healtharticle> getHealthyArticlesManBing() {
        HealtharticleExample example = new HealtharticleExample();
        HealtharticleExample.Criteria criteria = example.createCriteria();
        criteria.andFenleiEqualTo("慢病");
        List<Healtharticle> articles = healtharticleMapper.selectByExample(example);
        return articles;
    }

    @Override
    public List<Healtharticle> getHealthyArticlesAll() {
        HealtharticleExample example = new HealtharticleExample();
        List<Healtharticle> healtharticles = healtharticleMapper.selectByExample(example);
        return healtharticles;
    }

    @Override
    public List<Healtharticle> getHealthyArticlesByKeywords(String keywords) {
        HealtharticleExample example=new HealtharticleExample();
        HealtharticleExample.Criteria criteria = example.createCriteria();
        criteria.andPstitleLike("%"+keywords+"%");//文章标题
        HealtharticleExample.Criteria criteria1 = example.createCriteria();
        criteria1.andPsauthorLike("%"+keywords+"%");//文章作者
        HealtharticleExample.Criteria criteria2 = example.createCriteria();
        criteria2.andPsintroduceLike("%"+keywords+"%");//文章介绍
        example.or(criteria1);
        example.or(criteria2);
        List<Healtharticle> healtharticles = healtharticleMapper.selectByExample(example);
        return healtharticles;
    }

    @Override
    public boolean addpsArticle(ArticleVo articleVo) {
        boolean add=healtharticleMapper.addpsArticle(articleVo);
        return add;
    }


}
