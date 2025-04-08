package com.edex.commerce.model;

public class Product {
    private String name;
    private String desc;
    private double price;
    private String image;
    public Product(String name, String desc, double price, String image){
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    
}
