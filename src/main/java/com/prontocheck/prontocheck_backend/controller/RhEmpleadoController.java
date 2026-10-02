package com.prontocheck.prontocheck_backend.controller;

import com.prontocheck.prontocheck_backend.model.Empleado;
import com.prontocheck.prontocheck_backend.service.EmpleadoService;
import com.prontocheck.prontocheck_backend.service.UsuarioService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rh/empleados")
public class RhEmpleadoController {

    private final EmpleadoService empleadoService;
    private final UsuarioService usuarioService;

    public RhEmpleadoController(
            EmpleadoService empleadoService,
            UsuarioService usuarioService
    ) {
        this.empleadoService = empleadoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Empleado> obtenerEmpleados(
            @AuthenticationPrincipal Jwt jwt
    ) {
        UUID authUserId = UUID.fromString(jwt.getSubject());

        usuarioService.validarRol(authUserId, "RH");

        return empleadoService.obtenerEmpleadosActivos();
    }
}