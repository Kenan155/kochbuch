package com.example.kochbuch.controller;

import com.example.kochbuch.entity.Ingredient;
import com.example.kochbuch.service.IngredientService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.UUID;

import org.springframework.web.bind.annotation.*;

// @Restcontroller kombiniert @Controller und @Responsebody, schreibt also direkt
// in den Response Body anstatt eine View mit HTML Template zu rendern
@RestController
@RequestMapping("/lebensmittel/")
public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

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
    public Ingredient post(@RequestParam String name, @RequestParam int calories) {
        Ingredient l = new Ingredient(name, calories);
        return ingredientService.save(l);
    }
}
