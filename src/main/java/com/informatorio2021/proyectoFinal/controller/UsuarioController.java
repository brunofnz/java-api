package com.informatorio2021.proyectoFinal.controller;

import com.informatorio2021.proyectoFinal.entity.Usuario;
import com.informatorio2021.proyectoFinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
/*
------------
INICIO DEL CONTROLADOR
------------
 */
@RestController
    @RequestMapping(value = "/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
//SE APLICAN LAS DEPENDENCIAS
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

/*
------------
ACCIONES DEL CONTROLADOR
------------
*/
//CREAR UN USUARIO
    @PostMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.crear(usuario), HttpStatus.CREATED);
    }

//ELIMINAR UN USUARIO
    @DeleteMapping(value = "/{id}/eliminar")
    public Usuario eliminarUsuario(@PathVariable("id") Long id, Usuario usuario) {
        return this.usuarioService.eliminar(usuario, id);
    }

//MODIFICAR UN USUARIO
    @PutMapping(value = "/{id}")
    public Usuario modificarUsuario(@PathVariable("id") Long id, @Valid @RequestBody Usuario usuario) {
        return this.usuarioService.modificar(usuario, id);
    }

//OBTENER LOS USUARIOS
    @GetMapping
    public ResponseEntity<?> obtenerTodosLosUsuarios(@RequestParam(name = "fecha", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaCreacion, @RequestParam(name = "ciudad", required = false) String ciudad) {
        return new ResponseEntity<>(usuarioService.todosLosUsuarios(fechaCreacion, ciudad), HttpStatus.OK);
    }

}
