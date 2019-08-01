package com.qf.j1902.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 赵国林 on 2019/7/31.
 */
@Controller
public class SearchController {
//首页搜索功能
    @RequestMapping(value = "/indexSearch",method = RequestMethod.POST)
    public String indexSearch(@RequestParam("searchInput") String inputStr, Model model){
        //将输入结果分别将百科，药品对应的结果返回

        return "searchResult";
    }
}
