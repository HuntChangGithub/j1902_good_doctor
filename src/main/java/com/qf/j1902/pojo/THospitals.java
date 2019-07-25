package com.qf.j1902.pojo;

import lombok.Data;

@Data
public class THospitals {
    private Integer hpid;

    private String hpname;

    private String hpaddress;

    private Integer provid;

    private Integer cityid;

    private String hptel;

    private String hpinfo;

    private String hpgrade;

    private String hpskill;

    public Integer getHpid() {
        return hpid;
    }

    public void setHpid(Integer hpid) {
        this.hpid = hpid;
    }

    public String getHpname() {
        return hpname;
    }

    public void setHpname(String hpname) {
        this.hpname = hpname == null ? null : hpname.trim();
    }

    public String getHpaddress() {
        return hpaddress;
    }

    public void setHpaddress(String hpaddress) {
        this.hpaddress = hpaddress == null ? null : hpaddress.trim();
    }

    public Integer getProvid() {
        return provid;
    }

    public void setProvid(Integer provid) {
        this.provid = provid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getHptel() {
        return hptel;
    }

    public void setHptel(String hptel) {
        this.hptel = hptel == null ? null : hptel.trim();
    }

    public String getHpinfo() {
        return hpinfo;
    }

    public void setHpinfo(String hpinfo) {
        this.hpinfo = hpinfo == null ? null : hpinfo.trim();
    }

    public String getHpgrade() {
        return hpgrade;
    }

    public void setHpgrade(String hpgrade) {
        this.hpgrade = hpgrade == null ? null : hpgrade.trim();
    }

    public String getHpskill() {
        return hpskill;
    }

    public void setHpskill(String hpskill) {
        this.hpskill = hpskill == null ? null : hpskill.trim();
    }
}