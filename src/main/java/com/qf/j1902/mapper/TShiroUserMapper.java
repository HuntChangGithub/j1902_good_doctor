package com.qf.j1902.mapper;

import com.qf.j1902.pojo.TShiroUser;
import com.qf.j1902.pojo.TShiroUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TShiroUserMapper {
    int countByExample(TShiroUserExample example);

    int deleteByExample(TShiroUserExample example);

    int insert(TShiroUser record);

    int insertSelective(TShiroUser record);

    List<TShiroUser> selectByExample(TShiroUserExample example);

    int updateByExampleSelective(@Param("record") TShiroUser record, @Param("example") TShiroUserExample example);

    int updateByExample(@Param("record") TShiroUser record, @Param("example") TShiroUserExample example);
}