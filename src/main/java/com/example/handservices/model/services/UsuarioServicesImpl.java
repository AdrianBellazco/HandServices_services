package com.example.handservices.model.services;

import com.example.handservices.model.dao.UsuarioDao;
import com.example.handservices.model.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServicesImpl implements UsuarioServices {

    @Autowired
    UsuarioDao usuarioDao;

    //Implementacion de guardar usuario
@Override
    public Usuario crearUsuario(Usuario usuario){
    if (usuarioDao.existsById(usuario.getCedula())){
        throw new IllegalArgumentException("El usuario ya existe");
    }
    return usuarioDao.save(usuario);
}

    //Implementacion de listar usuarios
@Override
    public List<Usuario> ListarUsuarios() {
        Iterable<Usuario> iterableUsuarios = usuarioDao.findAll();
        List<Usuario> Listausuarios = new ArrayList<>();

        iterableUsuarios.forEach(Listausuarios::add);
        return Listausuarios;
    }

}
