package com.qf.j1902.controller;

import com.alibaba.fastjson.JSON;
import com.qf.j1902.service.PermissionService;
import com.qf.j1902.vo.PermissionVo;
import com.qf.j1902.vo.TransferVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/30 21:05
 */
@Controller
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    //到权限管理的页面
    @RequestMapping("/main/permission")
    public String permissionPage(){
        return "permissionMa";
    }

    //根据角色id获取当前权限
    @ResponseBody
    @RequestMapping("/main/permission/data")
    public List permissionData(@RequestParam("roleid") Integer roleid){
        System.out.println("roleid"+roleid);
        List<PermissionVo> allPerByRoleId = permissionService.getAllPerByRoleId(roleid);
        System.out.println("per"+allPerByRoleId);
        List<Integer> perlist = new ArrayList<>();
        for (PermissionVo per: allPerByRoleId) {
            perlist.add(per.getPerid());
            System.out.println("aaaa"+perlist);
        }
        return perlist;
    }

    /**
     *
     * @param transferJson 前台传来的穿梭数据
     * @param roleid 角色id
     * @param dofor 控制器指令，L增加权限，R删除权限
     * @return
     */
    @ResponseBody
    @RequestMapping("/main/permission/transfer")
    public String setRolePermission(String transferJson,Integer roleid ,String dofor){

        //将json转为对象
        List<TransferVo> transferVos = JSON.parseArray(transferJson, TransferVo.class);

        //将value取出，存入list
        List<Integer> pers = new ArrayList<>();
        for (TransferVo transVo:transferVos) {
            pers.add(transVo.getValue());
        }

        //做出增加或删除动作
        if ("l".equals(dofor)){//L说明从左边到右边，即为添加
            if (permissionService.setPer(pers, roleid)){//添加成功返回1
                return "1";
            }
        } else{
            if (permissionService.fuckPer(pers, roleid)){//删除成功返回1
                return "1";
            }
        }
        return "0";//失败返回0
    }

}
