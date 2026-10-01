package com.prontocheck.prontocheck_backend.service;

import com.prontocheck.prontocheck_backend.model.Usuario;
import com.prontocheck.prontocheck_backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario obtenerUsuarioActivo(UUID authUserId) {

        return usuarioRepository
                .findByAuthUserId(authUserId)
                .filter(Usuario::getActivo)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Usuario no autorizado para ProntoCheck"
                        )
                );
    }

    public Usuario validarRol(UUID authUserId, String rolRequerido) {

        Usuario usuario = obtenerUsuarioActivo(authUserId);

        if (!usuario.getRol().equals(rolRequerido)) {
            throw new SecurityException(
                    "No tienes permisos para realizar esta operación"
            );
        }

        return usuario;
    }
}