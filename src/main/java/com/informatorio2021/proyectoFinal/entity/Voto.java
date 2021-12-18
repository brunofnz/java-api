package com.informatorio2021.proyectoFinal.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

    /* Definimos la clase */

@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private VotoGenerado generado;
    private Long emprendimientoId;
    private Long usuarioId;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;

     /* getters y setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VotoGenerado getGenerado() {
        return generado;
    }

    public void setGenerado(VotoGenerado generado) {
        this.generado = generado;
    }

    public Long getEmprendimientoId() {
        return emprendimientoId;
    }

    public void setEmprendimientoId(Long emprendimientoId) {
        this.emprendimientoId = emprendimientoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }
        /* to-string  */

    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", generado=" + generado +
                ", emprendimientoId=" + emprendimientoId +
                ", usuarioId=" + usuarioId +
                ", fechaDeCreacion=" + fechaDeCreacion +
                '}';
    }
}
