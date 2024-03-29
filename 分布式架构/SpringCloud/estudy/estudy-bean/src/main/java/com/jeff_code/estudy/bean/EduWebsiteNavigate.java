package com.jeff_code.estudy.bean;

public class EduWebsiteNavigate {
    private Integer id;

    private String name;

    private String url;

    private Byte newpage;

    private String type;

    private Integer ordernum;

    private Byte status;

    public EduWebsiteNavigate(Integer id, String name, String url, Byte newpage, String type, Integer ordernum, Byte status) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.newpage = newpage;
        this.type = type;
        this.ordernum = ordernum;
        this.status = status;
    }

    public EduWebsiteNavigate() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Byte getNewpage() {
        return newpage;
    }

    public void setNewpage(Byte newpage) {
        this.newpage = newpage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}