package com.jeff_code.estudy.util;

public class TeacherParam {
    private String name;
    private String createTime;
    private String updateTime;
    private Integer isStar;
    private int pageno;
    private int pagasize;

    public TeacherParam() {
    }

    public TeacherParam(String name, String createTime, String updateTime, Integer isStar, int pageno, int pagasize) {
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isStar = isStar;
        this.pageno = pageno;
        this.pagasize = pagasize;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getPagasize() {
        return pagasize;
    }

    public void setPagasize(int pagasize) {
        this.pagasize = pagasize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsStar() {
        return isStar;
    }

    public void setIsStar(Integer isStar) {
        this.isStar = isStar;
    }
}
