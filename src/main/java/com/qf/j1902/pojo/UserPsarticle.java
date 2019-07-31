package com.qf.j1902.pojo;

import lombok.Data;

@Data
public class UserPsarticle {
    private Integer pscienceid;

    private Integer userid;

    public Integer getPscienceid() {
        return pscienceid;
    }

    public void setPscienceid(Integer pscienceid) {
        this.pscienceid = pscienceid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}