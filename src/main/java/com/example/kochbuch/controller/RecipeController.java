package com.example.kochbuch.controller;

import com.example.kochbuch.controller.dto.CreateRecipeDTO;
import com.example.kochbuch.controller.dto.RecipeDTO;
import com.example.kochbuch.controller.dto.RecipeMapper;
import com.example.kochbuch.entity.Recipe;
import com.example.kochbuch.service.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe/")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeDTO post(@RequestBody @Valid CreateRecipeDTO dto) {
        var saved = recipeService.create(dto);
        return recipeMapper.toRecipeDTO(saved);
    }

    @GetMapping(produces = "application/json")
    public List<RecipeDTO> findAll() {
        return recipeService.findAll();
    }
}