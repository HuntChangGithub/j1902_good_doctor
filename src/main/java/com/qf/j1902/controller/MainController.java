package com.qf.j1902.controller;

import com.qf.j1902.pojo.Healtharticle;
import com.qf.j1902.service.HealthyService;
import com.qf.j1902.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @auther mengyuan
 * @desc 由此控制器进入后台主页面
 * @date 2019/7/25 16:02
 */
@Controller
public class MainController {
    @Autowired
    private HealthyService healthyService;
    @RequestMapping("/main")
    public String mainPage(){
        return "main";
    }

    @RequestMapping("/main/userMa")
    public String userMaPage(){
        return "userMa";
    }

    @RequestMapping("/main/kepu")
    public String kepuPage(){
        return "jiankangkepuDeal";
    }

    @RequestMapping("/main/vido")
    public String vidoDeal(){
        return "videoDeal";
    }

    @RequestMapping("/main/answer")
    public String answerDeal(){
        return "answerDeal";
    }


    @ResponseBody
    @RequestMapping("/main/kepu/data")
    public Object getHealthData(){
        List<Healtharticle> healthyArticlesAll = healthyService.getHealthyArticlesAll();
        DataVo dataVo = new DataVo();
        dataVo.setCode(1);
        dataVo.setData(healthyArticlesAll);
        return dataVo;
    }
}
