package com.qf.j1902.vo;

import lombok.Data;

/**
 * Created by asus on 2019/7/30.
 */
@Data
public class DoctorTutorial {
    private Integer courseid;  //课程id
    private  String coursetitle;  //课程标题
    private  String courseimg;  //课程小图
    private String relname;  //作者真名
    private String jobtitle;  //作者职称
    private Integer coursejoinper; //购买人数

}
