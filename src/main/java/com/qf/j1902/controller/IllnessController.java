package com.qf.j1902.controller;

import com.alibaba.fastjson.JSONObject;
import com.qf.j1902.pojo.TDepartment;
import com.qf.j1902.pojo.TIllness;
import com.qf.j1902.service.DoctorService;
import com.qf.j1902.service.IllnessServiceH;
import com.qf.j1902.service.TDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 赵国林 on 2019/7/29.
 */
@Controller
public class IllnessController {
    @Autowired
    private IllnessServiceH illnessService;
    @Autowired
    private TDepartmentService departmentService;
    @Autowired
    private DoctorService doctorService;
    @RequestMapping("htIllnessList")
    public String showIllnessList(){
        //显示列表页面
        return "ht_Illness";
    }
    //获取全部疾病百科
    @RequestMapping(value = "IllnessList")
    @ResponseBody
    public String queryAllIllness(){
        List<TIllness> illnessList = illnessService.findAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count", illnessList.size());
        jsonObject.put("data", illnessList);
        return jsonObject.toString();
    }
    //updateIllness修改
    @RequestMapping(value = "updateIllness",method = RequestMethod.POST)
    @ResponseBody
    public String updateIllness(TIllness illness){
        int i = illnessService.updateIllnessById(illness);
        if (i==1){
            return "success";
        }
        return "error";
    }
    //delIllness删除
    @RequestMapping(value = "delIllness",method = RequestMethod.POST)
    @ResponseBody
    public String delHospitals(@RequestParam("idList")String idStr){
        String[] strings = idStr.split(",");
        List<Integer> idList=new ArrayList<>();
        for (int i=0;i<strings.length;i++) {
            Integer illid=Integer.parseInt(strings[i]);
            idList.add(illid);
        }
        boolean b = illnessService.delIllnessByIds(idList);
        if (b){
            return "success";
        }
        return "error";
    }
    //添加一条疾病百科
    @RequestMapping("showAddIllness")
    public String showAddIllness(){
        //显示该添加页面
        return "ht_addIllness";
    }
    //获得科室列表，提供给添加页面的select标签
    @RequestMapping("getDepartments")
    @ResponseBody
    public List<TDepartment> getDepartments(){
        List<TDepartment> departmentList = departmentService.getDepts();
        return departmentList;
    }
    //得到提交的百科信息，存入数据库
    @RequestMapping(value = "addIllness",method = RequestMethod.POST)
    @ResponseBody
    public String addIllness(TIllness illness){
        System.out.println(illness);
        int i = illnessService.addIllness(illness);
        if (i==1){
            return "success";
        }
        return "error";
    }
    //疾病百科用户显示界面
    @RequestMapping("diseaseencyclopedia")
    public String showIllness(){
        //显示页面
        return "Illness_list";
    }
    //diseaselist?page=1
    @RequestMapping("diseaselist")
    @ResponseBody
    public String diseaseList(@RequestParam(value = "page",defaultValue = "1")int page){
        //System.out.println(page);
        Integer pageSize=5;
        //分页查询
        JSONObject json = illnessService.findIllness(page, pageSize);
        return json.toString();
    }
    //showIllness
    @RequestMapping("showIllness")
    public String showIllnessInfo(@RequestParam("illid")Integer illid, Model model){
        //根据illid查询到百科对象的信息
        TIllness illness = illnessService.findIllnessById(illid);
        model.addAttribute("illness",illness);
        return "Illness_info";
    }
    //deptIllnesslist
    @RequestMapping("deptIllnesslist")
    @ResponseBody
    public String deptIllnesslist(@RequestParam("page")int page,@RequestParam("depid")int depid){
        Integer pageSize=5;
        JSONObject json = new JSONObject();
        if (depid==1){
            json = illnessService.findIllness(page, pageSize);
        }else {
            //分页查询
            json = illnessService.findIllnessByDepid(page, pageSize,depid);
        }
        return json.toString();
    }
}
