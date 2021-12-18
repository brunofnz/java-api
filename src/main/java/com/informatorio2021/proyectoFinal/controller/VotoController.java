package com.informatorio2021.proyectoFinal.controller;


import com.informatorio2021.proyectoFinal.dto.VotoDTO;
import com.informatorio2021.proyectoFinal.service.VotoService;
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
@RequestMapping(value = "/votos")
public class VotoController {
    private final VotoService votoService;
//SE APLICAN LAS DEPENDENCIAS
    @Autowired
    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

/*
------------
ACCIONES DEL CONTROLADOR
------------
 */
//CREAR UN VOTO
    @PostMapping
    public ResponseEntity<?> crearVoto(@Valid @RequestBody VotoDTO votoDTO) {
        return new ResponseEntity<>(votoService.crearVoto(votoDTO), HttpStatus.CREATED);
    }

//OBTENER LOS VOTOS
    @GetMapping(value = "/{usuarioId}")
    public ResponseEntity<?> obtenerLosVotosDeUnUsuario(@PathVariable("usuarioId") Long usuarioId) {
        return new ResponseEntity<>(votoService.obtenerVotos(usuarioId), HttpStatus.OK);
    }

}
