package com.neusoft.domain;
/**
 * 与数据中表字段一一对应的 实体类
 */

import java.sql.Date;

public class emp {
    private int empno;
    private String enamel;
    private String job;
    private int mgr;
    private Date hiredate;
    private int sal;
    private int comm;
    private int deptno;

    @Override
    public String toString() {
        return "emp{" +
                "empno=" + empno +
                ", enamel='" + enamel + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                '}';
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEnamel() {
        return enamel;
    }

    public void setEnamel(String enamel) {
        this.enamel = enamel;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getComm() {
        return comm;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public emp(int empno, String enamel, String job, int mgr, Date hiredate, int sal, int comm, int deptno) {
        this.empno = empno;
        this.enamel = enamel;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }
}
