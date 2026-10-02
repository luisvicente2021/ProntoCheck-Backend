package com.prontocheck.prontocheck_backend.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "puntos_acceso")
public class PuntoAcceso {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "nombre_punto")
    private String nombrePunto;

    @Column(name = "nombre_residencial")
    private String nombreResidencial;

    @Column(name = "activo")
    private Boolean activo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombrePunto() {
        return nombrePunto;
    }

    public void setNombrePunto(String nombrePunto) {
        this.nombrePunto = nombrePunto;
    }

    public String getNombreResidencial() {
        return nombreResidencial;
    }

    public void setNombreResidencial(String nombreResidencial) {
        this.nombreResidencial = nombreResidencial;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}