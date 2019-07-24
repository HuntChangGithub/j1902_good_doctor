package com.qf.j1902.pojo;

import lombok.Data;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/24 17:25
 */
@Data
public class Doctor {
    private Integer doctorid;
    private String username;
    private String telphone;
    private Integer depid;
    private String jobtitle;
    private String doctorinfo;
    private Integer hpid;
    private Integer ifValid;
}
