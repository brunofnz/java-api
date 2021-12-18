package com.informatorio2021.proyectoFinal.dto;

    /* definimos la clase */

public class EventoDTO {
    private Long eventoId;
    private Long suscriptoId;

        /* getters y setters */

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Long getSuscriptoId() {
        return suscriptoId;
    }

    public void setSuscriptoId(Long suscriptoId) {
        this.suscriptoId = suscriptoId;
    }
}
