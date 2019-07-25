package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.HealtharticleMapper;
import com.qf.j1902.pojo.Healtharticle;
import com.qf.j1902.pojo.HealtharticleExample;
import com.qf.j1902.service.HealthyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        criteria.andFenleiEqualTo("推荐");
        List<Healtharticle> articles = healtharticleMapper.selectByExample(example);
        return articles;
    }
}
