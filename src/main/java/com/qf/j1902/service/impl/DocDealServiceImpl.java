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
    public List<DocDealInfo> getAllDocDealInfo() {
        return docDealMapper.getAllDocDealInfo();
    }
}
