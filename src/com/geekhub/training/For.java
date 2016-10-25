package com.geekhub.training;

public class For {
    public static void main(String[] args) {
        int[] records = {99999999, 2, 3, 4, 5};

        for (int i = 0; i < records.length; i++) {
            System.out.println(records[i]);
        }

        for (int record : records) {
            System.out.println(record);
        }
    }
}
