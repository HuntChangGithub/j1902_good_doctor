package com.qf.j1902.mapper;

import com.qf.j1902.pojo.UserPsarticle;
import com.qf.j1902.pojo.UserPsarticleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserPsarticleMapper {
    int countByExample(UserPsarticleExample example);

    int deleteByExample(UserPsarticleExample example);

    int insert(UserPsarticle record);

    int insertSelective(UserPsarticle record);

    List<UserPsarticle> selectByExample(UserPsarticleExample example);

    int updateByExampleSelective(@Param("record") UserPsarticle record, @Param("example") UserPsarticleExample example);

    int updateByExample(@Param("record") UserPsarticle record, @Param("example") UserPsarticleExample example);

    Integer getUserIDbyArticleID(Integer pscienceid);

    Integer getArticleIDbyUserID(Integer userid);
}