package com.jeff_code;

public class stu {
    private Integer id;
    private String name;
    private Integer age;

    public stu(){

    }

    public stu(Integer sid, String sname, Integer addr) {
        this.id = sid;
        this.name = sname;
        this.age = addr;
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
        this.name = name;
    }

    public Integer getAddr() {
        return age;
    }

    public void setAddr(Integer addr) {
        this.age = addr;
    }

    @Override
    public String toString() {
        return getName() + " in " + getAddr();
    }
}
