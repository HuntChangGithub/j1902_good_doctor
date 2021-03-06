package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.DocDealMapper;
import com.qf.j1902.service.DocDealService;
import com.qf.j1902.vo.DocDealInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/25 10:53
 */
@Service
public class DocDealServiceImpl implements DocDealService {

    @Autowired
    private DocDealMapper docDealMapper;
    @Override
    //获得医生审核信息
    public List<DocDealInfo> getAllDocDealInfo() {
        return docDealMapper.getAllDocDealInfo();
    }

    @Override
    public boolean passto(int id) {
        int passto = docDealMapper.passto(id);
        return passto>0;
    }

    @Override
    public boolean sealDoc(int id) {
        int i = docDealMapper.sealDoc(id);
        return i>0;
    }
}
