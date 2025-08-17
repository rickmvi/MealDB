package com.github.rickmvi.com.mealdb.app.util;

import org.jetbrains.annotations.Contract;

@lombok.experimental.UtilityClass
public class Verify {

    @Contract(value = "null, _ -> fail", pure = true)
    public static void notNull(Object object, String message) {
        if (object == null) throw new IllegalArgumentException(message);
    }

    @Contract("null, _ -> fail")
    public static void notEmpty(String string, String message) {
        if (string == null || string.isEmpty()) throw new IllegalArgumentException(message);
    }

    @Contract(value = "true, _ -> fail", pure = true)
    public static void ifTrue(boolean condition, String message) {
        if (condition) throw new IllegalArgumentException(message);
    }

    @Contract(value = "false, _ -> fail", pure = true)
    public static void ifFalse(boolean condition, String message) {
        if (!condition) throw new IllegalArgumentException(message);
    }

    @Contract(value = "!null, _ -> fail", pure = true)
    public static void isNull(Object object, String message) {
        if (object != null) throw new IllegalArgumentException(message);
    }
}
