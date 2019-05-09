package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduEmailsendHistory {
    private Integer id;

    private Integer userId;

    private String title;

    private Date createTime;

    private Date sendTime;

    private Byte status;

    private Byte type;

    public EduEmailsendHistory(Integer id, Integer userId, String title, Date createTime, Date sendTime, Byte status, Byte type) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.createTime = createTime;
        this.sendTime = sendTime;
        this.status = status;
        this.type = type;
    }

    public EduEmailsendHistory() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}