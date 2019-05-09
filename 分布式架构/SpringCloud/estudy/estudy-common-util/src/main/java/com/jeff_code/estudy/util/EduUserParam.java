package com.jeff_code.estudy.util;

import java.io.Serializable;

public class EduUserParam implements Serializable{
    private String param ;
    private String createTime;
    private String lastSystemTime;
    private Boolean isAvalible;
    private int pageno;
    private int pagasize;

    public Boolean getIsAvalible() {
        return isAvalible;
    }

    public void setIsAvalible(Boolean avalible) {
        isAvalible = avalible;
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

    private String IDCheck;

    public String getIDCheck() {
        return IDCheck;
    }

    public void setIDCheck(String IDCheck) {
        this.IDCheck = IDCheck;
    }

    public EduUserParam() {
    }

    public EduUserParam(String param, String createTime, String lastSystemTime, Boolean isAvalible, int pageno, int pagasize, String IDCheck) {
        this.param = param;
        this.createTime = createTime;
        this.lastSystemTime = lastSystemTime;
        this.isAvalible = isAvalible;
        this.pageno = pageno;
        this.pagasize = pagasize;
        this.IDCheck = IDCheck;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastSystemTime() {
        return lastSystemTime;
    }

    public void setLastSystemTime(String lastSystemTime) {
        this.lastSystemTime = lastSystemTime;
    }

}
