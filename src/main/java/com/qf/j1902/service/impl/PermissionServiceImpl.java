package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.PermissionMapper;
import com.qf.j1902.service.PermissionService;
import com.qf.j1902.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/8/1 9:09
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public boolean setPer(List pers , Integer roleid) {
        int i = permissionMapper.setPer(pers,roleid );
        return i>0;
    }

    @Override
    public boolean fuckPer(List pers ,Integer roleid) {
        int i = permissionMapper.fuckPer(pers,roleid);
        return i>0;
    }

    @Override
    public List<PermissionVo> getAllPerByRoleId(Integer roleid) {
        return permissionMapper.getAllPerByRoleId(roleid);
    }
}
