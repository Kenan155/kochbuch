package com.example.kochbuch.controller.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record CreateIngredientDTO (
    @NotNull
    @Size(max = NAME_MAX_LENGTH)
    String name,

    @Min(MIN_CALORIES)
    @Max(MAX_CALORIES)
    int calories
) {
    /**
     * Marker-Interface f&uuml;r Jakarta Validation: zus&auml;tzliche Validierung beim Neuanlegen.
     */
    public interface OnCreate { }

    /**
     * Kleinster Wert für Kalorien.
     */
    public static final long MIN_CALORIES = 0;

    /**
     * Maximaler Wert für Kalorien.
     */
    public static final long MAX_CALORIES = 5000;

    private static final int NAME_MAX_LENGTH = 40;
}
