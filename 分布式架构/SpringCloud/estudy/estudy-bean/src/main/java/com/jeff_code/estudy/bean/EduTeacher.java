package com.jeff_code.estudy.bean;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class EduTeacher {
    private Integer id;

    private String name;

    private String education;

    private Boolean isStar;

    private String picPath;

    private Byte status;

    @Temporal(TemporalType.DATE)
    private Date createTime;

    private Date updateTime;

    private Integer subjectId;

    private Integer sort;

    private String career;

    public EduTeacher(Integer id, String name, String education, Boolean isStar, String picPath, Byte status, Date createTime, Date updateTime, Integer subjectId, Integer sort, String career) {
        this.id = id;
        this.name = name;
        this.education = education;
        this.isStar = isStar;
        this.picPath = picPath;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.subjectId = subjectId;
        this.sort = sort;
        this.career = career;
    }

    public EduTeacher() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public Boolean getIsStar() {
        return isStar;
    }

    public void setIsStar(Boolean isStar) {
        this.isStar = isStar;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career == null ? null : career.trim();
    }
}