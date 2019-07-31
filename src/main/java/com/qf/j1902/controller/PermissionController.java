package com.qf.j1902.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qf.j1902.vo.TransferVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/30 21:05
 */
@Controller
public class PermissionController {

    @RequestMapping("/main/permission")
    public String permissionPage(){
        return "permissionMa";
    }

    @ResponseBody
    @RequestMapping("/main/permission/transfer")
    public String setRolePermission(@RequestBody() String transferJson){
        System.out.println(transferJson);
        List<TransferVo> transferVos = JSON.parseArray(transferJson, TransferVo.class);
        System.out.println(transferVos);
        return "1";
    }
}
