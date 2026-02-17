package com.example.kochbuch.controller.dto;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class RecipeDTO {
    private UUID id;
    private String name;
    private String instructions;
    private Integer preparationTime;
    private Integer servings;
    private Set<UUID> ingredientIds;
}
