package com.geekhub.training;

public class Switch {
    public static void main(String[] args) {
        int userAge = 18;

        switch (userAge) {
            case 18:
                System.out.println("You're 18");
                break;
            case 20:
                System.out.println("You're 20");
                break;
            default:
                System.out.println("You're not 18 or 20");
        }
    }
}
