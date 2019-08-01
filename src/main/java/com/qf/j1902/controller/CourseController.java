package com.qf.j1902.controller;

import com.qf.j1902.pojo.Chapter;
import com.qf.j1902.pojo.Course;
import com.qf.j1902.pojo.Doctor;
import com.qf.j1902.service.DoctorService;
import com.qf.j1902.service.OnlinCourseService;
import com.qf.j1902.vo.DoctorTutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2019/7/29.
 */
@Controller
public class CourseController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private OnlinCourseService courseService;
    //ajax请求获取首页讲堂、医生推荐数据
    @RequestMapping(value = "/getIndexData" ,  method = RequestMethod.POST)
    @ResponseBody
    public Map<String,List<?>> getCourseData(@RequestParam("dept1") String dept1 ,
                                             @RequestParam("dept2") String dept2 ,
                                             @RequestParam("dept3") String dept3 ,
                                             @RequestParam("dept4") String dept4 ,
                                             @RequestParam("dept5") String dept5 ){
        //根据科室名称查询
        String string1 = dept1;
        List<Doctor> dept1Doc = doctorService.getDoctorsByDepName(string1);
        String string2 = dept2;
        List<Doctor> dept2Doc = doctorService.getDoctorsByDepName(string2);
        String string3 = dept3;
        List<Doctor> dept3Doc = doctorService.getDoctorsByDepName(string3);
        String string4 = dept4;
        List<Doctor> dept4Doc = doctorService.getDoctorsByDepName(string4);
        String string5 = dept5;
        List<Doctor> dept5Doc = doctorService.getDoctorsByDepName(string5);
        //查询医师讲堂数据
        List<DoctorTutorial> tutorials = courseService.getCourses();
        HashMap<String,List<?>> map = new HashMap<>();
        map.put("string1",dept1Doc);
        map.put("string2",dept2Doc);
        map.put("string3",dept3Doc);
        map.put("string4",dept4Doc);
        map.put("string5",dept5Doc);
        map.put("tutorial",tutorials);
        return map;
    }

    @RequestMapping(value = "onlinecourse" , method = RequestMethod.GET)
    public String getCourse(@RequestParam("courseid") Integer courseid , Model model){
        //获取课程信息
        Course course = courseService.getCourseById(courseid);
        model.addAttribute("course",course);
        //获取课程医师信息
        Integer doctorid = course.getDoctorid();
        Doctor doctor = doctorService.getDoctorById(doctorid);
        model.addAttribute("doctor",doctor);
        //获取课程章节信息
        List<Chapter>  chapters = courseService.getChapterByCourseId(courseid);
        model.addAttribute("chapters",chapters);
        return "onlinecourse";
    }
}
