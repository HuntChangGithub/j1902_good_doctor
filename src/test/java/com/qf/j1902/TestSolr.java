package com.qf.j1902;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by Administrator on 2019/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSolr {
    @Test
    public void query() throws IOException, SolrServerException {
//		创建一个java访问solr服务的客户端对象
        HttpSolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr");
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");//设置查询条件
        QueryResponse queryResponse = solrServer.query(solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        for (SolrDocument doc : results) {
            //  Object id = doc.getFieldValue("id");
            Object fenlei = doc.getFieldValue("pstitle");
            System.out.println(fenlei);

        }
        System.out.println("doc insert solr ok！");
    }
}