package com.qf.j1902.controller;

import com.qf.j1902.pojo.Healtharticle;
import com.qf.j1902.service.HealthyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2019/7/24.
 */
@Controller
public class HealthyController {
    @Autowired
    private HealthyService healthyService;

    @RequestMapping(value = "liangxing",method = RequestMethod.GET)
    public String liangxing(Model model){
        List<Healtharticle> articles = healthyService.getHealthyArticles();
        List<Healtharticle> articles2=new ArrayList<>();
        Map<Integer,List<Healtharticle>> map=new TreeMap<>();
        for (int i=0;i<articles.size()/3;i++){
            articles2 = new ArrayList<>();
            for(int j=0;j<3;j++){
                articles2.add(articles.get(i*2+j+i));
            }
            map.put(i+1,articles2);
        }
        model.addAttribute("map",map);
        return "liangxing";
    }
    @RequestMapping("/healthyXiangQing")
    public String healthyXiangQing(@RequestParam("pscienceid")Integer pscienceid,Model model){
        Healtharticle article=healthyService.getHealthyArticleByID(pscienceid);
        model.addAttribute("article",article);
        Date createtime = article.getCreatetime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(createtime);
        model.addAttribute("createtime",format);
        return "healthyXiangQing";
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
        return "zhongliu";
    }
    @RequestMapping(value = "zuixin",method = RequestMethod.GET)
    public String zuixin(){
        return "zuixin";
    }
}
