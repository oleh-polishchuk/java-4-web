package com.geekhub.lesson2;

public class Triangle implements Shape{
    private double sideA;
    private double sideB;
    private double sideC;
    private double area;
    private double perimeter;

    public void setProperties() {
        setSideA();
        setSideB();
        setSideC();
    }

    public void calculateArea() {}

    public void calculatePerimeter() {}

    public void displayProperties() {
        Double area = this.area;
        Double perimeter = this.perimeter;

        System.out.println("Triangle area is: " + area);
        System.out.println("Triangle perimeter is: " + perimeter);
    }

    private void setSideA() {}

    private void setSideB() {}

    private void setSideC() {}
}
