package com.geekhub.lesson2;

public class Circle implements Shape{
    private double radius;
    private double area;
    private double perimeter;

    private final double PI = 3.14;

    public void setProperties() {
        setRadius();
    }

    public void calculateArea() {}

    public void calculatePerimeter() {}

    public void displayProperties() {
        Double area = this.area;
        Double perimeter = this.perimeter;

        System.out.println("Circle area is: " + area);
        System.out.println("Circle perimeter is: " + perimeter);
    }

    private void setRadius() {

    }
}
