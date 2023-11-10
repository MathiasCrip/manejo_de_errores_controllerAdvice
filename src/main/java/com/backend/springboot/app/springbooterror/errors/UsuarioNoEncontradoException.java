package com.backend.springboot.app.springbooterror.errors;

public class UsuarioNoEncontradoException extends RuntimeException {

    public UsuarioNoEncontradoException(Integer id) {
        super("Usuario con ID: ".concat(id.toString().concat(" no existe en el sistema.")));
    }
}
