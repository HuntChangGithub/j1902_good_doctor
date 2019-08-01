package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.ChapterMapper;
import com.qf.j1902.mapper.CourseMapper;
import com.qf.j1902.pojo.Chapter;
import com.qf.j1902.pojo.Course;
import com.qf.j1902.service.OnlinCourseService;
import com.qf.j1902.vo.DoctorTutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by asus on 2019/7/29.
 */
@Service
public class OnlinCourseServiceImpl implements OnlinCourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ChapterMapper chapterMapper;
    @Override
    public List<DoctorTutorial> getCourses() {

        List<DoctorTutorial> courses = courseMapper.getCourses();
        return courses;
    }

    @Override
    public Course getCourseById(Integer courseid) {
        Course courseDetails = courseMapper.fetchCourseById(courseid);
        return courseDetails;
    }

    @Override
    public List<Chapter> getChapterByCourseId(Integer courseid) {
        List<Chapter> chapters = chapterMapper.getChapterByCourseId(courseid);
        return chapters;
    }

}
