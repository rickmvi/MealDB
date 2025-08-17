package com.github.rickmvi.com.mealdb.app.service;

import com.github.rickmvi.com.mealdb.app.factory.SearchFactory;
import com.github.rickmvi.com.mealdb.app.service.internal.URL;
import com.github.rickmvi.com.mealdb.app.util.Verify;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class MealService {
    private final URL url;

    @Contract(pure = true)
    public MealService(@NotNull URL url) {
        Verify.notNull(url, "URL cannot be null");
        this.url = url;
    }

    public String build(@NotNull Object searchTerm) {
        Verify.notNull(searchTerm, "Search term cannot be null");
        return SearchFactory.create(searchTerm.toString(), url.getUrl());
    }
}
