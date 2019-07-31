package com.qf.j1902.service.impl;

import com.qf.j1902.service.SolrSearchService;
import com.qf.j1902.vo.SolrArticle;
import com.qf.j1902.vo.SolrSearch;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/30.
 */
@Service
public class SolrSearchServiceImpl implements SolrSearchService{

    @Value("${solr.baseUrl}")
    private String baseUrl;

    @Override
    public SolrSearch findSolrArticles(String keywords) {
        SolrSearch solrSearch = new SolrSearch();
        HttpSolrServer solrServer = new HttpSolrServer(baseUrl);
        SolrQuery solrQuery = new SolrQuery();
        if(StringUtils.isEmpty(keywords)){
            solrQuery.setQuery("*:*");
        }else {
            solrQuery.setQuery(keywords);
        }
        //设置默认搜索域
        solrQuery.set("df", "item_keywords");
        try {
            QueryResponse response = solrServer.query(solrQuery);
            SolrDocumentList results = response.getResults();
            System.out.println(results);
            long numFound = results.getNumFound();
            List<SolrArticle> solrArticles=new ArrayList<>();
            for (SolrDocument doc:results) {
                SolrArticle solrArticle = new SolrArticle();
                //solrArticle.setId(Long.parseLong((String)doc.getFieldValue("id")));
                solrArticle.setPstitle((String) doc.getFieldValue("pstitle"));
                solrArticle.setPsintroduce((String) doc.getFieldValue("psintroduce"));
                solrArticle.setPsAuthor((String)doc.getFieldValue("psAuthor"));
                solrArticle.setPscontent((String)doc.getFieldValue("pscontent"));
                solrArticle.setFenlei((String)doc.getFieldValue("fenlei"));
                solrArticle.setCreatetime(((String)doc.getFieldValue("createtime")));
                solrArticles.add(solrArticle);
            }
            solrSearch.setArticleCount(numFound);
            solrSearch.setData(solrArticles);
            return solrSearch;
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
