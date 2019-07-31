package com.qf.j1902.mapper;

import com.qf.j1902.pojo.THospitals;
import com.qf.j1902.pojo.THospitalsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface THospitalsMapper {
    int countByExample(THospitalsExample example);

    int deleteByExample(THospitalsExample example);

    int deleteByPrimaryKey(Integer hpid);

    int insert(THospitals record);

    int insertSelective(THospitals record);

    List<THospitals> selectByExample(THospitalsExample example);

    THospitals selectByPrimaryKey(Integer hpid);

    int updateByExampleSelective(@Param("record") THospitals record, @Param("example") THospitalsExample example);

    int updateByExample(@Param("record") THospitals record, @Param("example") THospitalsExample example);

    int updateByPrimaryKeySelective(THospitals record);

    int updateByPrimaryKey(THospitals record);

    List<THospitals> selectLikeSkill(@Param("hpskill") String hpskill);
}