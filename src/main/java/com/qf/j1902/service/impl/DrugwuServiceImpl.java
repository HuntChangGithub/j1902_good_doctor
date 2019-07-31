package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.DrugwuMapper;
import com.qf.j1902.pojo.ConcreteDrug;
import com.qf.j1902.pojo.Drugwu;
import com.qf.j1902.service.DrugwuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/7/27.
 */
@Service
public class DrugwuServiceImpl implements DrugwuService {
    @Autowired
    private DrugwuMapper drugwuMapper;

    @Override
    public List<Drugwu> getDrugwusBySortID(Integer sortID) {
        List<Drugwu> drugwus = drugwuMapper.getDrugwusBySortID(sortID);
        return drugwus;
    }

    @Override
    public Drugwu getDrugwuByDrugwuID(Integer drugwuID) {
        Drugwu drugwu= drugwuMapper.getDrugwuByDrugwuID(drugwuID);
        return drugwu;
    }

    @Override
    public List<ConcreteDrug> getConcreteDrugByDrugwuID(Integer drugwuID) {
        List<ConcreteDrug> concreteDrugs=drugwuMapper.getConcreteDrugByDrugwuID(drugwuID);
        return concreteDrugs;
    }

}
