package com.example.SellRight;

import java.io.Serializable;

public class Product implements Serializable {
    public String name;
    public int price;
    public int imageRes;
    public String description;

    public Product(String name, int price, int imageRes, String description) {
        this.name = name;
        this.price = price;
        this.imageRes = imageRes;
        this.description = description;
    }
}
