package com.example.kochbuch.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @Column(length = 2000)
    private String instructions;

    private Integer preparationTime;

    private Integer servings;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<RecipeIngredient> recipeIngredients = new HashSet<>();

    // Default constructor for JPA
    protected Recipe() {}

    public Recipe(String name, String instructions, Integer preparationTime, Integer servings) {
        this.name = name;
        this.instructions = instructions;
        this.preparationTime = preparationTime;
        this.servings = servings;
    }

    public void addIngredient(Ingredient ingredient, double amount, String unit) {
        RecipeIngredient recipeIngredient = new RecipeIngredient(this, ingredient, amount, unit);
        this.recipeIngredients.add(recipeIngredient);
    }

    public void removeIngredient(RecipeIngredient recipeIngredient) {
        this.recipeIngredients.remove(recipeIngredient);
        recipeIngredient.setRecipe(null);
    }
}
