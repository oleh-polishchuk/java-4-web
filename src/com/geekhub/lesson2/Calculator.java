package com.geekhub.lesson2;

import jdk.nashorn.internal.parser.Scanner;

public class Calculator {

    public Shape getInstanceOfSpecifiedFigureType(String nameOfFigure) {
        Shape instanceOfFigure;

        switch (nameOfFigure) {
            case "circle":
                instanceOfFigure = new Circle();
                break;
            case "square":
                instanceOfFigure = new Square();
                break;
            case "rectangle":
                instanceOfFigure = new Rectangle();
                break;
            case "triangle":
                instanceOfFigure = new Triangle();
                break;
            default:
                instanceOfFigure = new Square();
        }

        return instanceOfFigure;
    }

    public double getProperty(String propertyAsString) {
        return Double.parseDouble(propertyAsString);
    }
}
