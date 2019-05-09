package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduComment {
    private Integer commentId;

    private Integer userId;

    private Integer pCommentId;

    private String content;

    private Date addtime;

    private Integer otherId;

    private Integer praiseCount;

    private Integer replyCount;

    private Integer type;

    public EduComment(Integer commentId, Integer userId, Integer pCommentId, String content, Date addtime, Integer otherId, Integer praiseCount, Integer replyCount, Integer type) {
        this.commentId = commentId;
        this.userId = userId;
        this.pCommentId = pCommentId;
        this.content = content;
        this.addtime = addtime;
        this.otherId = otherId;
        this.praiseCount = praiseCount;
        this.replyCount = replyCount;
        this.type = type;
    }

    public EduComment() {
        super();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getpCommentId() {
        return pCommentId;
    }

    public void setpCommentId(Integer pCommentId) {
        this.pCommentId = pCommentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getOtherId() {
        return otherId;
    }

    public void setOtherId(Integer otherId) {
        this.otherId = otherId;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}