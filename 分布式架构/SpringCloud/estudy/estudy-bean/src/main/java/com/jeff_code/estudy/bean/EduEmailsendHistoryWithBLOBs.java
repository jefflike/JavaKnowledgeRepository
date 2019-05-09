package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduEmailsendHistoryWithBLOBs extends EduEmailsendHistory {
    private String email;

    private String content;

    public EduEmailsendHistoryWithBLOBs(Integer id, Integer userId, String title, Date createTime, Date sendTime, Byte status, Byte type, String email, String content) {
        super(id, userId, title, createTime, sendTime, status, type);
        this.email = email;
        this.content = content;
    }

    public EduEmailsendHistoryWithBLOBs() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}