package com.prontocheck.prontocheck_backend.service;

import com.prontocheck.prontocheck_backend.model.Residencial;
import com.prontocheck.prontocheck_backend.repository.ResidencialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidencialService {

    private final ResidencialRepository residencialRepository;

    public ResidencialService(ResidencialRepository residencialRepository) {
        this.residencialRepository = residencialRepository;
    }

    public List<Residencial> obtenerResidencialesActivos() {
        return residencialRepository.findByActivoTrue();
    }
}