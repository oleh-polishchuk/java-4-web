package com.geekhub.training;

public class DoWhile {
    public static void main(String[] args) {
        int index = 0;

        while (index <= 25) {
            System.out.println("Index: " + index);
            index++;
        }

        do {
            System.out.println("Index: " + index);
            index++;
        } while (index <=25);
    }
}
