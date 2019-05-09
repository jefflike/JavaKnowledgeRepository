package com.jeff_code.estudy.bean;

public class EduCourseSubject {
    private Integer id;

    private Integer courseId;

    private Integer subjectId;

    public EduCourseSubject(Integer id, Integer courseId, Integer subjectId) {
        this.id = id;
        this.courseId = courseId;
        this.subjectId = subjectId;
    }

    public EduCourseSubject() {
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

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
}