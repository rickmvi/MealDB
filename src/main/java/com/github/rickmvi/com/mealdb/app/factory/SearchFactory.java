package com.github.rickmvi.com.mealdb.app.factory;

import com.github.rickmvi.com.mealdb.app.service.SearchStrategy;
import com.github.rickmvi.com.mealdb.app.util.Verify;

import java.util.Map;

public class SearchFactory {
    private static final Map<Class<?>, SearchStrategy> strategies =
            Map.of(
                    String.class, (searchTerm, baseUrl) -> baseUrl + searchTerm,
                    Number.class, (searchTerm, baseUrl) -> baseUrl + searchTerm,
                    Character.class, (searchTerm, baseUrl) -> baseUrl + searchTerm
            );

    public static String create(Object searchTerm, String baseUrl) {
        Verify.notNull(searchTerm, "Search term cannot be null");

        SearchStrategy strategy = strategies.get(searchTerm.getClass());

        Verify.notNull(strategy, "No strategy found for search term type: " + searchTerm.getClass());

        return strategy.build(searchTerm, baseUrl);
    }
}
