package com.qf.j1902.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2019/7/24.
 */
@Controller
public class HealthyController {
    @RequestMapping(value = "liangxing",method = RequestMethod.GET)
    public String liangxing(){
        return "liangxing";
    }
    @RequestMapping(value = "manbing",method = RequestMethod.GET)
    public String manbing(){
        return "manbing";
    }
    @RequestMapping(value = "tuijian",method = RequestMethod.GET)
    public String tuijain(){
        return "tuijian";
    }
    @RequestMapping(value = "ytdudong",method = RequestMethod.GET)
    public String ytdudong(){
        return "ytdudong";
    }
    @RequestMapping(value = "zhenxiang",method = RequestMethod.GET)
    public String zhenxiang(){
        return "zhenxiang";
    }

    @RequestMapping(value = "zhongliu",method = RequestMethod.GET)
    public String zhongliu(){
        return "liangxing";
    }
    @RequestMapping(value = "zuixin",method = RequestMethod.GET)
    public String zuixin(){
        return "zuixin";
    }
}
