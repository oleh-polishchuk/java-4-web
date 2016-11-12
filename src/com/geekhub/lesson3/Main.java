package com.geekhub.lesson3;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();
        StorageScanner storageScanner = new StorageScanner();

        String message = "=== Products Manager ===\n" +
                "1. Add product\n" +
                "2. Remove product\n" +
                "3. Print info\n" +
                "0. Exit\n";

        while (true) {
            Integer item = storageScanner.getIntForMessage(message);
            switch (item) {
                case 0: {
                    System.exit(0);
                }
                case 1: {
                    storage.add();
                    break;
                }
                case 2: {
                    storage.remove();
                    break;
                }
                case 3: {
                    storage.printInfo();
                    break;
                }
                default: {
                    System.out.printf("Item %d does not exist\n", item);
                }
            }
        }
    }
}
