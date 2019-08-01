package com.qf.j1902.mapper;

import com.qf.j1902.pojo.DoctorAndArticle;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2019/7/31.
 */
@Mapper
public interface DoctorAndArticleMapper {
    boolean addDoctorAndArticle(DoctorAndArticle doctorAndArticle);
}
