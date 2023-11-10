package com.backend.springboot.app.springbooterror.services;

import com.backend.springboot.app.springbooterror.errors.UsuarioNoEncontradoException;
import com.backend.springboot.app.springbooterror.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private List<Usuario> usuarios;

    /*En este caso, para el ejemplo, se cargan los datos directamente desde el constructor.*/
    public UsuarioServiceImpl() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1, "Federico", "Caicedo"));
        usuarios.add(new Usuario(2, "Florencia", "Salvador"));
        usuarios.add(new Usuario(3, "Abel", "Montillo"));
        usuarios.add(new Usuario(4, "Diana", "Guzman"));
        usuarios.add(new Usuario(5, "Marcelo", "Grindetti"));
        usuarios.add(new Usuario(6, "Jazmin", "Lopez"));
        usuarios.add(new Usuario(7, "Lalo", "Fernandez"));
    }

    @Override
    public List<Usuario> listar() {
        return usuarios;
//        retorna la lista completa de usuarios
    }

    @Override
    public Usuario ObtenerPorId(Integer id) {
//        Usuario usuarioObtenido = null;
//
//        for (Usuario u : this.usuarios) {
//            if (u.getId().equals(id)) {
//                usuarioObtenido = u;
//                break;
//            }
//        }
        /*IMPLEMENTADO CON PROGRAMACION FUNCIONAL*/
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UsuarioNoEncontradoException(id));

    }
}
