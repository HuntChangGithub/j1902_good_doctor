package com.qf.j1902.controller;

import com.alibaba.fastjson.JSONObject;
import com.qf.j1902.pojo.Healtharticle;
import com.qf.j1902.service.HealthyService;
import com.qf.j1902.service.SolrSearchService;
import com.qf.j1902.vo.SolrArticle;
import com.qf.j1902.vo.SolrSearch;
import netscape.javascript.JSObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2019/7/29.
 */
@Controller
public class SolrController {
    @Autowired
    private HealthyService healthyService;
    @Value("${solr.baseUrl}")
    private String baseUrl;
    @Autowired
    private SolrSearchService solrSearchService;

    @ResponseBody
    @RequestMapping(value = "importsolr")
    public JSONObject importsolr(){
        JSONObject jsObject = new JSONObject();
        List<Healtharticle> articles = healthyService.getHealthyArticlesAll();
        HttpSolrServer solrServer = new HttpSolrServer(baseUrl);
        try {
            for (Healtharticle article:articles ) {
                SolrInputDocument doc = new SolrInputDocument();
                doc.setField("id", article.getPscienceid());
                doc.setField("pstitle", article.getPstitle());
                doc.setField("psintroduce", article.getPsintroduce());
                doc.setField("psAuthor", article.getPsauthor());
                doc.setField("pscontent", article.getPscontent());
                doc.setField("createtime", article.getCreatetime());
                doc.setField("fenlei", article.getFenlei());
                solrServer.add(doc);
            }
            solrServer.commit();
            jsObject.put("setStatus",200);
            jsObject.put("msg","sucess");
            jsObject.put("data",null);
            return jsObject;
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            jsObject.put("setStatus",-1);
            jsObject.put("msg","导入失败");
            jsObject.put("data",null);
            return jsObject;//{"msg":"sucess","data":null,"setStatus":200}
    }
    @RequestMapping(value = "solr/serach",method = RequestMethod.GET)
    public String solrsearch(@RequestParam("keywords")String keywords, Model model) throws UnsupportedEncodingException {
        System.out.println(keywords);
        //此处必须对get请求的内容进行转码
        keywords = new String(keywords.getBytes("ISO-8859-1"), "UTF-8");
        SolrSearch solrSearch = solrSearchService.findSolrArticles(keywords);
        long articleCount = solrSearch.getArticleCount();
        List<SolrArticle> solrSearchData = solrSearch.getData();
        System.out.println(solrSearchData);
        List<SolrArticle> articles2;
        Map<Integer,List<SolrArticle>> map=new TreeMap<>();
        for (int i=0;i<solrSearchData.size()/3;i++){
            articles2 = new ArrayList<>();
            for(int j=0;j<3;j++){
                articles2.add(solrSearchData.get(i*2+j+i));
            }
            map.put(i+1,articles2);
        }
        model.addAttribute("map",map);
        model.addAttribute("keyword",keywords);
        model.addAttribute("totalPages",articleCount/3);
        return "solrsearch";
    }

}
