package com.prontocheck.prontocheck_backend.service;

import com.prontocheck.prontocheck_backend.model.Empleado;
import com.prontocheck.prontocheck_backend.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> obtenerEmpleadosActivos() {
        return empleadoRepository.findByActivoTrue();
    }
}