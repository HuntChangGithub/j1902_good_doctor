package com.qf.j1902.vo;

import lombok.Data;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/25 10:41
 */
@Data
public class DocDealInfo {
    private Integer doctorid;  //医生id
    private String username;   //用户名
    private String telphone;   //电话
    private Integer hpid;      //医院id
    private Integer depid;     //部门id
    private String jobtitle;   //职称
    private String doctorinfo; //医生信息
    private String diplomaimg; //文凭图
    private String certificateimg;//医师资格证图
    private Integer ifValid;    //是否有效，即审核结果
}
