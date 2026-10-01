package com.prontocheck.prontocheck_backend.dto;

public record UsuarioActualResponse(
        String nombre,
        String email,
        String rol
) {
}
