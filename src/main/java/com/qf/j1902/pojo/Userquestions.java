package com.qf.j1902.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 用户提问表
 * Created by xiaotaozi on 2019/7/25.
 */
@Data
public class Userquestions {
    private Integer id;//编码
    private String concreteProblems;//具体提问
    private Timestamp questionsTime;//提问时间
    private String picture;//上传图片
    private String NameOfDisease;//疾病名称
    private Integer userID;//用户表编码
}
