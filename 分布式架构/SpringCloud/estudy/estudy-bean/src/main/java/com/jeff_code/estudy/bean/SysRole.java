package com.jeff_code.estudy.bean;

import java.util.Date;

public class SysRole {
    private Integer roleId;

    private String roleName;

    private Date createTime;

    public SysRole(Integer roleId, String roleName, Date createTime) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.createTime = createTime;
    }

    public SysRole() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}