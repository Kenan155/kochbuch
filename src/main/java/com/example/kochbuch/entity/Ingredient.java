package com.example.kochbuch.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private int calories;

    // TODO: Add fat, protein and carbs property

    @OneToMany(mappedBy = "ingredient")
    private final Set<RecipeIngredient> recipeIngredients = new HashSet<>();

    // Default constructor for the sake of JPA
    protected Ingredient() {}

    public Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return String.format(
                "Ingredient[id=%s, name=%s, calories=%d]",
                id, name, calories
        );
    }
}
