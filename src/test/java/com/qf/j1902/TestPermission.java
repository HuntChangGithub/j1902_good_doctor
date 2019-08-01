package com.qf.j1902;

import com.qf.j1902.service.PermissionService;
import com.qf.j1902.vo.PermissionVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/8/1 9:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Configuration
public class TestPermission {
    @Autowired
    private PermissionService permissionService;

    @Test
    public void TestPermissionService(){
        List<Integer> pers = new ArrayList<>();
        pers.add(1);
        pers.add(2);
        pers.add(3);
        pers.add(4);
//        boolean b = permissionService.fuckPer(pers,1);
        boolean b = permissionService.setPer(pers,1);
        System.out.println(b);
//
        List<PermissionVo> allPerByRoleId = permissionService.getAllPerByRoleId(1);
        System.out.println(allPerByRoleId);
    }

}
