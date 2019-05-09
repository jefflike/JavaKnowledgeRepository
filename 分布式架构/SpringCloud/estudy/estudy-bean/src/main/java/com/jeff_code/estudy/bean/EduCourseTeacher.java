package com.jeff_code.estudy.bean;

public class EduCourseTeacher {
    private Integer courseId;

    private Integer teacherId;

    public EduCourseTeacher(Integer courseId, Integer teacherId) {
        this.courseId = courseId;
        this.teacherId = teacherId;
    }

    public EduCourseTeacher() {
        super();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}