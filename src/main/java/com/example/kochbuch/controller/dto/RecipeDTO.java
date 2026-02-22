package com.example.kochbuch.controller.dto;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record RecipeDTO(
        UUID id,
        String name,
        String instructions,
        Integer preparationTime,
        Integer servings,
        List<RecipeIngredientResponseDTO> ingredients
) {
    @Builder
    public record RecipeIngredientResponseDTO(
            UUID id,
            UUID ingredientId,
            String ingredientName,
            double amount,
            String unit
    ) {}
}