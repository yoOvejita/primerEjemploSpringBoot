package com.soria.ejemplospring.Controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.soria.ejemplospring.Exceptions.PersonaNoEncontradaException;

@ControllerAdvice
public class PersonaExceptionController {
	@ExceptionHandler(value = PersonaNoEncontradaException.class)
	public ResponseEntity<Object> unaExcepcion(PersonaNoEncontradaException ee) {
		return new ResponseEntity<>("No se encontró a la persona.", HttpStatus.NOT_FOUND);
	}
}
