package com.qf.j1902;

import com.alibaba.fastjson.JSON;
import com.qf.j1902.vo.TransferVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/31 11:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Configuration
public class TestTransfer {


    @Test
    public void testtransfer(){
        List<TransferVo> transferVos = JSON.parseArray("[{\"value\":\"1\",\"title\":\"权限1\"},{\"value\":\"2\",\"title\":\"权限1\"},{\"value\":\"3\",\"title\":\"权限1\"},{\"value\":\"4\",\"title\":\"权限1\"},{\"value\":\"6\",\"title\":\"权限1\"},{\"value\":\"7\",\"title\":\"权限1\"},{\"value\":\"8\",\"title\":\"权限1\"},{\"value\":\"9\",\"title\":\"权限1\"}]", TransferVo.class);
        System.out.println(transferVos);

    }
}
