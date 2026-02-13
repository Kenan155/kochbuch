package com.example.kochbuch.service;

import lombok.Getter;

import java.util.UUID;

@Getter
public final class NotFoundException extends RuntimeException {
    /**
     * Nicht-vorhandene ID.
     */
    private final UUID id;

    NotFoundException(final UUID id) {
        super("Kein Lebensmittel mit der ID " + id + " gefunden.");
        this.id = id;
    }
}
