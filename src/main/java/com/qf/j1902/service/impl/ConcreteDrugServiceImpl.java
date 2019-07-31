package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.ConcreteDrugMapper;
import com.qf.j1902.pojo.ConcreteDrug;
import com.qf.j1902.service.ConcreteDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/7/29.
 */
@Service
public class ConcreteDrugServiceImpl implements ConcreteDrugService{
    @Autowired
    private ConcreteDrugMapper concreteDrugMapper;
    @Override
    public ConcreteDrug getConcreteDrug(Integer concreteDrugID) {
        ConcreteDrug concreteDrug=concreteDrugMapper.getConcreteDrug(concreteDrugID);
        return concreteDrug;
    }

    @Override
    public List<ConcreteDrug> getConcreteDrugsAll() {
       List<ConcreteDrug> concreteDrugs= concreteDrugMapper.getConcreteDrugsAll();
        return concreteDrugs;
    }

    @Override
    public List<ConcreteDrug> getConcreteDrugsByKeywords(String keywords) {
        List<ConcreteDrug> concreteDrugs=concreteDrugMapper.getConcreteDrugsByKeywords(keywords);
        return concreteDrugs;
    }
}
