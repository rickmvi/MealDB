package com.github.rickmvi.com.mealdb.app.service;

@FunctionalInterface
public interface SearchStrategy {
    String build(Object searchTerm, String baseUrl);
}
