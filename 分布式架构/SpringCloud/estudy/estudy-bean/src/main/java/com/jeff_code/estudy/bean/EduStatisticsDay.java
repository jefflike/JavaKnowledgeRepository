package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduStatisticsDay {
    private Integer id;

    private Date statisticsTime;

    private Integer loginNum;

    private Date createTime;

    private Integer registeredNum;

    private Integer videoViewingNum;

    private Integer dailyUserNumber;

    private Integer dailyCourseNumber;

    public EduStatisticsDay(Integer id, Date statisticsTime, Integer loginNum, Date createTime, Integer registeredNum, Integer videoViewingNum, Integer dailyUserNumber, Integer dailyCourseNumber) {
        this.id = id;
        this.statisticsTime = statisticsTime;
        this.loginNum = loginNum;
        this.createTime = createTime;
        this.registeredNum = registeredNum;
        this.videoViewingNum = videoViewingNum;
        this.dailyUserNumber = dailyUserNumber;
        this.dailyCourseNumber = dailyCourseNumber;
    }

    public EduStatisticsDay() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStatisticsTime() {
        return statisticsTime;
    }

    public void setStatisticsTime(Date statisticsTime) {
        this.statisticsTime = statisticsTime;
    }

    public Integer getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(Integer loginNum) {
        this.loginNum = loginNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRegisteredNum() {
        return registeredNum;
    }

    public void setRegisteredNum(Integer registeredNum) {
        this.registeredNum = registeredNum;
    }

    public Integer getVideoViewingNum() {
        return videoViewingNum;
    }

    public void setVideoViewingNum(Integer videoViewingNum) {
        this.videoViewingNum = videoViewingNum;
    }

    public Integer getDailyUserNumber() {
        return dailyUserNumber;
    }

    public void setDailyUserNumber(Integer dailyUserNumber) {
        this.dailyUserNumber = dailyUserNumber;
    }

    public Integer getDailyCourseNumber() {
        return dailyCourseNumber;
    }

    public void setDailyCourseNumber(Integer dailyCourseNumber) {
        this.dailyCourseNumber = dailyCourseNumber;
    }
}