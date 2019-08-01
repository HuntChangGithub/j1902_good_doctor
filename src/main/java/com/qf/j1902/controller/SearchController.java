package com.qf.j1902.controller;

import com.qf.j1902.pojo.ConcreteDrug;
import com.qf.j1902.pojo.TIllness;
import com.qf.j1902.service.ConcreteDrugService;
import com.qf.j1902.service.IllnessServiceH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 赵国林 on 2019/7/31.
 */
@Controller
public class SearchController {
    @Autowired
    private IllnessServiceH illnessService;
    @Autowired
    private ConcreteDrugService concreteDrugService;
//首页搜索功能
    @RequestMapping(value = "/indexSearch",method = RequestMethod.POST)
    public String indexSearch(@RequestParam("searchInput") String inputStr, Model model){
        //将输入结果分别将百科，药品对应的结果返回
        List<TIllness> illnessList = illnessService.findIllnessLikeillname(inputStr);
        model.addAttribute("illnessList",illnessList);
        List<ConcreteDrug> concreteDrugs = concreteDrugService.getConcreteDrugsByKeywords(inputStr);
        model.addAttribute("concreteDrugs",concreteDrugs);
        return "searchResult";
    }
}
