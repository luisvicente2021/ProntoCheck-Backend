package com.prontocheck.prontocheck_backend.repository;

import com.prontocheck.prontocheck_backend.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TurnoRepository extends JpaRepository<Turno, UUID> {

    List<Turno> findByActivoTrue();
}