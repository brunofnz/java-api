package com.informatorio2021.proyectoFinal.dto;

import com.informatorio2021.proyectoFinal.entity.VotoGenerado;

import java.time.LocalDateTime;

    /* definimos la clase */

public class VotoDTO {
    private VotoGenerado generado;
    private Long usuarioId;
    private Long emprendimientoId;
    private LocalDateTime fechaEmision;
    private Boolean emitido;

    /* getters y setters */

    public VotoGenerado getGenerado() {
        return generado;
    }

    public void setGenerado(VotoGenerado generado) {
        this.generado = generado;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getEmprendimientoId() {
        return emprendimientoId;
    }

    public void setEmprendimientoId(Long emprendimientoId) {
        this.emprendimientoId = emprendimientoId;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Boolean getEmitido() {
        return emitido;
    }

    public void setEmitido(Boolean emitido) {
        this.emitido = emitido;
    }
}
