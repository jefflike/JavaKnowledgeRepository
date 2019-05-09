package com.jeff_code.estudy.bean;

import javax.persistence.Id;
import java.util.Date;

public class SysSubject {
    @Id
    private Integer subjectId;

    private String subjectName;

    private Boolean status;

    private Date createTime;

    private Integer parentId;

    private Integer sort;

    public SysSubject(Integer subjectId, String subjectName, Boolean status, Date createTime, Integer parentId, Integer sort) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.status = status;
        this.createTime = createTime;
        this.parentId = parentId;
        this.sort = sort;
    }

    public SysSubject() {
        super();
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}