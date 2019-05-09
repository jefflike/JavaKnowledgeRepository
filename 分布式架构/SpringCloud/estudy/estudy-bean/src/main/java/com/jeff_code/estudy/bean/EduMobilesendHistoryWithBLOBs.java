package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduMobilesendHistoryWithBLOBs extends EduMobilesendHistory {
    private String mobile;

    private String content;

    public EduMobilesendHistoryWithBLOBs(Integer id, Integer userId, Date createTime, Date sendTime, Byte status, Byte type, String mobile, String content) {
        super(id, userId, createTime, sendTime, status, type);
        this.mobile = mobile;
        this.content = content;
    }

    public EduMobilesendHistoryWithBLOBs() {
        super();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}