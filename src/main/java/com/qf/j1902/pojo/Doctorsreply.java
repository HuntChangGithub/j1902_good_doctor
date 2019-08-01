package com.qf.j1902.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 医生回复表
 * Created by xiaotaozi on 2019/7/25.
 */
@Data
public class Doctorsreply {
    private Integer id;//编码
    private String doctorName;//医生姓名
    private String departments;//科室
    private String questionResponse;//具体回复
    private String doctorsPicture;//医生图片
    private Timestamp responseTime;//具体回复时间
    private String userQuestionsID;//用户提问表编码
    private String hospitalAddress;//医院地址
    private String congYeNianXian;//从业年限
    private String hospital;//医院名称
}
