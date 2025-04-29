package com.example.handservices.model.dao;

import com.example.handservices.model.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, String> {

}
