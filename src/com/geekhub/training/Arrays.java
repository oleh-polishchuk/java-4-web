package com.geekhub.training;

public class Arrays {
    public static void main(String[] args) {
        int[] a = new int[3];

        a[0] = 10;
        a[1] = 20;
        a[2] = 30;

        System.out.println(a.length);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        int[][] b = new int[2][2];

        b[0][0] = 1;
        b[0][1] = 2;
        b[1][0] = 3;
        b[1][1] = 4;

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.println(b[i][j]);
            }
        }

    }
}
