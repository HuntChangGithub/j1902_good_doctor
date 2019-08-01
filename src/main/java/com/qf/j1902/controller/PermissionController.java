package com.qf.j1902.controller;

import com.alibaba.fastjson.JSON;
import com.qf.j1902.service.PermissionService;
import com.qf.j1902.vo.PermissionVo;
import com.qf.j1902.vo.TransferVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/30 21:05
 */
@Controller
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/main/permission")
    public String permissionPage(Integer roleid){
        List<PermissionVo> allPerByRoleId = permissionService.getAllPerByRoleId(roleid);
        List<Integer> perlist = new ArrayList<>();
        for (PermissionVo per: allPerByRoleId) {
            perlist.add(per.getPerid());
        }
        return "permissionMa";
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
