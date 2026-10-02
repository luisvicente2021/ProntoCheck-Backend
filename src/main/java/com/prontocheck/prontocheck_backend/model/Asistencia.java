package com.prontocheck.prontocheck_backend.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "asistencia")
public class Asistencia {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "empleado_id")
    private UUID empleadoId;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "id_punto_acceso")
    private UUID idPuntoAcceso;

    @Column(name = "fecha_hora")
    private OffsetDateTime fechaHora;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(UUID empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public UUID getIdPuntoAcceso() {
        return idPuntoAcceso;
    }

    public void setIdPuntoAcceso(UUID idPuntoAcceso) {
        this.idPuntoAcceso = idPuntoAcceso;
    }

    public OffsetDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(OffsetDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}