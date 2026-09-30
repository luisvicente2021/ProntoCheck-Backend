package com.prontocheck.prontocheck_backend.controller;

import com.prontocheck.prontocheck_backend.model.Residencial;
import com.prontocheck.prontocheck_backend.service.ResidencialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/residenciales")
public class ResidencialController {

    private final ResidencialService residencialService;

    public ResidencialController(ResidencialService residencialService) {
        this.residencialService = residencialService;
    }

    @GetMapping
    public List<Residencial> obtenerResidenciales() {
        return residencialService.obtenerResidencialesActivos();
    }
}