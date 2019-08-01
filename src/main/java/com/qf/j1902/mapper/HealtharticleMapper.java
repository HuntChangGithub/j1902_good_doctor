package com.qf.j1902.mapper;

import com.qf.j1902.pojo.Healtharticle;
import com.qf.j1902.pojo.HealtharticleExample;
import java.util.List;

import com.qf.j1902.vo.ArticleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface HealtharticleMapper {
    int countByExample(HealtharticleExample example);

    int deleteByExample(HealtharticleExample example);

    int deleteByPrimaryKey(Integer pscienceid);

    int insert(Healtharticle record);

    int insertSelective(Healtharticle record);

    List<Healtharticle> selectByExampleWithBLOBs(HealtharticleExample example);

    List<Healtharticle> selectByExample(HealtharticleExample example);

    Healtharticle selectByPrimaryKey(Integer pscienceid);

    int updateByExampleSelective(@Param("record") Healtharticle record, @Param("example") HealtharticleExample example);

    int updateByExampleWithBLOBs(@Param("record") Healtharticle record, @Param("example") HealtharticleExample example);

    int updateByExample(@Param("record") Healtharticle record, @Param("example") HealtharticleExample example);

    int updateByPrimaryKeySelective(Healtharticle record);

    int updateByPrimaryKeyWithBLOBs(Healtharticle record);

    int updateByPrimaryKey(Healtharticle record);

    //添加科普文章的信息
    boolean addpsArticle(ArticleVo articleVo);

    Integer getHealthyArticleID();
}