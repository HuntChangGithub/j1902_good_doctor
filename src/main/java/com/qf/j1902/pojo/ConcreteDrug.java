package com.qf.j1902.pojo;

import lombok.Data;

/**
 * Created by Administrator on 2019/7/27.
 */
@Data
public class ConcreteDrug {
    private Integer concretedrugID;
    private String concretedrugName;
    private String component;
    private String indication;
    private String useAndsize;
    private String badReaction;
    private String taboo;
    private String pointmatter;
    private String drugreaction;
    private String approveNum;
    private  String factoryName;

    public Integer getConcretedrugID() {
        return concretedrugID;
    }

    public void setConcretedrugID(Integer concretedrugID) {
        this.concretedrugID = concretedrugID;
    }

    public String getConcretedrugName() {
        return concretedrugName;
    }

    public void setConcretedrugName(String concretedrugName) {
        this.concretedrugName = concretedrugName;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getUseAndsize() {
        return useAndsize;
    }

    public void setUseAndsize(String useAndsize) {
        this.useAndsize = useAndsize;
    }

    public String getBadReaction() {
        return badReaction;
    }

    public void setBadReaction(String badReaction) {
        this.badReaction = badReaction;
    }

    public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    public String getPointmatter() {
        return pointmatter;
    }

    public void setPointmatter(String pointmatter) {
        this.pointmatter = pointmatter;
    }

    public String getDrugreaction() {
        return drugreaction;
    }

    public void setDrugreaction(String drugreaction) {
        this.drugreaction = drugreaction;
    }

    public String getApproveNum() {
        return approveNum;
    }

    public void setApproveNum(String approveNum) {
        this.approveNum = approveNum;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }
}
