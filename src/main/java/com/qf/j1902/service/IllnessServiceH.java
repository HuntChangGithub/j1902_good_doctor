package com.qf.j1902.service;

import com.alibaba.fastjson.JSONObject;
import com.qf.j1902.pojo.TIllness;

import java.util.List;

/**
 * Created by 赵国林 on 2019/7/29.
 */
public interface IllnessServiceH {
    //疾病百科表全查
    public List<TIllness> findAll();
    //修改一条百科数据
    public int updateIllnessById(TIllness illness);
    //删除百科
    public boolean delIllnessByIds(List<Integer> idList);
    //添加一条百科数据
    public int addIllness(TIllness illness);
    //分页查询
    public JSONObject findIllness(Integer page, Integer pageSize);
    //查询一条百科信息
    public TIllness findIllnessById(Integer illid);
    //按科室查询并分页
    public JSONObject findIllnessByDepid(Integer page, Integer pageSize,Integer depid);
    //按百科illname字段模糊查询
    public List<TIllness> findIllnessLikeillname(String illname);
}
