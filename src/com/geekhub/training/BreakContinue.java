package com.geekhub.training;

public class BreakContinue {
    public static void main(String[] args) {
        int[] records = {99999999, 2, 3, 4, 5};

        for (int i = 0; i < records.length; i++) {
            if (i == 3) {
                break;
            }
            System.out.println(records[i]);
        }

        for (int record : records) {
            if (record == 3) {
                continue;
            }
            System.out.println(record);
        }


    }
}
