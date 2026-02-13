package com.example.kochbuch.service;

import com.example.kochbuch.entity.Ingredient;
import com.example.kochbuch.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public Ingredient findById(UUID id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElse(null);

        if (ingredient == null) {
            throw new NotFoundException(id);
        }
        log.debug("findById: lebensmittel={}", ingredient);

        return ingredient;
    }

    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

}
