package com.backend.springboot.app.springbooterror.controllers;

import com.backend.springboot.app.springbooterror.errors.UsuarioNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/*@ControllerAdvice: se utiliza para definir un controlador global de excepciones que se aplica a todos los
 controladores de la aplicación*/
@ControllerAdvice
public class ErrorHandleController {

    /*@ExceptionHandler se invoca cuando se lanza una excepción específica desde un método en un controlador.
    *Dentro, se especifica el error que se quiere capturar */
//    @ExceptionHandler(ArithmeticException.class)
//    public String aritmeticaError(ArithmeticException ex, Model model) {
//        model.addAttribute("error", " Error de aritmética");
//        model.addAttribute("mensaje", ex.getMessage());
//        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
//        model.addAttribute("timestamp", new Date());
//        return "error/generica";
//    }

    @ExceptionHandler(NumberFormatException.class)
    public String numberFormatError(NumberFormatException ex, Model model) {
        model.addAttribute("error", "Formato número inválido");
        model.addAttribute("mensaje", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/generica";
    }

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public String usuarioNotFound(UsuarioNoEncontradoException ex, Model model) {
        model.addAttribute("error", "Usuario no encontrado.");
        model.addAttribute("mensaje", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/generica";
    }
}
