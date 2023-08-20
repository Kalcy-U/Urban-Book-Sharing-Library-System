package com.example.project.bean;

public class Book {
    private Integer bid;

    private String isbn;

    private String status;

    private Integer atstation;
    public Book()
    {
        bid = null;
        isbn = null;
        status = "在馆";
        atstation = null;
    }
    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
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
}