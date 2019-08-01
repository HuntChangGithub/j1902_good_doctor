package com.qf.j1902.vo;

import lombok.Data;

/**
 * Created by asus on 2019/7/29.
 */
@Data
public class CourseDetails {
    private Integer courseid; //课程id

    private String coursetitle; //标题

    private String courseimg;  //课程图片

    private Double courseprice;  //价格

    private Integer coursejoinper; //购买人数

    private String doctorname;   //医生姓名

    private String jobtitle;  //医生职称

    private String courseintro; //医生简介

    private String coursesuitper; //适合人群

    private String courseadvice; //审批意见

    private Integer couserTimes;  //总时长

    private Integer couserstatus;   //审批状态

    private Integer chapterid;  //章节ID

    private String chapterorder;  //章节顺序

    private String chaptername;   //章节名称

    private String chapterurl;   //章节连接

    private Integer chaptertimes;   // 章节时长
}
