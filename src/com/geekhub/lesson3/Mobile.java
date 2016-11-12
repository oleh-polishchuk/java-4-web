package com.geekhub.lesson3;

public class Mobile implements IProduct {

    private String name;
    private Integer price;
    private String description;

    public Mobile(String name, Integer price) {
        this.name = name;
        this.price = price;
        this.description = "Name: " + name + " Price: " + price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String toString() {
        return description;
    }
}
