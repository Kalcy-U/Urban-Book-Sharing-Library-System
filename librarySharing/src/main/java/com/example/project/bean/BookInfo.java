package com.example.project.bean;

public class BookInfo {
    private String isbn;

    private Integer bid;

    private String status;

    private Integer atstation;

    private Integer bnwid;

    private String name;

    private String author;

    private String publish;

    private Integer classId;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getAtstation() {
        return atstation;
    }

    public void setAtstation(Integer atstation) {
        this.atstation = atstation;
    }

    public Integer getBnwid() {
        return bnwid;
    }

    public void setBnwid(Integer bnwid) {
        this.bnwid = bnwid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish == null ? null : publish.trim();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}