package com.qf.j1902.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.qf.j1902.pojo.ConcreteDrug;
import com.qf.j1902.pojo.DrugSort;
import com.qf.j1902.pojo.Drugwu;
import com.qf.j1902.service.ConcreteDrugService;
import com.qf.j1902.service.DrugwuService;
import com.qf.j1902.service.DrugSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */
@Controller
public class FamilyDrugController {
    @Autowired
    private DrugSortService drugSortService;
    @Autowired
    private DrugwuService drugwuService;
    @Autowired
    private ConcreteDrugService concreteDrugService;
    @RequestMapping("/drugHelper")
    public String drugHelper(Model model){
        List<DrugSort> drugSorts = drugSortService.getDrugSorts();
        model.addAttribute("drugSorts",drugSorts);
        return "drugHelper";
    }
    /*@ResponseBody
    @RequestMapping(value = "queryDrugwu",method = RequestMethod.POST)
    public List<Drugwu> queryDrugwu(@RequestParam(value = "drugSortID",defaultValue = "1")Integer drugSortID){
        System.out.println(drugSortID);
        List<Drugwu> drugwus = drugwuService.getDrugwusBySortID(drugSortID);
        return drugwus;   //前台用eval()来转
    }*/
    @ResponseBody
    @RequestMapping(value = "queryDrugwu",method = RequestMethod.POST)
    public String queryDrugwu(@RequestParam(value = "drugSortID",defaultValue = "1")Integer drugSortID){
        System.out.println(drugSortID);
        List<Drugwu> drugwus = drugwuService.getDrugwusBySortID(drugSortID);
        //System.out.println(drugwus+"qqq");
      /*  Gson gson = new Gson();
        String string = gson.toJson(drugwus);*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",drugwus);
        String string = jsonObject.toString(); //前台用JSON.parse()来转
       // System.out.println(string+"jason");
        return string;
    }
    @RequestMapping(value = "drugHelperXiangQing",method = RequestMethod.GET)
    public String drugHelperXiangQing(@RequestParam("drugwuID")Integer drugwuID,Model model){
        System.out.println(drugwuID+"=drugwuID");
        Drugwu drugwu = drugwuService.getDrugwuByDrugwuID(drugwuID);
        List<ConcreteDrug> concreteDrugs = drugwuService.getConcreteDrugByDrugwuID(drugwuID);
       // System.out.println(concreteDrugs);
        model.addAttribute("concreteDrugs",concreteDrugs);
        model.addAttribute("drugwu",drugwu);
        return "drugHelperXiangQing";
    }

    @RequestMapping(value = "concreteDrug",method = RequestMethod.GET)
    public String concreteDrug(@RequestParam("concretedrugID")Integer concretedrugID,Model model){
        //System.out.println(concretedrugID);
        ConcreteDrug concreteDrug = concreteDrugService.getConcreteDrug(concretedrugID);
        model.addAttribute("concreteDrug",concreteDrug);
        return "drugXiangQing";
    }

    @RequestMapping(value = "serachDrugwu",method = RequestMethod.GET)
    public String serachDrugwu(@RequestParam(defaultValue = "",value = "keywords")String keywords,
                               @RequestParam(defaultValue = "1",value = "pn")Integer pn,Model model){
        if(StringUtils.isEmpty(keywords) || keywords.equals("undefined")){
            PageHelper.startPage(pn,3);
            List<ConcreteDrug> concreteDrugs=concreteDrugService.getConcreteDrugsAll();
            PageInfo<ConcreteDrug> pageInfo = new PageInfo<>(concreteDrugs);
            model.addAttribute("concreteDrugs",concreteDrugs);
            model.addAttribute("pageInfo",pageInfo);
            return "searchDrugwu";
        }
        PageHelper.startPage(pn,3);
        List<ConcreteDrug> concreteDrugs=concreteDrugService.getConcreteDrugsByKeywords(keywords);
        PageInfo<ConcreteDrug> pageInfo = new PageInfo<>(concreteDrugs);
        model.addAttribute("concreteDrugs",concreteDrugs);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("keywords",keywords);
        return "searchDrugwu";
    }
}
