package com.qf.j1902.vo;

import lombok.Data;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/25 16:46
 */
@Data
public class DataVo {
    private Integer count;  //data条数
    private Integer code = 0;//编码，通过此编码实现回调（未实现）
    private String msg = ""; //回调信息
    private List<?> data;//数据
}
