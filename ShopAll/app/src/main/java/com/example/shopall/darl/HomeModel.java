package com.example.shopall.darl;

public class HomeModel {

    private String id;
    private  String name;
    private  float price;

    private  int image;


    public HomeModel(String id) {
        this.id = new String();

    }

    public HomeModel(String name, float price, int image) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }


    public String getId() {
        return id;
    }


    public void setPrice(float price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
