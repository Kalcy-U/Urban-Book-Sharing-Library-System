package com.example.project.bean;

public class User {
    private Integer uid;

    private String username;

    private String phonenumber;

    private Integer credict;

    private String discription;

    private String password;

    private Boolean isvolunteer;

    private String ustatus;

    private String token;

    public User()
    {
        uid = null;
        username = null;
        phonenumber = null;
        credict = 100;
        discription = null;
        password = null;
        isvolunteer = false;
        ustatus = new String("正常");
        token = null;

    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public Integer getCredict() {
        return credict;
    }

    public void setCredict(Integer credict) {
        this.credict = credict;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription == null ? null : discription.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getIsvolunteer() {
        return isvolunteer;
    }

    public void setIsvolunteer(Boolean isvolunteer) {
        this.isvolunteer = isvolunteer;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus == null ? null : ustatus.trim();
    }
}