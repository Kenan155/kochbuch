package com.example.kochbuch.controller;

import com.example.kochbuch.controller.dto.CreateIngredientDTO.OnCreate;
import com.example.kochbuch.controller.dto.CreateIngredientDTO;
import com.example.kochbuch.controller.dto.IngredientDTO;
import com.example.kochbuch.controller.dto.IngredientMapper;
import com.example.kochbuch.entity.Ingredient;
import com.example.kochbuch.service.IngredientService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

// @Restcontroller kombiniert @Controller und @Responsebody, schreibt also direkt
// in den Response Body anstatt eine View mit HTML Template zu rendern
@RestController
@RequestMapping("/ingredient/")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;
    private final IngredientMapper ingredientMapper;

    @ApiResponse(responseCode = "200", description = "Lebensmittel gefunden")
    @ApiResponse(responseCode = "404", description = "Lebensmittel nicht gefunden")
    @GetMapping(produces = "application/json")
    public Iterable<Ingredient> findAll() {
        return ingredientService.findAll();
    }

    @GetMapping(path ="{id}", produces = "application/json")
    public Ingredient findById(@PathVariable UUID id) {
        return ingredientService.findById(id);
    }

    @PostMapping
    public IngredientDTO post(@RequestBody @Validated({Default.class, OnCreate.class}) final CreateIngredientDTO dto) {
        var entity = ingredientMapper.toIngredient(dto);
        var saved = ingredientService.save(entity);
        return ingredientMapper.toIngredientDTO(saved);
    }
}
