package com.qf.j1902.mapper;

import com.qf.j1902.pojo.Course;

import java.util.List;

import com.qf.j1902.vo.CourseDetails;
import com.qf.j1902.vo.DoctorTutorial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CourseMapper {
    public List<DoctorTutorial> getCourses();
    //根据id获取课程详情
    public Course fetchCourseById(Integer courseid);

}