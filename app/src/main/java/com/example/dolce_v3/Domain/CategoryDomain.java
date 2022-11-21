package com.example.dolce_v3.Domain;

public class CategoryDomain {
    private String title;
    private String picture;

    public String getTitle() {
        return title;
    }

    public String getPicture() {
        return picture;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public CategoryDomain(String title, String picture){
        this.title = title;
        this.picture = picture;
    }
}
