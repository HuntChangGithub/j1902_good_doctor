package com.qf.j1902.controller;

import com.qf.j1902.service.DocDealService;
import com.qf.j1902.vo.DocDealInfo;
import com.qf.j1902.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/25 15:22
 */
@Controller
public class DealDoctorController {
    @Autowired
    private DocDealService docDealService;

    @RequestMapping("/main/dealdoctor")
    public String delDoctor(){
        return "docDeal";
    }
    @ResponseBody
    @RequestMapping("/main/dealdoctor/data")
    public Object dealDoctorData(){
        List<DocDealInfo> allDocDealInfo = docDealService.getAllDocDealInfo();
        DataVo infoVo = new DataVo();
        infoVo.setCount(allDocDealInfo.size());
        infoVo.setData(allDocDealInfo);
        return infoVo;
    }
}
