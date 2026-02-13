package com.example.kochbuch.repository;

import com.example.kochbuch.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {

    @Override
    Optional<Ingredient> findById(UUID id);

}
