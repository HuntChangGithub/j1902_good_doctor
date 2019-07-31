package com.qf.j1902.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Healtharticle {
    private Integer pscienceid;

    private String pstitle;

    private String psintroduce;

    private String psauthor;

    private String psimage;

    private String fenlei;

    private Byte ifValid;

    private Date createtime;

    private String pscontent;


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

    public Byte getIfValid() {
        return ifValid;
    }

    public void setIfValid(Byte ifValid) {
        this.ifValid = ifValid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getPscontent() {
        return pscontent;
    }

    public void setPscontent(String pscontent) {
        this.pscontent = pscontent == null ? null : pscontent.trim();
    }
}