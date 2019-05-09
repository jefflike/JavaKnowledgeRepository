package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduPraise {
    private Integer id;

    private Integer userId;

    private Integer targetId;

    private Integer type;

    private Date addTime;

    public EduPraise(Integer id, Integer userId, Integer targetId, Integer type, Date addTime) {
        this.id = id;
        this.userId = userId;
        this.targetId = targetId;
        this.type = type;
        this.addTime = addTime;
    }

    public EduPraise() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}