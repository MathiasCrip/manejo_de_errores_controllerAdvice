package com.backend.springboot.app.springbooterror.services;

import com.backend.springboot.app.springbooterror.models.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listar();

    Usuario ObtenerPorId(Integer id);

}
