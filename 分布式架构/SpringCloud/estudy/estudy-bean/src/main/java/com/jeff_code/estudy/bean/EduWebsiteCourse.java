package com.jeff_code.estudy.bean;

public class EduWebsiteCourse {
    private Integer id;

    private String name;

    private String link;

    private String description;

    private Integer coursenum;

    public EduWebsiteCourse(Integer id, String name, String link, String description, Integer coursenum) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.description = description;
        this.coursenum = coursenum;
    }

    public EduWebsiteCourse() {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getCoursenum() {
        return coursenum;
    }

    public void setCoursenum(Integer coursenum) {
        this.coursenum = coursenum;
    }
}