package com.backend.springboot.app.springbooterror.controllers;


import com.backend.springboot.app.springbooterror.errors.UsuarioNoEncontradoException;
import com.backend.springboot.app.springbooterror.models.Usuario;
import com.backend.springboot.app.springbooterror.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*CLASE CONTROLADORA que se encarga de ejecutar los metodos GET,POST,PUT y DELETE, en este caso, solo los GET,
para mostrar solo una vista*/
@Controller
public class AppController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping({"", "/", "/index"})
    public String index() {
        Integer valor = 100 / 0;
        //Se genera un error 500 de tipo ArithmeticException y se captura en el ErrorHandleController

//      Integer valor = Integer.parseInt("100xx");
        //Se genera un error 500 de tipo NumberFormatException y se captura en el ErrorHandleController

        return "index";
        //Se genera un error 500, ya que queremos retornar a una vista que no definimos
    }

    /*Si el id del usuario existe, muestra la vista 'ver.html', si no existe, carga la vista generica.html*/
    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model) {
            /*PROGRAMACION IMPERATIVA*/

//        Usuario usuarioEncontrado = usuarioService.ObtenerPorId(id);
//        if (usuarioEncontrado == null) {
//            throw new UsuarioNoEncontradoException(id);
//        }

        /*IMPLEMENTADO CON LA API STREAM()*/
        Usuario usuarioEncontrado = usuarioService.listar().stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UsuarioNoEncontradoException(id));

        model.addAttribute("usuario", usuarioEncontrado);
        model.addAttribute("Detalle del usuario :" + usuarioEncontrado.getNombre().concat(" " + usuarioEncontrado.getApellido()));
        return "ver";
    }
}
