package com.geekhub.lesson2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Shape shape = getInstanceOfShape();
        shape.setProperties();
        shape.calculateArea();
        shape.calculatePerimeter();
        shape.displayProperties();
    }

    public static Shape getInstanceOfShape() {
        Shape instanceOfShape;

        String nameOfShape = getValidNameOfShapeAsString();
        switch (ShapeEnum.valueOf(nameOfShape)) {
            case CIRCLE:
                instanceOfShape = new Circle();
                break;
            case SQUARE:
                instanceOfShape = new Square();
                break;
            case RECTANGLE:
                instanceOfShape = new Rectangle();
                break;
            case TRIANGLE:
                instanceOfShape = new Triangle();
                break;
            default:
                instanceOfShape = new Square();
        }

        return instanceOfShape;
    }

    public static String getValidNameOfShapeAsString() {
        Scanner scanner = new Scanner(System.in);
        String resultNameOfShape = "";

        do {
            System.out.println("Enter string representation of particular shape:");
            String inputNameOfShape = scanner.nextLine().toUpperCase();

            for (ShapeEnum shape : ShapeEnum.values()) {
                if (shape.toString().equals(inputNameOfShape)) {
                    resultNameOfShape = shape.toString();
                }
            }

            if (!isNameOfShapeValid(resultNameOfShape)) {
                System.out.println("There aren't any shapes, that you enter.");
            }
        } while (!isNameOfShapeValid(resultNameOfShape));

        return resultNameOfShape;
    }

    private static boolean isNameOfShapeValid(String switchedNameOfShape) {
        return switchedNameOfShape.length() > 0;
    }

    public static Map getValidPropertiesOfShapeAsArray(String shape) {

        Map <String, Double> properties = new HashMap<>();
        do {
            switch (ShapeEnum.valueOf(shape)) {
                case CIRCLE:
                    properties = getPropertiesForCircleAsMap();
                    break;
//                case SQUARE:
//                    properties = getPropertiesForCircleAsMap();
//                    break;
//                case RECTANGLE:
//                    properties = getPropertiesForCircleAsMap();
//                    break;
//                case TRIANGLE:
//                    properties = getPropertiesForCircleAsMap();
//                    break;
            }
        } while (!isPropertiesOfShapeValid(properties));

        return properties;
    }

    private static boolean isPropertiesOfShapeValid(Map properties) {
        return properties.size() > 0;
    }

    private static Map getPropertiesForCircleAsMap() {
        Map <String, Double> properties = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String radius;
        do {
            System.out.println("Enter radius of circle:");
            radius = scanner.nextLine();

            if (!isRadiusValid(radius)) {
                System.out.println("Radius is wrong.");
            }
        } while (!isRadiusValid(radius));

        properties.put("radius", Double.parseDouble(radius));

        return properties;
    }

    private static boolean isRadiusValid(String radiusAsString) {
        return isDouble(radiusAsString) && Double.parseDouble(radiusAsString) > 0;
    }

    private static boolean isDouble(String numberAsString) {
        try {
            Double.parseDouble(numberAsString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
