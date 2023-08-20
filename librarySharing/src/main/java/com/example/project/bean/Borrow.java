package com.example.project.bean;

import java.util.Date;

public class Borrow {
    private Integer borrowid;

    private Integer uid;

    private Integer bid;

    private Integer borrowat;

    private Integer renewal;

    private Date borrowtime;

    private Date duetime;

    private Date returntime;

    private String status;

    public Integer getBorrowid() {
        return borrowid;
    }

    public void setBorrowid(Integer borrowid) {
        this.borrowid = borrowid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getBorrowat() {
        return borrowat;
    }

    public void setBorrowat(Integer borrowat) {
        this.borrowat = borrowat;
    }

    public Integer getRenewal() {
        return renewal;
    }

    public void setRenewal(Integer renewal) {
        this.renewal = renewal;
    }

    public Date getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(Date borrowtime) {
        this.borrowtime = borrowtime;
    }

    public Date getDuetime() {
        return duetime;
    }

    public void setDuetime(Date duetime) {
        this.duetime = duetime;
    }

    public Date getReturntime() {
        return returntime;
    }

    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}