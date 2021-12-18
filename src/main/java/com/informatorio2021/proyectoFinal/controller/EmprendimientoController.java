package com.informatorio2021.proyectoFinal.controller;

import com.informatorio2021.proyectoFinal.dto.EventoDTO;
import com.informatorio2021.proyectoFinal.entity.Emprendimiento;
import com.informatorio2021.proyectoFinal.repository.EmprendimientoRepository;
import com.informatorio2021.proyectoFinal.repository.EventoRepository;
import com.informatorio2021.proyectoFinal.service.EmprendimientoService;
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
public class EmprendimientoController {
    private final EmprendimientoRepository emprendimientoRepository;
    private final EmprendimientoService emprendimientoService;
    private final EventoRepository eventoRepository;
    private final EventoService eventoService;
    // SE APLICAN LAS DEPENDENCIAS
    @Autowired
    public EmprendimientoController(EmprendimientoRepository emprendimientoRepository, EmprendimientoService emprendimientoService, EventoRepository eventoRepository, EventoService eventoService) {
        this.emprendimientoRepository = emprendimientoRepository;
        this.emprendimientoService = emprendimientoService;
        this.eventoRepository = eventoRepository;
        this.eventoService = eventoService;
    }

    /*
------------
ACCIONES DEL CONTROLADOR
------------
 */
//CREAR EL EMPRENDIMIENTO
    @PostMapping(value = "/usuarios/{id}/emprendimientos")
    public ResponseEntity<?> crearEmprendimiento(@PathVariable("id") Long usuarioId,
                                                 @Valid @RequestBody Emprendimiento emprendimiento) {
        return new ResponseEntity<>(emprendimientoService.crear(emprendimiento, usuarioId), HttpStatus.CREATED);
    }

//ELIMINAR EL EMPRENDIMIENTO
    @PutMapping(value = "/emprendimientos/{id}/eliminar")
    public Emprendimiento eliminarEmprendimiento(@PathVariable("id") Long id, Emprendimiento emprendimiento) {
        return this.emprendimientoService.eliminar(emprendimiento, id);
    }

//MODIFICAR EL EMPRENDIMIENTO
    @PutMapping(value = "/emprendimientos/{id}")
    public Emprendimiento modificarEmprendimiento(@PathVariable("id") Long id,
                                                  @Valid @RequestBody Emprendimiento emprendimiento) {
        return this.emprendimientoService.modificar(emprendimiento, id);
    }

//OBTENER TODOS LOS EMPRENDIMIENTOS
    @GetMapping(value = "/emprendimientos")
    public ResponseEntity<?> obtenerTodosLosEmprendimientos(@RequestParam(name = "nombre", required = false) String nombre) {
        return new ResponseEntity<>(emprendimientoService.obtenerTodos(nombre) ,HttpStatus.OK);
    }

    @GetMapping(value = "/emprendimientos/{tag}/tags")
    public ResponseEntity<?> obtenerPorTag(@PathVariable("tag") String tag){
        return ResponseEntity.ok(emprendimientoService.obtenerPorTag(tag));
    }

//OBTENER LOS EMPRENDIMIENTOS NO PUBLICADOS
    @GetMapping(value = "/emprendimientos/no_publicados")
    public ResponseEntity<?> obtenerEmprendimientosNoPublicados() {
        return new ResponseEntity<>(emprendimientoService.obtenerNoPublicados(), HttpStatus.OK);
    }

//REGISTRAR EVENTO AL EMPRENDIMIENTO
    @PostMapping(value = "/emprendimientos/{emprendimientoId}/eventos/{eventoId}")
    public ResponseEntity<?> registrarEvento(@PathVariable("emprendimientoId") Long emprendimientoId, @PathVariable("eventoId") Long eventoId, EventoDTO eventoDTO) {
        emprendimientoRepository.findById(emprendimientoId);
        eventoRepository.findById(eventoId);
        return new ResponseEntity<>(eventoService.registrar(emprendimientoId, eventoId, eventoDTO), HttpStatus.CREATED);
    }

}
