package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduQuestions {
    private Integer id;

    private Integer cusId;

    private String title;

    private Integer type;

    private Integer status;

    private Integer replyCount;

    private Integer browseCount;

    private Integer praiseCount;

    private Date addTime;

    private String content;

    public EduQuestions(Integer id, Integer cusId, String title, Integer type, Integer status, Integer replyCount, Integer browseCount, Integer praiseCount, Date addTime, String content) {
        this.id = id;
        this.cusId = cusId;
        this.title = title;
        this.type = type;
        this.status = status;
        this.replyCount = replyCount;
        this.browseCount = browseCount;
        this.praiseCount = praiseCount;
        this.addTime = addTime;
        this.content = content;
    }

    public EduQuestions() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}