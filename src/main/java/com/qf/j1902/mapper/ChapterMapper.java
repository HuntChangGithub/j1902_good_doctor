package com.qf.j1902.mapper;

import com.qf.j1902.pojo.Chapter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by asus on 2019/7/29.
 */
@Mapper
public interface ChapterMapper {
    //根据id获取课程章节详情
    public List<Chapter> getChapterByCourseId(Integer courseid);
}
