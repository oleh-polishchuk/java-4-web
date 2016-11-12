package com.geekhub.lesson3;

import java.util.Scanner;

public class StorageScanner {

    Scanner scanner;

    public StorageScanner() {
        scanner = new Scanner(System.in);
    }

    public Integer getIntForMessage(String message) {
        System.out.println(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Wrong value");
            System.out.println(message);
            scanner.next();
        }

        return scanner.nextInt();
    }

    public String getStringForMessage(String message) {
        System.out.println(message);
        return scanner.next();
    }
}
