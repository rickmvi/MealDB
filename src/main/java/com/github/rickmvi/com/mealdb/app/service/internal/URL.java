package com.github.rickmvi.com.mealdb.app.service.internal;

/**
 * Enumeration representing predefined URL templates for accessing the MealDB API.
 * Each constant encapsulates a base URL string corresponding to a specific type of query.
 * The URLs are used as endpoints for searching the MealDB database.
 */
@lombok.RequiredArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public enum URL {
   NAME("https://www.themealdb.com/api/json/v1/1/search.php?s="),
   FIRST_LETTER("https://www.themealdb.com/api/json/v1/1/search.php?f="),
   BY_ID("https://www.themealdb.com/api/json/v1/1/lookup.php?i="),
   RANDOM_MEAL("https://www.themealdb.com/api/json/v1/1/random.php");

   @lombok.Getter(value = lombok.AccessLevel.PUBLIC)
   private final String url;
}
