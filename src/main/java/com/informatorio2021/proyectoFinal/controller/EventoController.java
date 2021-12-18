package com.informatorio2021.proyectoFinal.controller;


import com.informatorio2021.proyectoFinal.entity.Evento;
import com.informatorio2021.proyectoFinal.repository.EventoRepository;
import com.informatorio2021.proyectoFinal.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/*
------------
INICIO DEL CONTROLADOR
------------
 */
@RestController
@RequestMapping(value = "/eventos")
public class EventoController {
    private final EventoService eventoService;
    private final EventoRepository eventoRepository;

//SE APLICAN LAS DEPENDENCIAS
    @Autowired
    public EventoController(EventoService eventoService, EventoRepository eventoRepository) {
        this.eventoService = eventoService;
        this.eventoRepository = eventoRepository;
    }
/*
------------
ACCIONES DEL CONTROLADOR
------------
*/
//CREAR UN EVENTO
    @PostMapping
    public ResponseEntity<?> crearEvento(@Valid @RequestBody Evento evento) {
        return new ResponseEntity<>(eventoService.crear(evento), HttpStatus.CREATED);
    }

//ELIMINAR UN EVENTO
    @DeleteMapping(value = "/{id}/eliminar")
    public Evento eliminarEvento(@PathVariable("id") Long id, Evento evento) {
        return this.eventoService.eliminar(evento, id);
    }

//ACTUALIZAR EL ESTADO DE UN EVENTO
    @PutMapping(value = "/{id}/actualizar-estado")
    public void actualizarEvento() {
        this.eventoService.actualizarFecha();
    }

//RANKING DEL EVENTO
    @GetMapping(value = "/{id}/ranking")
    public ResponseEntity<?> rankingDelEvento(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventoService.rankear(id), HttpStatus.OK);
    }

//OBTENER TODOS LOS EVENTOS
    @GetMapping
    public ResponseEntity<?> obtenerTodos() {
        return new ResponseEntity<>(eventoService.obtenerTodos() ,HttpStatus.OK);
    }

//MODIFICAR UN EVENTO
    @PutMapping(value = "/{id}")
    public Evento modificar(@PathVariable("id") Long id, @Valid @RequestBody Evento evento) {
        return this.eventoService.modificar(evento, id);
}
}
