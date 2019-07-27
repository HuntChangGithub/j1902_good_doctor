package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.TDepartmentMapper;
import com.qf.j1902.pojo.TDepartment;
import com.qf.j1902.pojo.TDepartmentExample;
import com.qf.j1902.service.TDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2019/7/26.
 */
@Service
public class TDepartmentServiceImpl implements TDepartmentService {
    @Autowired
    private TDepartmentMapper departmentMapper;

    //获取科室表信息
    @Override
    public List<TDepartment> getDepts() {
        TDepartmentExample tDepartmentExample = new TDepartmentExample();
        TDepartmentExample.Criteria criteria = tDepartmentExample.createCriteria();
        List<TDepartment> departments = departmentMapper.selectByExample(tDepartmentExample);
        return departments;
    }
}
