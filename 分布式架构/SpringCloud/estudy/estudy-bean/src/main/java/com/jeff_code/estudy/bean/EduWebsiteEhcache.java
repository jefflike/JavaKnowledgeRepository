package com.jeff_code.estudy.bean;

public class EduWebsiteEhcache {
    private Integer id;

    private String ehcacheKey;

    private String ehcacheDesc;

    public EduWebsiteEhcache(Integer id, String ehcacheKey, String ehcacheDesc) {
        this.id = id;
        this.ehcacheKey = ehcacheKey;
        this.ehcacheDesc = ehcacheDesc;
    }

    public EduWebsiteEhcache() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEhcacheKey() {
        return ehcacheKey;
    }

    public void setEhcacheKey(String ehcacheKey) {
        this.ehcacheKey = ehcacheKey == null ? null : ehcacheKey.trim();
    }

    public String getEhcacheDesc() {
        return ehcacheDesc;
    }

    public void setEhcacheDesc(String ehcacheDesc) {
        this.ehcacheDesc = ehcacheDesc == null ? null : ehcacheDesc.trim();
    }
}