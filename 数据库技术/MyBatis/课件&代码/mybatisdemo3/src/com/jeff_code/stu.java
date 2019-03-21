package com.jeff_code;

public class stu {
    private Integer sid;
    private String sname;
    private  String addr;

    public stu(){

    }

    public stu(Integer sid, String sname, String addr) {
        this.sid = sid;
        this.sname = sname;
        this.addr = addr;
    }

    public Integer getId() {
        return sid;
    }

    public void setId(Integer id) {
        this.sid = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return getSname() + " in " + getAddr();
    }
}
