package com.qf.j1902.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @auther mengyuan
 * @desc 由此控制器进入后台主页面
 * @date 2019/7/25 16:02
 */
@Controller
public class MainController {
    //登录后才可访问的权限注释
    @RequiresPermissions(value={"authc"})
    @RequestMapping("/main")
    public String mainPage(){
        return "main";
    }
}
