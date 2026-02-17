package com.example.kochbuch.controller.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class IngredientDTO {
    private UUID id;
    private String name;
    private int calories;
}