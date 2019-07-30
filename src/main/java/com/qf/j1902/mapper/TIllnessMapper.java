package com.qf.j1902.mapper;

import com.qf.j1902.pojo.TIllness;
import com.qf.j1902.pojo.TIllnessExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TIllnessMapper {
    int countByExample(TIllnessExample example);

    int deleteByExample(TIllnessExample example);

    int deleteByPrimaryKey(Integer illid);

    int insert(TIllness record);

    int insertSelective(TIllness record);

    List<TIllness> selectByExample(TIllnessExample example);

    TIllness selectByPrimaryKey(Integer illid);

    int updateByExampleSelective(@Param("record") TIllness record, @Param("example") TIllnessExample example);

    int updateByExample(@Param("record") TIllness record, @Param("example") TIllnessExample example);

    int updateByPrimaryKeySelective(TIllness record);

    int updateByPrimaryKey(TIllness record);
}