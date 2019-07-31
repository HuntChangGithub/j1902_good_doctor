package com.qf.j1902.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.j1902.pojo.Healtharticle;
import com.qf.j1902.pojo.User;
import com.qf.j1902.pojo.UserPsarticle;
import com.qf.j1902.service.HealthyService;
import com.qf.j1902.service.UserPsarticleService;
import com.qf.j1902.service.UserService;
import com.qf.j1902.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2019/7/24.
 */
@Controller
public class HealthyController {
    @Autowired
    private HealthyService healthyService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserPsarticleService userPsarticleService;

    //两性显示
    @RequestMapping(value = "liangxing",method = RequestMethod.GET)
    public String liangxing(Model model){
        List<Healtharticle> articles = healthyService.getHealthyArticles();
        List<Healtharticle> articles2;
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
    //详情页面
    @RequestMapping("/healthyXiangQing")
    public String healthyXiangQing(@RequestParam("pscienceid")Integer pscienceid, Model model,
                                   HttpSession session){
        Healtharticle article=healthyService.getHealthyArticleByID(pscienceid);
        model.addAttribute("article",article);
        Date createtime = article.getCreatetime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(createtime);
        model.addAttribute("createtime",format);
        session.setAttribute("pscienceid",pscienceid);
        return "healthyXiangQing";
    }
    //订阅文章
    @ResponseBody
    @RequestMapping(value = "dingyue",method = RequestMethod.POST)
    public String dingyue(@RequestParam("username")String uname,HttpSession session){
        List<User> userByName = userService.getUserByName(uname);
        User user = userByName.get(0);
        Integer userid = user.getUserid();
        Integer pscienceid =(Integer) session.getAttribute("pscienceid");
        Integer userid2=userPsarticleService.getUserIDbyArticleID(pscienceid);
        if (userid2==null){
            UserPsarticle userPsarticle = new UserPsarticle();
            userPsarticle.setUserid(userid);
            userPsarticle.setPscienceid(pscienceid);
            userPsarticleService.addDingYue(userPsarticle);
            return "订阅成功";
        }
        return "您已订阅";
    }
    @ResponseBody
    @RequestMapping(value = "panduandingyue",method = RequestMethod.POST)
    public String panduandingyue(@RequestParam("username")String uname,HttpSession session){
        System.out.println(uname);
        Integer pscienceid =(Integer) session.getAttribute("pscienceid");
        Integer userid = userPsarticleService.getUserIDbyArticleID(pscienceid);
        System.out.println(userid);
        if (userid==null){
            return "订阅";
        }else {
            return "已订阅";
        }
    }

    //判断登录的用户是不是医生，如果是医生，显示发起文章的按钮
    @ResponseBody
    @RequestMapping(value = "isfouDoctor",method = RequestMethod.POST)
    public JSONObject isfouDoctor(@RequestParam("username")String uname, HttpSession session){
        System.out.println(uname);
        JSONObject jsonObject = new JSONObject();
        List<User> userByName = userService.getUserByName(uname);
        User user = userByName.get(0);
        Integer userid = user.getUserid();
        String roleNameByUid = userService.getRoleNameByUid(userid);
        if(roleNameByUid.equals("doctor")){
            jsonObject.put("msg","医生");
            jsonObject.put("id",userid);
            return jsonObject;
        }
        jsonObject.put("msg","普通用户");
        return jsonObject;
    }

    //发起文章的方法
     @RequestMapping("startArticle")
     public String startArticle(@RequestParam("userid")Integer userid){
        // System.out.println(userid);
        return "startArticle";
     }

    @ResponseBody
    @RequestMapping(value = "addArticle",method = RequestMethod.POST)
    public JSONObject addArticle(@RequestParam(value = "inlineRadioOptions",defaultValue = "")String fenlei,
                                 @RequestParam(value = "pstitle",defaultValue = "")String pstitle,
                                 @RequestParam(value = "psintroduce",defaultValue = "")String psintroduce,
                                 @RequestParam(value = "pscontent",defaultValue = "")String pscontent,
                                 @RequestParam(value = "psimage")MultipartFile psimage,
                                 @RequestParam(value = "psAuthor",defaultValue = "")String psAuthor,
                                 @RequestParam(value = "psAuthorInfo",defaultValue = "")String psAuthorInfo,
                                 @RequestParam(value = "psAuthorTel",defaultValue = "")String psAuthorTel) throws ParseException {
         String upload="";
        System.out.println(fenlei);
        System.out.println(fenlei.equals("推荐"));
         if(fenlei.equals("推荐")){
             upload="tuijian";
         }else if(fenlei.equals("最新")){
             upload="zuixin";
         }else if(fenlei.equals("一图读懂")){
             upload="ytdudong";
         }else if(fenlei.equals("真相")){
             upload="zhenxiang";
         }else if(fenlei.equals("两性")){
             upload="liangxing";
         }else if(fenlei.equals("肿瘤")){
             upload="zhongliu";
         }else if(fenlei.equals("慢病")){
             upload="manbing";
         }
        System.out.println(upload);
         String path=new String("E:\\idea\\ideaProjects\\j1902_good_doctor\\src\\main\\resources\\static\\images");
         String filename = upload+"/"+psimage.getOriginalFilename();


         String location=path+"/"+filename;
         File file = new File(location);
        System.out.println(filename);
        try {
            file.createNewFile();
            psimage.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        Date date1 = dateFormat.parse(format);
        ArticleVo articleVo = new ArticleVo();
        articleVo.setFenlei(fenlei);//
        articleVo.setCreatetime(date1);//
        articleVo.setPsAuthor(psAuthor);//
        articleVo.setPstitle(pstitle);//
        articleVo.setPsintroduce(psintroduce);
        articleVo.setPsAuthorInfo(psAuthorInfo);//
        articleVo.setPscontent(pscontent);//
        articleVo.setPsAuthorTel(psAuthorTel);//
        articleVo.setPsimage(filename);//
        System.out.println(articleVo);
        boolean add=healthyService.addpsArticle(articleVo);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","添加成功");
        return jsonObject;
    }




    //慢病
    @RequestMapping(value = "manbing",method = RequestMethod.GET)
    public String manbing(Model model){
        List<Healtharticle> articles = healthyService.getHealthyArticlesManBing();
        List<Healtharticle> articles2;
        Map<Integer,List<Healtharticle>> map=new TreeMap<>();
        for (int i=0;i<articles.size()/3;i++){
            articles2 = new ArrayList<>();
            for(int j=0;j<3;j++){
                articles2.add(articles.get(i*2+j+i));
            }
            map.put(i+1,articles2);
        }
        model.addAttribute("map",map);
        return "manbing";
    }
    //推荐
    @RequestMapping(value = "tuijian",method = RequestMethod.GET)
    public String tuijain(Model model){
        List<Healtharticle> articles = healthyService.getHealthyArticlesTuiJian();
        List<Healtharticle> articles2;
        Map<Integer,List<Healtharticle>> map=new TreeMap<>();
        for (int i=0;i<articles.size()/3;i++){
            articles2 = new ArrayList<>();
            for(int j=0;j<3;j++){
                articles2.add(articles.get(i*2+j+i));
            }
            map.put(i+1,articles2);
        }
        model.addAttribute("map",map);
        return "tuijian";
    }
    //一图读懂
    @RequestMapping(value = "ytdudong",method = RequestMethod.GET)
    public String ytdudong(Model model){
        List<Healtharticle> articles = healthyService.getHealthyArticlesYtdudong();
        List<Healtharticle> articles2;
        Map<Integer,List<Healtharticle>> map=new TreeMap<>();
        for (int i=0;i<articles.size()/3;i++){
            articles2 = new ArrayList<>();
            for(int j=0;j<3;j++){
                articles2.add(articles.get(i*2+j+i));
            }
            map.put(i+1,articles2);
        }
        model.addAttribute("map",map);
        return "ytdudong";
    }
    //真相
    @RequestMapping(value = "zhenxiang",method = RequestMethod.GET)
    public String zhenxiang(Model model){
        List<Healtharticle> articles = healthyService.getHealthyArticlesZhenXiang();
        List<Healtharticle> articles2;
        Map<Integer,List<Healtharticle>> map=new TreeMap<>();
        for (int i=0;i<articles.size()/3;i++){
            articles2 = new ArrayList<>();
            for(int j=0;j<3;j++){
                articles2.add(articles.get(i*2+j+i));
            }
            map.put(i+1,articles2);
        }
        model.addAttribute("map",map);
        return "zhenxiang";
    }

    //肿瘤
    @RequestMapping(value = "zhongliu",method = RequestMethod.GET)
    public String zhongliu(Model model){
        List<Healtharticle> articles = healthyService.getHealthyArticlesZhongLiu();
        List<Healtharticle> articles2;
        Map<Integer,List<Healtharticle>> map=new TreeMap<>();
        for (int i=0;i<articles.size()/3;i++){
            articles2 = new ArrayList<>();
            for(int j=0;j<3;j++){
                articles2.add(articles.get(i*2+j+i));
            }
            map.put(i+1,articles2);
        }
        model.addAttribute("map",map);
        return "zhongliu";
    }
    //最新
    @RequestMapping(value = "zuixin",method = RequestMethod.GET)
    public String zuixin(Model model){
        List<Healtharticle> articles = healthyService.getHealthyArticlesZuiXin();
        List<Healtharticle> articles2;
        Map<Integer,List<Healtharticle>> map=new TreeMap<>();
        for (int i=0;i<articles.size()/3;i++){
            articles2 = new ArrayList<>();
            for(int j=0;j<3;j++){
                articles2.add(articles.get(i*2+j+i));
            }
            map.put(i+1,articles2);
        }
        model.addAttribute("map",map);
        return "zuixin";
    }
    @RequestMapping(value = "serachArticle",method = RequestMethod.GET)
    public String mohuSearch(@RequestParam(defaultValue = "",value = "keywords")String keywords,
                             @RequestParam(defaultValue = "1",value = "pn")Integer pn, Model model){
            System.out.println(keywords);
            if(StringUtils.isEmpty(keywords)){
                PageHelper.startPage(pn,9);
                List<Healtharticle> articlesAll = healthyService.getHealthyArticlesAll();
                System.out.println(articlesAll);
                List<Healtharticle> articles2;
                Map<Integer,List<Healtharticle>> map=new TreeMap<>();
                for (int i=0;i<articlesAll.size()/3;i++){
                    articles2 = new ArrayList<>();
                    for(int j=0;j<3;j++){
                        articles2.add(articlesAll.get(i*2+j+i));
                    }
                    map.put(i+1,articles2);
                }
                System.out.println(map+"map");
                PageInfo<Healtharticle> p=new PageInfo<>(articlesAll);
                System.out.println(p+"p");
                model.addAttribute("map",map);
                model.addAttribute("pageInfo", p);
                return "solrsearch";
            }
            PageHelper.startPage(pn,9);
            List<Healtharticle> healtharticles= healthyService.getHealthyArticlesByKeywords(keywords);
            PageInfo<Healtharticle> p=new PageInfo<>(healtharticles);
            List<Healtharticle> articles2;
            Map<Integer,List<Healtharticle>> map=new TreeMap<>();
            for (int i=0;i<healtharticles.size()/3;i++){
                articles2 = new ArrayList<>();
                for(int j=0;j<3;j++){
                    articles2.add(healtharticles.get(i*2+j+i));
                }
                map.put(i+1,articles2);
            }
            model.addAttribute("map",map);
            model.addAttribute("keywords",keywords);
            model.addAttribute("pageInfo", p);
            return "solrsearch";
    }
}
