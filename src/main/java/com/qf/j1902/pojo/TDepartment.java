package com.qf.j1902.pojo;

import lombok.Data;

@Data
public class TDepartment {
    private Integer depid;

    private String depname;

    private String deptimg;

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname == null ? null : depname.trim();
    }

    public String getDeptimg() {
        return deptimg;
    }

    public void setDeptimg(String deptimg) {
        this.deptimg = deptimg == null ? null : deptimg.trim();
    }
}