package com.qf.j1902.service;

import com.qf.j1902.pojo.Chapter;
import com.qf.j1902.pojo.Course;
import com.qf.j1902.vo.DoctorTutorial;

import java.util.List;

/**
 * Created by asus on 2019/7/29.
 */
public interface OnlinCourseService {
    //获取首页展示的课程信息
    public List<DoctorTutorial> getCourses();
    //根据id获取课程详情
    public Course getCourseById(Integer courseid);
    //根据id获取课程章节详情
    public List<Chapter> getChapterByCourseId(Integer courseid);
}
