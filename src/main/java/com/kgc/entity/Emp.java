package com.kgc.entity;

public class Emp {
    private Integer empno;

    private String ename;

    private Integer salary;

    private Integer mgr;

    private Integer deptid;

    public Emp(Integer empno, String ename, Integer salary, Integer mgr, Integer deptid) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
        this.mgr = mgr;
        this.deptid = deptid;
    }

    public Emp() {
        super();
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }
}