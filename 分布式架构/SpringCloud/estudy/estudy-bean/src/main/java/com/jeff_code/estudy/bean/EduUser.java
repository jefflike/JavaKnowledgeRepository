package com.jeff_code.estudy.bean;

import javax.persistence.Id;
import java.util.Date;

public class EduUser {
    @Id
    private Integer userId;

    private String mobile;

    private String email;

    private String password;

    private String userName;

    private String showName;

    private Boolean sex;

    private Byte age;

    private Date createTime;

    private Boolean isAvalible;

    private String picImg;

    private String bannerUrl;

    private Integer msgNum;

    private Integer sysMsgNum;

    private Date lastSystemTime;

    public EduUser(Integer userId, String mobile, String email, String password, String userName, String showName, Boolean sex, Byte age, Date createTime, Boolean isAvalible, String picImg, String bannerUrl, Integer msgNum, Integer sysMsgNum, Date lastSystemTime) {
        this.userId = userId;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.showName = showName;
        this.sex = sex;
        this.age = age;
        this.createTime = createTime;
        this.isAvalible = isAvalible;
        this.picImg = picImg;
        this.bannerUrl = bannerUrl;
        this.msgNum = msgNum;
        this.sysMsgNum = sysMsgNum;
        this.lastSystemTime = lastSystemTime;
    }

    public EduUser() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsAvalible() {
        return isAvalible;
    }

    public void setIsAvalible(Boolean isAvalible) {
        this.isAvalible = isAvalible;
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg == null ? null : picImg.trim();
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl == null ? null : bannerUrl.trim();
    }

    public Integer getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(Integer msgNum) {
        this.msgNum = msgNum;
    }

    public Integer getSysMsgNum() {
        return sysMsgNum;
    }

    public void setSysMsgNum(Integer sysMsgNum) {
        this.sysMsgNum = sysMsgNum;
    }

    public Date getLastSystemTime() {
        return lastSystemTime;
    }

    public void setLastSystemTime(Date lastSystemTime) {
        this.lastSystemTime = lastSystemTime;
    }

    @Override
    public String toString() {
        return email;
    }
}