package com.example.handservices.model.services;

import com.example.handservices.model.entities.Usuario;

import java.util.List;

public interface UsuarioServices {

    // Crear Usuario
    Usuario crearUsuario(Usuario usuario);
    // Listar usuarios
    public List<Usuario> ListarUsuarios();

}
