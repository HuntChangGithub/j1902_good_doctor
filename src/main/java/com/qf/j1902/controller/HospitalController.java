package com.qf.j1902.controller;

import com.alibaba.fastjson.JSONObject;
import com.qf.j1902.pojo.City;
import com.qf.j1902.pojo.Province;
import com.qf.j1902.pojo.THospitals;
import com.qf.j1902.service.CityService;
import com.qf.j1902.service.HospitalService;
import com.qf.j1902.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 赵国林 on 2019/7/23.
 */
@Controller
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CityService cityService;
    @RequestMapping(value = "/hospital")
    public String hospitals(){
        //显示该页面

        return "ht_hospital";
    }
    //获取医院列表
    @RequestMapping(value = "/hospitalList",method = RequestMethod.GET)
    @ResponseBody
    public String showHospitals(){
        List<THospitals> hospitalsList = hospitalService.findAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", hospitalsList.size());
        jsonObject.put("data", hospitalsList);
        return jsonObject.toString();
    }
    //修改医院信息
    @RequestMapping(value = "/upHospital")
    @ResponseBody
    public String upHospital(THospitals hospital){
        //System.out.println(hospital);
        int i = hospitalService.updateHospital(hospital);
        if (i==1){
            return "success";
        }
        return "field";
    }
    //删除医院信息
    @RequestMapping(value = "/delHospitals")
    @ResponseBody
    public String delHospitals(@RequestParam("idList")String idStr){
        String[] strings = idStr.split(",");
        List<Integer> idList=new ArrayList<>();
        for (int i=0;i<strings.length;i++) {
           Integer hpid=Integer.parseInt(strings[i]);
           idList.add(hpid);
        }
        boolean b = hospitalService.delHospital(idList);
        if (b){
            return "success";
        }
        return "error";
    }
    //跳转新增一个医院信息页面
    @RequestMapping(value = "/showAddHospital")
    public String showAddHospital(){

        return "ht_addhospital";
    }
    //获得省份数据列表
    @RequestMapping(value = "/getprovinces")
    @ResponseBody
    public List<Province> getprovinces(){
        List<Province> provinceList = provinceService.findAll();
        return provinceList;
    }
    //获得省份数据列表
    @RequestMapping(value = "/getcitys")
    @ResponseBody
    public List<City> getcitys(@RequestParam("provinceid")String provinceid){
        List<City> cityList=null;
        if (!provinceid.isEmpty()){
            //根据provinceid查询city列表
            cityList = cityService.findCitysByProvinceId(provinceid);
        }
        return cityList;
    }
    //新增一个医院信息
    @RequestMapping(value = "/addhospital")
    @ResponseBody
    public String addhospital(THospitals hospital){
        System.out.println(hospital);
        int i = hospitalService.addHospital(hospital);
        if (i==1){
            return "success";
        }
        return "error";
    }
    @RequestMapping("/echarts")
    public String echarts(){
        return "hospitals_echarts";
    }
    @RequestMapping("/detail")
    @ResponseBody
    public Integer detail(@RequestParam(value = "name",defaultValue = "")String provName){
        if (!"".equals(provName)){
            //获取provinceid；
            Province province = provinceService.getProvByName(provName);
            Integer provinceid = Integer.parseInt(province.getProvinceid());
            //查询数据条数
            int i = hospitalService.countHospitalsByProvince(provinceid);
            return i;
        }
        return 0;
    }
}
