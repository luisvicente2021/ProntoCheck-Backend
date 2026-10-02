package com.prontocheck.prontocheck_backend.repository;

import com.prontocheck.prontocheck_backend.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmpleadoRepository extends JpaRepository<Empleado, UUID> {

    List<Empleado> findByActivoTrue();
}