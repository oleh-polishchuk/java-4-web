package com.geekhub.lesson4;

import java.io.File;
import java.util.Scanner;

public class ZipScanner {

    Scanner scanner;

    public ZipScanner() {
        scanner = new Scanner(System.in);
    }

    public String getDirPathForMessage(String message) {
        System.out.println(message);
        String dirPath = scanner.next();

        while (!isValidPath(dirPath)) {
            System.out.println("The directory name you entered is not valid.");
            System.out.println(message);
            dirPath = scanner.next();
        }

        File file = new File(dirPath);

        if (file.isDirectory()) {
            return file.getAbsolutePath();
        } else {
            return file.getParentFile().getAbsolutePath();
        }
    }

    private static Boolean isValidPath(String path) {
        File dest = new File(path);
        return dest.exists() && (dest.isDirectory() || dest.isFile());
    }
}
