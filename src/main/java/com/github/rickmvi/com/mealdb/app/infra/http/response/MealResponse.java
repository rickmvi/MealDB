package com.github.rickmvi.com.mealdb.app.infra.http.response;

import com.github.rickmvi.com.mealdb.app.domain.Meal;

import java.util.List;

@lombok.Data
public class MealResponse {
    private List<Meal> meals;
}
