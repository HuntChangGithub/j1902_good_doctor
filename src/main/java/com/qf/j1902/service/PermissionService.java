package com.qf.j1902.service;

import com.qf.j1902.pojo.TPermission;
import com.qf.j1902.vo.PermissionVo;

import java.util.List;
import java.util.Set;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/8/1 9:08
 */
public interface PermissionService {
    boolean setPer(List pers ,Integer roleid);
    boolean fuckPer(List pers,Integer roleid);
    List<PermissionVo> getAllPerByRoleId(Integer roleid);
    //根据用户名获取权限
    public Set<TPermission> getPermsByName(String principal);
}
