package com.qf.j1902.pojo;

import lombok.Data;


/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/24 17:25
 */
@Data
public class Doctor {
    private Integer doctorid;  //医生id
    private String username;   //用户名
    private String telphone;   //电话
    private Integer depid;     //部门id
    private String jobtitle;   //职称
    private String doctorinfo; //医生信息
    private Integer hpid;      //医院id
}
