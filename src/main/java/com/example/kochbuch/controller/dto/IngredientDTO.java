package com.example.kochbuch.controller.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record IngredientDTO (
    UUID id,
    String name,
    int calories
) {

}


