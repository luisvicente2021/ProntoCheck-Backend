package com.prontocheck.prontocheck_backend.controller;

import com.prontocheck.prontocheck_backend.dto.UsuarioActualResponse;
import com.prontocheck.prontocheck_backend.model.Usuario;
import com.prontocheck.prontocheck_backend.repository.UsuarioRepository;
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

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioActualResponse> obtenerUsuarioActual(
            @AuthenticationPrincipal Jwt jwt) {

        UUID authUserId = UUID.fromString(jwt.getSubject());

        return usuarioRepository
                .findByAuthUserId(authUserId)
                .filter(Usuario::getActivo)
                .map(usuario -> new UsuarioActualResponse(
                        usuario.getNombre(),
                        usuario.getEmail(),
                        usuario.getRol()
                ))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}