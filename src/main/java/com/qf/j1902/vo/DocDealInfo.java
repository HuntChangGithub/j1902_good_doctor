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
    private String hpName;      //医院id
    private String depName;   //科室名称
    private String jobtitle;   //职称
    private String avatar;     //头像图片
    private String idcard;    //身份证照片
    private String certificateimg;  //医师资格证照片
    private String doctorinfo; //医生信息
    private Integer ifValid;      //是否审核通过
    private Integer answercount;   //回答数量
}
