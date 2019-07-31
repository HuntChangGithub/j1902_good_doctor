package com.qf.j1902.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2019/7/31.
 */
@Data
public class ArticleVo {
    private String fenlei;
    private String pstitle;
    private String psintroduce;
    private String pscontent;
    private String psimage;
    private String psAuthor;
    private String psAuthorInfo;
    private String psAuthorTel;
    private Date createtime;

}
