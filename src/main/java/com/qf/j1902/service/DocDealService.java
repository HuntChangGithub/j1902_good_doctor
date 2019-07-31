package com.qf.j1902.service;

import com.qf.j1902.vo.DocDealInfo;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/25 10:52
 */
public interface DocDealService {
    //获得审核医生信息
    List<DocDealInfo> getAllDocDealInfo();
    //通过审核操作
    boolean passto(int id);
    //冻结该医生
    boolean sealDoc(int id);
}
