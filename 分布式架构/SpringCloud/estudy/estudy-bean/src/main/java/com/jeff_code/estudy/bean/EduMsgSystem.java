package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduMsgSystem {
    private Integer id;

    private Date addTime;

    private Date updateTime;

    private Byte status;

    private String content;

    public EduMsgSystem(Integer id, Date addTime, Date updateTime, Byte status, String content) {
        this.id = id;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.status = status;
        this.content = content;
    }

    public EduMsgSystem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}