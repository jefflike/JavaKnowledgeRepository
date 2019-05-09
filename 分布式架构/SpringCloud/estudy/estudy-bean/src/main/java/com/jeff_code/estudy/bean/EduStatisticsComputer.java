package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduStatisticsComputer {
    private Integer id;

    private Date statisticsTime;

    private String cpuUsage;

    private String memoryUsage;

    private String netUsage;

    public EduStatisticsComputer(Integer id, Date statisticsTime, String cpuUsage, String memoryUsage, String netUsage) {
        this.id = id;
        this.statisticsTime = statisticsTime;
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
        this.netUsage = netUsage;
    }

    public EduStatisticsComputer() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStatisticsTime() {
        return statisticsTime;
    }

    public void setStatisticsTime(Date statisticsTime) {
        this.statisticsTime = statisticsTime;
    }

    public String getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(String cpuUsage) {
        this.cpuUsage = cpuUsage == null ? null : cpuUsage.trim();
    }

    public String getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(String memoryUsage) {
        this.memoryUsage = memoryUsage == null ? null : memoryUsage.trim();
    }

    public String getNetUsage() {
        return netUsage;
    }

    public void setNetUsage(String netUsage) {
        this.netUsage = netUsage == null ? null : netUsage.trim();
    }
}