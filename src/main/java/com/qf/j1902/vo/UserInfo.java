package com.qf.j1902.vo;

import lombok.Data;

/**
 * Created by asus on 2019/7/24.
 */
@Data
public class UserInfo {
    private String username; //登录用户名
    private String upassword;  //登录密码
    private String verifyCode;   //登录验证码
}
