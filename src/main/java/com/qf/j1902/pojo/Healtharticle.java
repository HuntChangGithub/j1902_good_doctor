package com.qf.j1902.pojo;

import lombok.Data;

@Data
public class Healtharticle {
    private Integer pscienceid;//文章id

    private String pstitle;//文章标题

    private String psintroduce;//文章介绍

    private String psauthor;//文章作者

    private String psimage;//文章图片

    private String fenlei;//分类

    private String pscontent;//文章内容

    public Integer getPscienceid() {
        return pscienceid;
    }

    public void setPscienceid(Integer pscienceid) {
        this.pscienceid = pscienceid;
    }

    public String getPstitle() {
        return pstitle;
    }

    public void setPstitle(String pstitle) {
        this.pstitle = pstitle == null ? null : pstitle.trim();
    }

    public String getPsintroduce() {
        return psintroduce;
    }

    public void setPsintroduce(String psintroduce) {
        this.psintroduce = psintroduce == null ? null : psintroduce.trim();
    }

    public String getPsauthor() {
        return psauthor;
    }

    public void setPsauthor(String psauthor) {
        this.psauthor = psauthor == null ? null : psauthor.trim();
    }

    public String getPsimage() {
        return psimage;
    }

    public void setPsimage(String psimage) {
        this.psimage = psimage == null ? null : psimage.trim();
    }

    public String getFenlei() {
        return fenlei;
    }

    public void setFenlei(String fenlei) {
        this.fenlei = fenlei == null ? null : fenlei.trim();
    }

    public String getPscontent() {
        return pscontent;
    }

    public void setPscontent(String pscontent) {
        this.pscontent = pscontent == null ? null : pscontent.trim();
    }
}