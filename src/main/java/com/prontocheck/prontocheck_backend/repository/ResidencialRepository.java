package com.prontocheck.prontocheck_backend.repository;

import com.prontocheck.prontocheck_backend.model.Residencial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ResidencialRepository extends JpaRepository<Residencial, UUID> {

    List<Residencial> findByActivoTrue();
}