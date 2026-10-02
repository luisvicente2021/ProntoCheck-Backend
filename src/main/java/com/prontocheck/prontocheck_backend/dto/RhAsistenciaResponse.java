package com.prontocheck.prontocheck_backend.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public class RhAsistenciaResponse {

    private UUID id;
    private UUID empleadoId;
    private String empleado;
    private String tipo;
    private OffsetDateTime fechaHora;
    private UUID idPuntoAcceso;
    private String puntoAcceso;
    private String residencial;

    public RhAsistenciaResponse(
            UUID id,
            UUID empleadoId,
            String empleado,
            String tipo,
            OffsetDateTime fechaHora,
            UUID idPuntoAcceso,
            String puntoAcceso,
            String residencial
    ) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.empleado = empleado;
        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.idPuntoAcceso = idPuntoAcceso;
        this.puntoAcceso = puntoAcceso;
        this.residencial = residencial;
    }

    public UUID getId() {
        return id;
    }

    public UUID getEmpleadoId() {
        return empleadoId;
    }

    public String getEmpleado() {
        return empleado;
    }

    public String getTipo() {
        return tipo;
    }

    public OffsetDateTime getFechaHora() {
        return fechaHora;
    }

    public UUID getIdPuntoAcceso() {
        return idPuntoAcceso;
    }

    public String getPuntoAcceso() {
        return puntoAcceso;
    }

    public String getResidencial() {
        return residencial;
    }
}