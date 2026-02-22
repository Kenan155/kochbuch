package com.example.kochbuch.service;

import com.example.kochbuch.controller.dto.CreateRecipeDTO;
import com.example.kochbuch.controller.dto.RecipeDTO;
import com.example.kochbuch.controller.dto.RecipeMapper;
import com.example.kochbuch.entity.Ingredient;
import com.example.kochbuch.entity.Recipe;
import com.example.kochbuch.repository.IngredientRepository;
import com.example.kochbuch.repository.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final RecipeMapper recipeMapper;

    @Transactional
    public Recipe create(CreateRecipeDTO dto) {
        Recipe recipe = new Recipe(
                dto.name(),
                dto.instructions(),
                dto.preparationTime(),
                dto.servings()
        );

        for (var ingredientDTO : dto.ingredients()) {
            Ingredient ingredient = ingredientRepository.findById(ingredientDTO.ingredientId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Ingredient nicht gefunden: " + ingredientDTO.ingredientId()
                    ));
            recipe.addIngredient(ingredient, ingredientDTO.amount(), ingredientDTO.unit());
        }

        return recipeRepository.save(recipe);
    }

    public List<RecipeDTO> findAll() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::toRecipeDTO)
                .toList();
    }

}