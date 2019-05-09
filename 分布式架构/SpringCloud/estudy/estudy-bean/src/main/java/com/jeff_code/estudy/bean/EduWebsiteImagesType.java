package com.jeff_code.estudy.bean;

public class EduWebsiteImagesType {
    private Integer typeId;

    private String typeName;

    public EduWebsiteImagesType(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public EduWebsiteImagesType() {
        super();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}