package com.geekhub.lessons1;

import java.util.Arrays;
import java.util.Scanner;

public class Validator {
    public static final int NORMAL_NUMBER_LENGTH = 12;
    public static final String[] COUNTRY_CODE = {"380"};
    public static final String[] OPERATORS_CODE = {"63", "73", "93", "95", "96", "97", "98",};

    public void init() {
        String number = getValidPhoneNumber();
        int sum = getSumOfDigitsOfPhoneNumber(number);
        printResult(sum);
    }

    public String getValidPhoneNumber() {
        String number;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please enter the phone number:");
            number = scanner.nextLine().replaceAll("\\D+", "");

            if (isNumberLengthValid(number) && isCountryCodeValid(number) && isOperatorCodeValid(number)) {
                break;
            }

            System.out.println("Phone number is incorrect.");
        } while (true);

        System.out.println("Phone number is correct.");

        return number;
    }

    public Boolean isCountryCodeValid(String number) {
        String code = number.substring(0, 3);
        return Arrays.asList(COUNTRY_CODE).contains(code);
    }

    public Boolean isOperatorCodeValid(String number) {
        String code = number.substring(3, 5);
        return Arrays.asList(OPERATORS_CODE).contains(code);
    }

    public Boolean isNumberLengthValid(String number) {
        return number.length() == NORMAL_NUMBER_LENGTH;
    }

    public int getSumOfDigitsOfPhoneNumber(String number) {
        int sum;
        int round = 0;

        do {
            sum = 0;
            round++;

            for (int i = 0; i < number.length(); i++) {
                sum += Character.getNumericValue(number.charAt(i));
            }

            number = String.valueOf(sum);

            System.out.println(round + "st round of calculation, sum is: " + sum);
        } while (String.valueOf(sum).length() > 1);

        return sum;
    }

    public void printResult(int sum) {
        String prefix = "Final result is: ";
        switch (sum) {
            case 1:
                System.out.println(prefix + "One");
                break;
            case 2:
                System.out.println(prefix + "Two");
                break;
            case 3:
                System.out.println(prefix + "Tree");
                break;
            case 4:
                System.out.println(prefix + "Four");
                break;
            default:
                System.out.println(prefix + sum);
        }
    }
}
