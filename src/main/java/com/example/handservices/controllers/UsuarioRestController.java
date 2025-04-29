package com.example.handservices.controllers;

import com.example.handservices.model.entities.Usuario;
import com.example.handservices.model.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioRestController {

    @Autowired
    private UsuarioServices usuarioServices;

    // Ver usuarios
    @RequestMapping(path = "/api/usuarios/get")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioServices.ListarUsuarios();

        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Crear Usuario
    @PostMapping(path = "/api/usuarios/crearUsuario")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioServices.crearUsuario(usuario);
            return ResponseEntity.ok(nuevoUsuario);
        } catch (CedulaDuplicadaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public class CedulaDuplicadaException extends RuntimeException {
        public CedulaDuplicadaException(String message) {
            super(message);
        }
    }


}

