package com.geekhub.lesson8;

import java.lang.reflect.Field;

public class CloneCreator<T> {

    public Object createClone(T oldObject) throws Exception {
        String oldObjectClass = oldObject.getClass().getName();
        T newObject = (T) Class.forName(oldObjectClass).newInstance();

        Field[] fields = oldObject.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(newObject, field.get(oldObject));
        }

        return newObject;
    }
}
