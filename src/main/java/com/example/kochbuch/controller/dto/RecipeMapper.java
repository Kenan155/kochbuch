package com.example.kochbuch.controller.dto;

import com.example.kochbuch.entity.Recipe;
import com.example.kochbuch.entity.RecipeIngredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    @Mapping(target = "ingredients", source = "recipeIngredients")
    RecipeDTO toRecipeDTO(Recipe recipe);

    @Mapping(target = "ingredientId", source = "ingredient.id")
    @Mapping(target = "ingredientName", source = "ingredient.name")
    RecipeDTO.RecipeIngredientResponseDTO toRecipeIngredientResponseDTO(RecipeIngredient recipeIngredient);
}