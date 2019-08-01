package com.qf.j1902.service;

import com.qf.j1902.vo.SolrSearch;

/**
 * Created by Administrator on 2019/7/30.
 */
public interface SolrSearchService {
    SolrSearch findSolrArticles(String keywords);

}
