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
    private Integer count;
    private Integer code = 0;
    private String msg = "";
    private List<?> data;
}
