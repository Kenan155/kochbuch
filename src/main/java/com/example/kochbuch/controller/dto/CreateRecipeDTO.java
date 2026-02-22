package com.example.kochbuch.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record CreateRecipeDTO(
        @NotBlank
        @Size(max = 100)
        String name,

        @NotBlank
        @Size(max = 2000)
        String instructions,

        @Min(1)
        @Max(600)
        Integer preparationTime,

        @Min(1)
        @Max(100)
        Integer servings,

        @NotEmpty
        @Valid
        List<RecipeIngredientDTO> ingredients
) {
    @Builder
    public record RecipeIngredientDTO(
            @NotNull
            UUID ingredientId,

            @Positive
            double amount,

            @NotBlank
            String unit
    ) {}
}