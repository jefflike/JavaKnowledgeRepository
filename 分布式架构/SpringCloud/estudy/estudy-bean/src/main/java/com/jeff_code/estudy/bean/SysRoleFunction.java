package com.jeff_code.estudy.bean;

public class SysRoleFunction {
    private Integer roleId;

    private Integer functionId;

    public SysRoleFunction(Integer roleId, Integer functionId) {
        this.roleId = roleId;
        this.functionId = functionId;
    }

    public SysRoleFunction() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }
}