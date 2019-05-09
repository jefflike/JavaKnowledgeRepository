package com.jeff_code.estudy.bean;

public class EduWebsiteProfile {
    private Integer id;

    private String type;

    private String explain;

    private String desciption;

    public EduWebsiteProfile(Integer id, String type, String explain, String desciption) {
        this.id = id;
        this.type = type;
        this.explain = explain;
        this.desciption = desciption;
    }

    public EduWebsiteProfile() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption == null ? null : desciption.trim();
    }
}