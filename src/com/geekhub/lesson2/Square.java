package com.geekhub.lesson2;

public class Square implements Shape{
    private double side;
    private double area;
    private double perimeter;

    public void setProperties() {
        setSide();
    }

    public void calculateArea() {}

    public void calculatePerimeter() {}

    public void displayProperties() {
        Double area = this.area;
        Double perimeter = this.perimeter;

        System.out.println("Square area is: " + area);
        System.out.println("Square perimeter is: " + perimeter);
    }

    private void setSide() {

    }
}
