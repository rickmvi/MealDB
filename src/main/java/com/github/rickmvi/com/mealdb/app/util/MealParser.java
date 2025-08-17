package com.github.rickmvi.com.mealdb.app.util;

import com.fasterxml.jackson.databind.ObjectMapper;

@lombok.experimental.UtilityClass
public class MealParser {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T parse(String json, Class<T> clazz) {
        if (json == null) return null;
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String toJson(Object object) {
        if (object == null) return null;
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
