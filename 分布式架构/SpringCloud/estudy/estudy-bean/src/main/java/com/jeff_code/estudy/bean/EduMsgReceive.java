package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduMsgReceive {
    private Integer id;

    private Date addTime;

    private Integer cusId;

    private Date updateTime;

    private Byte type;

    private Byte status;

    private Integer receivingCusid;

    private Integer groupId;

    private String showname;

    private String content;

    public EduMsgReceive(Integer id, Date addTime, Integer cusId, Date updateTime, Byte type, Byte status, Integer receivingCusid, Integer groupId, String showname, String content) {
        this.id = id;
        this.addTime = addTime;
        this.cusId = cusId;
        this.updateTime = updateTime;
        this.type = type;
        this.status = status;
        this.receivingCusid = receivingCusid;
        this.groupId = groupId;
        this.showname = showname;
        this.content = content;
    }

    public EduMsgReceive() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getReceivingCusid() {
        return receivingCusid;
    }

    public void setReceivingCusid(Integer receivingCusid) {
        this.receivingCusid = receivingCusid;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname == null ? null : showname.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}