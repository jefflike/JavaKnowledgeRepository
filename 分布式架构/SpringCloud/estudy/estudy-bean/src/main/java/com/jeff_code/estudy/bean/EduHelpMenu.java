package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduHelpMenu {
    private Integer id;

    private Integer parentid;

    private String name;

    private Date createTime;

    private Integer sort;

    private String varchar;

    private String linkBuilding;

    private String content;

    public EduHelpMenu(Integer id, Integer parentid, String name, Date createTime, Integer sort, String varchar, String linkBuilding, String content) {
        this.id = id;
        this.parentid = parentid;
        this.name = name;
        this.createTime = createTime;
        this.sort = sort;
        this.varchar = varchar;
        this.linkBuilding = linkBuilding;
        this.content = content;
    }

    public EduHelpMenu() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getVarchar() {
        return varchar;
    }

    public void setVarchar(String varchar) {
        this.varchar = varchar == null ? null : varchar.trim();
    }

    public String getLinkBuilding() {
        return linkBuilding;
    }

    public void setLinkBuilding(String linkBuilding) {
        this.linkBuilding = linkBuilding == null ? null : linkBuilding.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}