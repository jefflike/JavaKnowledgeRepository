package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduQuestionsTag {
    private Integer questionsTagId;

    private String questionsTagName;

    private Integer status;

    private Date createTime;

    private String parentId;

    public EduQuestionsTag(Integer questionsTagId, String questionsTagName, Integer status, Date createTime, String parentId) {
        this.questionsTagId = questionsTagId;
        this.questionsTagName = questionsTagName;
        this.status = status;
        this.createTime = createTime;
        this.parentId = parentId;
    }

    public EduQuestionsTag() {
        super();
    }

    public Integer getQuestionsTagId() {
        return questionsTagId;
    }

    public void setQuestionsTagId(Integer questionsTagId) {
        this.questionsTagId = questionsTagId;
    }

    public String getQuestionsTagName() {
        return questionsTagName;
    }

    public void setQuestionsTagName(String questionsTagName) {
        this.questionsTagName = questionsTagName == null ? null : questionsTagName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }
}