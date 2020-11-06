package com.kgc.entity;

public class Dept {
    private Integer deptid;

    private String deptname;

    private String deptlocation;

    private Integer pdeptid;

    public Dept(Integer deptid, String deptname, String deptlocation, Integer pdeptid) {
        this.deptid = deptid;
        this.deptname = deptname;
        this.deptlocation = deptlocation;
        this.pdeptid = pdeptid;
    }

    public Dept() {
        super();
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getDeptlocation() {
        return deptlocation;
    }

    public void setDeptlocation(String deptlocation) {
        this.deptlocation = deptlocation == null ? null : deptlocation.trim();
    }

    public Integer getPdeptid() {
        return pdeptid;
    }

    public void setPdeptid(Integer pdeptid) {
        this.pdeptid = pdeptid;
    }
}