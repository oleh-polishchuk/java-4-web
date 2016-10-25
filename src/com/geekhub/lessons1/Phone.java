package com.geekhub.lessons1;

import java.util.Scanner;

public class Phone {

    /********************************************************/
    /*                                                      */
    /*   Example: +38 (063) 123-45-67                       */
    /*                                                      */
    /*   | country code | operator code | phone number |    */
    /*   | 380          | 63            | 1234567      |    */
    /*                                                      */
    /********************************************************/

    public static final int DEFAULT_NUMBER_LENGTH = 7;

    public static final String[] COUNTRY_CODE = {
            "380",      // International code of Ukraine
    };

    public static final String[] OPERATORS_CODE = {
            "63",       // Life
            "73",       // Life
            "93",       // Life
            "95",       // MTC, Vodafone
            "96",       // Kyivstar
            "97",       // Kyivstar
            "98",       // Kyivstar
    };

    public static void main(String[] args) {
        String phoneNumber = "";
        boolean isValidLength = false;
        boolean isValidCountryCode = false;
        boolean isValidOperatorCode = false;

        Scanner scanner = new Scanner(System.in);

        do {
            int requiredLength = DEFAULT_NUMBER_LENGTH;

            System.out.println("Please enter the phone number:");
            phoneNumber = scanner.nextLine().replaceAll("\\D+","");

            String countryCode = "";
            for (String code : COUNTRY_CODE) {
                if (phoneNumber.contains(code)) {
                    countryCode = phoneNumber.substring(0, code.length());
                    if (countryCode.equals(code)) {
                        isValidCountryCode = true;
                        requiredLength += code.length();
                        break;
                    }
                }
            }

            String operatorCode = "";
            for (String code : OPERATORS_CODE) {
                if (phoneNumber.contains(code) && isValidCountryCode) {
                    operatorCode = phoneNumber.substring(countryCode.length(), countryCode.length() + code.length());
                    if (operatorCode.equals(code)) {
                        isValidOperatorCode = true;
                        requiredLength += code.length();
                        break;
                    }
                }
            }

            if (phoneNumber.length() == requiredLength) {
                isValidLength = true;
            }

            if (!isValidCountryCode || !isValidOperatorCode || !isValidLength) {
                System.out.println("Phone number is incorrect.");
            }
        } while (!isValidCountryCode || !isValidOperatorCode || !isValidLength);

        System.out.println("Phone number is correct.");


        int sum;
        int round = 1;

        do {
            sum = 0;

            for (int i = 0; i < phoneNumber.length(); i++) {
                sum += Character.getNumericValue(phoneNumber.charAt(i));
            }

            System.out.println(round + "st round of calculation, sum is: " + sum);

            phoneNumber = String.valueOf(sum);
            round++;
        } while (String.valueOf(sum).length() > 1);


        switch (sum) {
            case 1:
                System.out.println("Final result is: One");
                break;
            case 2:
                System.out.println("Final result is: Two");
                break;
            case 3:
                System.out.println("Final result is: Tree");
                break;
            case 4:
                System.out.println("Final result is: Four");
                break;
            default:
                System.out.println("Final result is: " + sum);
        }
    }
}
