package com.qf.j1902.pojo;

public class TIllness {
    private Integer illid;

    private String illname;//疾病名称

    private String illpart;//疾病标签1，发病部位

    private String illsort;//疾病标签2，疾病程度

    private String illcrowd;//疾病名称3，遗患人群

    private String illduc;//疾病描述，概要描述

    private String illinfo;//疾病症状描述

    private String illcause;//疾病病因描述

    private String diagnosis;//疾病如何诊断

    private String cure;//疾病如何治疗

    private String prevent;//疾病如何预防

    private Integer depid;//疾病所属科室ID

    public Integer getIllid() {
        return illid;
    }

    public void setIllid(Integer illid) {
        this.illid = illid;
    }

    public String getIllname() {
        return illname;
    }

    public void setIllname(String illname) {
        this.illname = illname == null ? null : illname.trim();
    }

    public String getIllpart() {
        return illpart;
    }

    public void setIllpart(String illpart) {
        this.illpart = illpart == null ? null : illpart.trim();
    }

    public String getIllsort() {
        return illsort;
    }

    public void setIllsort(String illsort) {
        this.illsort = illsort == null ? null : illsort.trim();
    }

    public String getIllcrowd() {
        return illcrowd;
    }

    public void setIllcrowd(String illcrowd) {
        this.illcrowd = illcrowd == null ? null : illcrowd.trim();
    }

    public String getIllduc() {
        return illduc;
    }

    public void setIllduc(String illduc) {
        this.illduc = illduc == null ? null : illduc.trim();
    }

    public String getIllinfo() {
        return illinfo;
    }

    public void setIllinfo(String illinfo) {
        this.illinfo = illinfo == null ? null : illinfo.trim();
    }

    public String getIllcause() {
        return illcause;
    }

    public void setIllcause(String illcause) {
        this.illcause = illcause == null ? null : illcause.trim();
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }

    public String getCure() {
        return cure;
    }

    public void setCure(String cure) {
        this.cure = cure == null ? null : cure.trim();
    }

    public String getPrevent() {
        return prevent;
    }

    public void setPrevent(String prevent) {
        this.prevent = prevent == null ? null : prevent.trim();
    }

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }
}