package com.geekhub.lesson8;

import java.lang.reflect.Field;

public class BeanComparator {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void compare(Object obj1, Object obj2) throws IllegalAccessException {
        Field[] fieldsObj1 = obj1.getClass().getDeclaredFields();
        Field[] fieldsObj2 = obj2.getClass().getDeclaredFields();

        if (fieldsObj1.length != fieldsObj2.length) {
            System.out.println("Object has diferrent number of fields");
            return;
        }

        System.out.println(ANSI_GREEN + "Field \tA \tB \tMatch" + ANSI_RESET);

        for (Field field : fieldsObj1) {
            field.setAccessible(true);
            System.out.println(field.getName() + "\t" + field.get(obj1) + "\t" + field.get(obj2) + "\t" + isEqual(field.get(obj1), field.get(obj2)));
        }
    }

    private static Boolean isEqual(Object fl1, Object fl2) {
        return fl1 == fl2;
    }
}
