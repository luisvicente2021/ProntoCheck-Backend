package com.prontocheck.prontocheck_backend.service;

import com.prontocheck.prontocheck_backend.dto.RhAsistenciaResponse;
import com.prontocheck.prontocheck_backend.model.Asistencia;
import com.prontocheck.prontocheck_backend.model.Empleado;
import com.prontocheck.prontocheck_backend.model.PuntoAcceso;
import com.prontocheck.prontocheck_backend.repository.AsistenciaRepository;
import com.prontocheck.prontocheck_backend.repository.EmpleadoRepository;
import com.prontocheck.prontocheck_backend.repository.PuntoAccesoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;
    private final EmpleadoRepository empleadoRepository;
    private final PuntoAccesoRepository puntoAccesoRepository;

    public AsistenciaService(
            AsistenciaRepository asistenciaRepository,
            EmpleadoRepository empleadoRepository,
            PuntoAccesoRepository puntoAccesoRepository
    ) {
        this.asistenciaRepository = asistenciaRepository;
        this.empleadoRepository = empleadoRepository;
        this.puntoAccesoRepository = puntoAccesoRepository;
    }

    public List<RhAsistenciaResponse> obtenerAsistencias() {

        List<Asistencia> asistencias =
                asistenciaRepository.findAllByOrderByFechaHoraDesc();

        return asistencias.stream()
                .map(asistencia -> {

                    Empleado empleado = empleadoRepository
                            .findById(asistencia.getEmpleadoId())
                            .orElse(null);

                    String nombreEmpleado = "Empleado no encontrado";

                    if (empleado != null) {
                        nombreEmpleado = construirNombreCompleto(empleado);
                    }

                    PuntoAcceso puntoAcceso = puntoAccesoRepository
                            .findById(asistencia.getIdPuntoAcceso())
                            .orElse(null);

                    String nombrePunto = "Punto de acceso no encontrado";
                    String residencial = "";

                    if (puntoAcceso != null) {
                        nombrePunto = puntoAcceso.getNombrePunto();
                        residencial = puntoAcceso.getNombreResidencial();
                    }

                    return new RhAsistenciaResponse(
                            asistencia.getId(),
                            asistencia.getEmpleadoId(),
                            nombreEmpleado,
                            asistencia.getTipo(),
                            asistencia.getFechaHora(),
                            asistencia.getIdPuntoAcceso(),
                            nombrePunto,
                            residencial
                    );
                })
                .toList();
    }

    private String construirNombreCompleto(Empleado empleado) {

        return String.join(" ",
                valorSeguro(empleado.getNombre()),
                valorSeguro(empleado.getApellidoPaterno()),
                valorSeguro(empleado.getApellidoMaterno())
        ).trim().replaceAll("\\s+", " ");
    }

    private String valorSeguro(String valor) {
        return valor == null ? "" : valor.trim();
    }
}