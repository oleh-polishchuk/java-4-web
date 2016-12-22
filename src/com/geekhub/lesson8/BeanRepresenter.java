package com.geekhub.lesson8;

import java.lang.reflect.Field;

public class BeanRepresenter {

    public void represent(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        System.out.println("=> " + clazz.getSimpleName());
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + " " + field.get(object));
        }
        System.out.println();
    }
}
