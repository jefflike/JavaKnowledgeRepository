package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduQuestionsComment {
    private Integer id;

    private Integer cusId;

    private Integer questionId;

    private String content;

    private Integer isBest;

    private Integer replyCount;

    private Integer praiseCount;

    private Date addTime;

    private Integer commentId;

    public EduQuestionsComment(Integer id, Integer cusId, Integer questionId, String content, Integer isBest, Integer replyCount, Integer praiseCount, Date addTime, Integer commentId) {
        this.id = id;
        this.cusId = cusId;
        this.questionId = questionId;
        this.content = content;
        this.isBest = isBest;
        this.replyCount = replyCount;
        this.praiseCount = praiseCount;
        this.addTime = addTime;
        this.commentId = commentId;
    }

    public EduQuestionsComment() {
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

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getIsBest() {
        return isBest;
    }

    public void setIsBest(Integer isBest) {
        this.isBest = isBest;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
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

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}