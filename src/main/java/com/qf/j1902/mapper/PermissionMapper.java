package com.qf.j1902.mapper;

import com.qf.j1902.vo.PermissionVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/31 14:37
 */
@Mapper
public interface PermissionMapper {
    int setPer(@Param("pers")List pers,@Param("roleid") Integer roleid);
    int fuckPer(@Param("pers") List pers,@Param("roleid")Integer roleid);
    List<PermissionVo> getAllPerByRoleId(@Param("roleid")Integer roleid);
}
