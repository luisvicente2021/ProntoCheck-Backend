package com.prontocheck.prontocheck_backend.repository;

import com.prontocheck.prontocheck_backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByAuthUserId(UUID authUserId);
}
