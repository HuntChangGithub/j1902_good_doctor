package com.qf.j1902.vo;

import lombok.Data;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/25 10:41
 */
@Data
public class DocDealInfo {
    private Integer doctorid;
    private String username;
    private String telphone;
    private Integer hpid;
    private Integer depid;
    private String jobtitle;
    private String doctorinfo;
    private String diplomaimg;
    private String certificateimg;
    private Integer ifValid;
}
