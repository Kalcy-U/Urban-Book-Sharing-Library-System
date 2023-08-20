package com.example.project.bean;

import java.util.Date;

public class Volunteer {
    private Integer uid;

    private String anthority;

    private Date startfrom;

    private String career;

    private String health;

    private Integer locid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAnthority() {
        return anthority;
    }

    public void setAnthority(String anthority) {
        this.anthority = anthority == null ? null : anthority.trim();
    }

    public Date getStartfrom() {
        return startfrom;
    }

    public void setStartfrom(Date startfrom) {
        this.startfrom = startfrom;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career == null ? null : career.trim();
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health == null ? null : health.trim();
    }

    public Integer getLocid() {
        return locid;
    }

    public void setLocid(Integer locid) {
        this.locid = locid;
    }
}