package com.qf.j1902.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/25 16:02
 */
@Controller
public class MainController {


    @RequestMapping("/main")
    public String mainPage(){
        return "main";
    }
}
