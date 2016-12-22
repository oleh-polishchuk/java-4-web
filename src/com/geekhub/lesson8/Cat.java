package com.geekhub.lesson8;

public class Cat {

    private String color;
    private Integer age;
    private Integer legCount = 4;
    private Integer fullLength;

    public Cat() {}

    public Cat(String color, Integer age, Integer fullLength) {
        this.color = color;
        this.age = age;
        this.fullLength = fullLength;
    }
}
