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

    /**
     * Der Name des Lebensmittels.
     */
    private String name;

    /**
     * Die Energie/Kalorienzahl des Lebensmittels
     */
    private int calories;
//    private Integer protein;
//    private Integer fat;
//    private Integer carbs;

    @OneToMany(mappedBy = "ingredient")
    private Set<RecipeIngredient> recipeIngredients = new HashSet<RecipeIngredient>();

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
