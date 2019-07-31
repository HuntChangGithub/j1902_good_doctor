package com.qf.j1902.vo;

import lombok.Data;

/**
 * Created by Administrator on 2019/7/30.
 */
@Data
public class SolrArticle {
    private long id;
    private String pstitle;
    private String psintroduce;
    private String psAuthor;
    private String psimage;
    private String pscontent;
    private String fenlei;
    private String createtime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPstitle() {
        return pstitle;
    }

    public void setPstitle(String pstitle) {
        this.pstitle = pstitle;
    }

    public String getPsintroduce() {
        return psintroduce;
    }

    public void setPsintroduce(String psintroduce) {
        this.psintroduce = psintroduce;
    }

    public String getPsAuthor() {
        return psAuthor;
    }

    public void setPsAuthor(String psAuthor) {
        this.psAuthor = psAuthor;
    }

    public String getPsimage() {
        return psimage;
    }

    public void setPsimage(String psimage) {
        this.psimage = psimage;
    }

    public String getPscontent() {
        return pscontent;
    }

    public void setPscontent(String pscontent) {
        this.pscontent = pscontent;
    }

    public String getFenlei() {
        return fenlei;
    }

    public void setFenlei(String fenlei) {
        this.fenlei = fenlei;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
