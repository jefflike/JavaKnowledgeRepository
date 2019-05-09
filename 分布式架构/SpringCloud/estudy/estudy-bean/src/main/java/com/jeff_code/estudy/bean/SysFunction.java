package com.jeff_code.estudy.bean;

import java.util.Date;

public class SysFunction {
    private Integer functionId;

    private Integer parentId;

    private String functionName;

    private String functionUrl;

    private Boolean functionType;

    private Date createTime;

    private Integer sort;

    private String imageUrl;

    public SysFunction(Integer functionId, Integer parentId, String functionName, String functionUrl, Boolean functionType, Date createTime, Integer sort, String imageUrl) {
        this.functionId = functionId;
        this.parentId = parentId;
        this.functionName = functionName;
        this.functionUrl = functionUrl;
        this.functionType = functionType;
        this.createTime = createTime;
        this.sort = sort;
        this.imageUrl = imageUrl;
    }

    public SysFunction() {
        super();
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl == null ? null : functionUrl.trim();
    }

    public Boolean getFunctionType() {
        return functionType;
    }

    public void setFunctionType(Boolean functionType) {
        this.functionType = functionType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }
}