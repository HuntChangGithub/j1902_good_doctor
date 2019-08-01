package com.qf.j1902.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/7/30.
 */
@Data
public class SolrSearch {
    private long articleCount;
    private List<SolrArticle> data;

}
