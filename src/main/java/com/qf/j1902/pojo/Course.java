package com.qf.j1902.pojo;

import lombok.Data;

@Data
public class Course {
    private Integer courseid; //课程id

    private String coursetitle; //标题

    private String courseimg;  //课程图片

    private Double courseprice;  //价格

    private Integer coursejoinper; //购买人数

    private Integer doctorid;   //医生ID

    private String courseintro; //课程简介

    private String coursesuitper; //适合人群

    private String courseadvice; //审批意见

    private Integer couserTimes;  //总时长

    private Integer couserstatus;   //审批状态

    private String coursebigimg;  //课程大图片
}