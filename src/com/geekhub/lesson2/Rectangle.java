package com.geekhub.lesson2;

public class Rectangle implements Shape{
    private double sideA;
    private double sideB;
    private double area;
    private double perimeter;

    public void setProperties() {
        setSideA();
        setSideB();
    }

    public void calculateArea() {}

    public void calculatePerimeter() {}

    public void displayProperties() {
        Double area = this.area;
        Double perimeter = this.perimeter;

        System.out.println("Rectangle area is: " + area);
        System.out.println("Rectangle perimeter is: " + perimeter);
    }

    private void setSideA() {}

    private void setSideB() {}
}
