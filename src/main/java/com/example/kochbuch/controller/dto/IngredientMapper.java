package com.example.kochbuch.controller.dto;

import com.example.kochbuch.entity.Ingredient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientMapper {
    IngredientDTO toIngredientDTO(Ingredient ingredient);
    Ingredient toIngredient(CreateIngredientDTO  createIngredientDTO );
}
