package com.prontocheck.prontocheck_backend.repository;

import com.prontocheck.prontocheck_backend.model.PuntoAcceso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PuntoAccesoRepository extends JpaRepository<PuntoAcceso, UUID> {
}