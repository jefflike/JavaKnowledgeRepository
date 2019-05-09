package com.jeff_code.estudy.bean;

public class EduWebsiteCourseDetail {
    private Integer id;

    private Integer recommendId;

    private Integer courseId;

    private Integer orderNum;

    public EduWebsiteCourseDetail(Integer id, Integer recommendId, Integer courseId, Integer orderNum) {
        this.id = id;
        this.recommendId = recommendId;
        this.courseId = courseId;
        this.orderNum = orderNum;
    }

    public EduWebsiteCourseDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Integer recommendId) {
        this.recommendId = recommendId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}