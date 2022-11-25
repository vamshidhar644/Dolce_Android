package com.example.dolce_v3.Domain;

import java.io.Serializable;

public class CategoryListDomain implements Serializable {
    private String title;
    private String image;
    private String description;
    private Double price;
    private int NumberinCart;

    public CategoryListDomain(String title, String image, String description, Double price, int numberinCart) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.price = price;
        NumberinCart = numberinCart;
    }

    public CategoryListDomain(String title, String image, String description, Double price) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getNumberinCart() {
        return NumberinCart;
    }

    public void setNumberinCart(int numberinCart) {
        NumberinCart = numberinCart;
    }
}
