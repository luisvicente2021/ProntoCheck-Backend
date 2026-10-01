package com.prontocheck.prontocheck_backend.controller;

import com.prontocheck.prontocheck_backend.dto.UsuarioActualResponse;
import com.prontocheck.prontocheck_backend.model.Usuario;
import com.prontocheck.prontocheck_backend.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioActualResponse> obtenerUsuarioActual(
            @AuthenticationPrincipal Jwt jwt) {

        UUID authUserId = UUID.fromString(jwt.getSubject());

        Usuario usuario = usuarioService.obtenerUsuarioActivo(authUserId);

        UsuarioActualResponse response = new UsuarioActualResponse(
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getRol()
        );

        return ResponseEntity.ok(response);
    }
}