package com.qf.j1902.mapper;

import com.qf.j1902.pojo.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 赵国林 on 2019/7/25.
 */
@Mapper
public interface ProvinceMapper {
    public List<Province> findAll();
    public Province getProvByName(@Param("provName") String provName);
    public Province getProvById(@Param("provId") String provId);
}
