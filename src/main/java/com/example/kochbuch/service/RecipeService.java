package com.example.kochbuch.service;

import com.example.kochbuch.controller.dto.RecipeDTO;
import com.example.kochbuch.controller.dto.RecipeResponseDTO;
import com.example.kochbuch.controller.dto.IngredientDTO;
import com.example.kochbuch.entity.Recipe;
import com.example.kochbuch.entity.Ingredient;
import com.example.kochbuch.repository.RecipeRepository;
import com.example.kochbuch.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class RecipeService {
}