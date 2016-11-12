package com.geekhub.lesson3;

import java.util.*;

public class Storage {

    Map<String, IProduct> storageProductMap = new HashMap<>();
    Map<String, Integer> storageCounterMap = new HashMap<>();

    StorageScanner storageScanner;

    public Storage() {
        storageScanner = new StorageScanner();
    }

    public void add() {
        String message = "=== Product Categories ===\n" +
                "1. Mobile\n" +
                "2. Tablet\n" +
                "3. Laptop\n";
        Integer item = storageScanner.getIntForMessage(message);
        switch (item) {
            case 1: {
                String name = storageScanner.getStringForMessage("Enter product name:");
                Integer price = storageScanner.getIntForMessage("Enter product price, ($):");
                if (!storageProductMap.containsKey(name)) {
                    storageCounterMap.put(Mobile.class.getName(), storageCounterMap.getOrDefault(Mobile.class.getName(), 0) + 1);
                }
                storageProductMap.put(name, new Mobile(name, price));
                break;
            }
            case 2: {
                String name = storageScanner.getStringForMessage("Enter product name:");
                Integer price = storageScanner.getIntForMessage("Enter product price, ($):");
                if (!storageProductMap.containsKey(name)) {
                    storageCounterMap.put(Tablet.class.getName(), storageCounterMap.getOrDefault(Tablet.class.getName(), 0) + 1);
                }
                storageProductMap.put(name, new Tablet(name, price));
                break;
            }
            case 3: {
                String name = storageScanner.getStringForMessage("Enter product name:");
                Integer price = storageScanner.getIntForMessage("Enter product price, ($):");
                if (!storageProductMap.containsKey(name)) {
                    storageCounterMap.put(Laptop.class.getName(), storageCounterMap.getOrDefault(Laptop.class.getName(), 0) + 1);
                }
                storageProductMap.put(name, new Laptop(name, price));
                break;
            }
            default: {
                System.out.printf("Item %d does not exist\n", item);
            }
        }
    }

    public void remove() {
        String name = storageScanner.getStringForMessage("Enter product name:");
        if (!storageProductMap.containsKey(name)) {
            System.out.printf("Item %s does not exist \n", name);
            return;
        }
        String itemClassName = storageProductMap.get(name).getClass().getName();
        storageCounterMap.put(itemClassName, storageCounterMap.get(itemClassName) - 1);
        storageProductMap.remove(name);
    }

    public void printInfo() {
        for (Map.Entry<String, IProduct> entry : storageProductMap.entrySet()) {
            IProduct product = entry.getValue();
            System.out.printf("Name: %s. Price: %d$ \n", product.getName(), product.getPrice());
        }

        Map<String, IProduct> uniqueProduct = getUnique(storageProductMap);
        for (Map.Entry<String, IProduct> entry : uniqueProduct.entrySet()) {
            IProduct product = entry.getValue();
            System.out.printf("Total in category %s: %d \n", product.getCategory(), product.getTotal());
        }
    }

    private static Map getUnique(Map<String, IProduct> records) {
        Map<String, IProduct> unique = new HashMap<>();
        for (Map.Entry<String, IProduct> entry : records.entrySet()) {
            IProduct product = entry.getValue();
            if (!unique.containsKey(product.getCategory())) {
                unique.put(product.getCategory(), entry.getValue());
            }
        }
        return unique;
    }
}
