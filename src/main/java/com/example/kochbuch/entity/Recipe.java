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

    /**
     * Der Name des Rezepts.
     */
    private String name;


    /**
     * Beschreibung/Anleitung für das Rezept.
     */
    @Column(length = 2000)
    private String instructions;


    /**
     * Zubereitungszeit in Minuten.
     */
    private Integer preparationTime;

    /**
     * Anzahl der Portionen.
     */
    private Integer servings;

    /**
     * Die Zutaten.
     */
//    @ManyToMany
//    @JoinTable(name = "recipe_ingredient",
//    joinColumns = {@JoinColumn(name= "fk_recipe")},
//    inverseJoinColumns = { @JoinColumn(name = "fk_ingredient")})
//    private Set<Ingredient> ingredients = new HashSet<Ingredient>();
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RecipeIngredient> recipeIngredients = new HashSet<RecipeIngredient>();

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
