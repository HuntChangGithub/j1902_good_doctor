package com.qf.j1902.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.j1902.mapper.TIllnessMapper;
import com.qf.j1902.pojo.TIllness;
import com.qf.j1902.pojo.TIllnessExample;
import com.qf.j1902.service.IllnessServiceH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 赵国林 on 2019/7/29.
 */
@Service
public class IllnessServiceHImpl implements IllnessServiceH{
    @Autowired
    private TIllnessMapper illnessMapper;
    @Override
    public List<TIllness> findAll() {
        List<TIllness> illnessList = illnessMapper.selectByExample(new TIllnessExample());
        return illnessList;
    }

    @Override
    public int updateIllnessById(TIllness illness) {
        int i = illnessMapper.updateByPrimaryKeySelective(illness);
        return i;
    }

    @Override
    @Transactional
    public boolean delIllnessByIds(List<Integer> idList) {
        TIllnessExample example = new TIllnessExample();
        TIllnessExample.Criteria criteria = example.createCriteria();
        criteria.andIllidIn(idList);
        boolean b=false;
        try {
           int i = illnessMapper.deleteByExample(example);
           b=true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return b;
    }

    @Override
    public int addIllness(TIllness illness) {
        int i = illnessMapper.insertSelective(illness);
        return i;
    }

    @Override
    public JSONObject findIllness(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<TIllness> illnessList = illnessMapper.selectByExample(new TIllnessExample());
        PageInfo<TIllness> pageInfo=new PageInfo<>(illnessList);
        long total = pageInfo.getTotal();//总条数
        long pages=((total+pageSize-1)/pageSize);
        JSONObject json = new JSONObject();
        json.put("pages",pages);
        json.put("data",illnessList);
        return json;
    }

    @Override
    public TIllness findIllnessById(Integer illid) {
        TIllness illness = illnessMapper.selectByPrimaryKey(illid);
        return illness;
    }

    @Override
    public JSONObject findIllnessByDepid(Integer page, Integer pageSize, Integer depid) {
        PageHelper.startPage(page,pageSize);
        TIllnessExample example = new TIllnessExample();
        TIllnessExample.Criteria criteria = example.createCriteria();
        criteria.andDepidEqualTo(depid);
        List<TIllness> illnessList = illnessMapper.selectByExample(example);
        PageInfo<TIllness> pageInfo=new PageInfo<>(illnessList);
        long total = pageInfo.getTotal();//总条数
        long pages=((total+pageSize-1)/pageSize);
        JSONObject json = new JSONObject();
        json.put("pages",pages);
        json.put("data",illnessList);
        return json;
    }
}
