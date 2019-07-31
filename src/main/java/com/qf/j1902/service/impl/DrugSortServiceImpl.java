package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.DrugSortMapper;
import com.qf.j1902.pojo.DrugSort;
import com.qf.j1902.service.DrugSortService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/7/27.
 */
@Service
public class DrugSortServiceImpl implements DrugSortService {
    @Autowired
    private DrugSortMapper drugSortMapper;
    @Override
    public List<DrugSort> getDrugSorts() {
        List<DrugSort> drugSorts=drugSortMapper.getDrugSorts();
        return drugSorts;
    }
}
