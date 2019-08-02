package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.PermissionMapper;
import com.qf.j1902.pojo.TPermission;
import com.qf.j1902.service.PermissionService;
import com.qf.j1902.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public Set<TPermission> getPermsByName(String principal) {
        Set<TPermission> perms = new HashSet<>();
        List<TPermission> permsByName = permissionMapper.getPermsByName(principal);
        for (TPermission perm: permsByName  ) {
            perms.add(perm);
        }
        return perms;
    }
}
