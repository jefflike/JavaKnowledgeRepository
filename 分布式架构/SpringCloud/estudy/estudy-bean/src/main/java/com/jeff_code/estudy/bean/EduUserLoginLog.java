package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduUserLoginLog {
    private Integer logId;

    private Date loginTime;

    private String ip;

    private Integer userId;

    private String osName;

    private String userAgent;

    public EduUserLoginLog(Integer logId, Date loginTime, String ip, Integer userId, String osName, String userAgent) {
        this.logId = logId;
        this.loginTime = loginTime;
        this.ip = ip;
        this.userId = userId;
        this.osName = osName;
        this.userAgent = userAgent;
    }

    public EduUserLoginLog() {
        super();
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName == null ? null : osName.trim();
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }
}