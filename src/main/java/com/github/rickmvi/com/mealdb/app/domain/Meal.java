package com.github.rickmvi.com.mealdb.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Getter(value = lombok.AccessLevel.PUBLIC)
public class Meal {

    @JsonProperty("strMeal")
    private String name;

    @JsonProperty("strCategory")
    private String category;

    @JsonProperty("strInstructions")
    private String instructions;

    private final List<String> ingredients = new ArrayList<>();

    @JsonProperty("strIngredient1") private String strIngredient1;
    @JsonProperty("strIngredient2") private String strIngredient2;
    @JsonProperty("strIngredient3") private String strIngredient3;
    @JsonProperty("strIngredient4") private String strIngredient4;
    @JsonProperty("strIngredient5") private String strIngredient5;

    @JsonProperty("strMeasure1") private String strMeasure1;
    @JsonProperty("strMeasure2") private String strMeasure2;
    @JsonProperty("strMeasure3") private String strMeasure3;
    @JsonProperty("strMeasure4") private String strMeasure4;
    @JsonProperty("strMeasure5") private String strMeasure5;

    public void buildIngredients() {
        if (strIngredient1 != null && !strIngredient1.isBlank()) ingredients.add(strIngredient1);
        if (strIngredient2 != null && !strIngredient2.isBlank()) ingredients.add(strIngredient2);
        if (strIngredient3 != null && !strIngredient3.isBlank()) ingredients.add(strIngredient3);
        if (strIngredient4 != null && !strIngredient4.isBlank()) ingredients.add(strIngredient4);
        if (strIngredient5 != null && !strIngredient5.isBlank()) ingredients.add(strIngredient5);
    }
}
