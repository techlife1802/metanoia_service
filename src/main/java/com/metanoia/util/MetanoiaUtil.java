package com.metanoia.util;

import jakarta.persistence.Column;

import java.lang.reflect.Field;

public class MetanoiaUtil {

    public static String getColumnName(Class<?> clazz, String attributeName) {
        try {
            Field field = clazz.getDeclaredField(attributeName);
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                return column.name();
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("No such field found in the class");
        }
        return null;
    }
}
