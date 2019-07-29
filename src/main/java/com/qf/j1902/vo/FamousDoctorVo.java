package com.qf.j1902.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by xiaotaozi on 2019/7/27.
 */
@Data
public class FamousDoctorVo {
    private Integer id;//编码
    private String doctorName;//医生姓名
    private String departments;//科室
    private String questionResponse;//具体回复
    private Timestamp responseTime;//具体回复时间
    private String userQuestionsID;//用户提问表编码
    private String doctorsPicture;//医生图片
    //private Integer id;//编码
    private String concreteProblems;//具体提问
    private Timestamp questionTime;//提问时间
    private String picture;//上传图片
    private String NameOfDisease;//疾病名称
    private Integer userID;//用户表编码
}
