package com.github.rickmvi.com.mealdb.app;

import com.github.rickmvi.com.mealdb.app.domain.Meal;
import com.github.rickmvi.com.mealdb.app.infra.HttpClientProvider;
import com.github.rickmvi.com.mealdb.app.infra.http.response.MealResponse;
import com.github.rickmvi.com.mealdb.app.service.MealService;
import com.github.rickmvi.com.mealdb.app.service.internal.URL;
import com.github.rickmvi.com.mealdb.app.util.MealParser;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MealService mealService = new MealService(URL.NAME);
        HttpClientProvider provider = HttpClientProvider.create();

        System.out.print("Digite o nome da receita: ");
        String name = scanner.nextLine().trim();

        String url = mealService.build(name);
        String body = provider.getBody(url);

        MealResponse response = MealParser.parse(body, MealResponse.class);
        List<Meal> meals = response != null ? response.getMeals() : null;

        if (meals != null && !meals.isEmpty()) {
            Meal meal = meals.get(0);
            meal.buildIngredients();

            System.out.println("\n📌 Receita encontrada:");
            System.out.println("- Nome: " + meal.getName());
            System.out.println("- Categoria: " + meal.getCategory());
            System.out.println("- Ingredientes:");
            for (String ingredient : meal.getIngredients()) {
                System.out.println("   • " + ingredient);
            }
            System.out.println("- Instruções:\n  " + meal.getInstructions());
        }

        scanner.close();
    }
}
