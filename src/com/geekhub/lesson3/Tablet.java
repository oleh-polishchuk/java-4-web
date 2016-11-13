package com.geekhub.lesson3;

public class Tablet implements IProduct {

    private String name;
    private Integer price;
    private String description;
    private static Integer total = 0;

    public Tablet(String name, Integer price) {
        this.name = name;
        this.price = price;
        this.description = "Name: " + name + " Price: " + price;
        total++;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public String getCategory() {
        return "Tablet";
    }

    @Override
    public Integer getTotal() {
        return total;
    }

    @Override
    public void decreaseTotal() {
        total--;
    }

    @Override
    public String toString() {
        return description;
    }
}
