package com.prontocheck.prontocheck_backend.controller;

import com.prontocheck.prontocheck_backend.dto.RhAsistenciaResponse;
import com.prontocheck.prontocheck_backend.service.AsistenciaService;
import com.prontocheck.prontocheck_backend.service.UsuarioService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rh/asistencias")
public class RhAsistenciaController {

    private final AsistenciaService asistenciaService;
    private final UsuarioService usuarioService;

    public RhAsistenciaController(
            AsistenciaService asistenciaService,
            UsuarioService usuarioService
    ) {
        this.asistenciaService = asistenciaService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<RhAsistenciaResponse> obtenerAsistencias(
            @AuthenticationPrincipal Jwt jwt
    ) {
        UUID authUserId = UUID.fromString(jwt.getSubject());

        usuarioService.validarRol(authUserId, "RH");

        return asistenciaService.obtenerAsistencias();
    }
}