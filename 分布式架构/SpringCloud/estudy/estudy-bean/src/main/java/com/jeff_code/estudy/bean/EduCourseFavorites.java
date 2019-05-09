package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduCourseFavorites {
    private Integer id;

    private Integer courseId;

    private Integer userId;

    private Date addTime;

    public EduCourseFavorites(Integer id, Integer courseId, Integer userId, Date addTime) {
        this.id = id;
        this.courseId = courseId;
        this.userId = userId;
        this.addTime = addTime;
    }

    public EduCourseFavorites() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}