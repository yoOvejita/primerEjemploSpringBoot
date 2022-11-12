package com.soria.ejemplospring.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soria.ejemplospring.Models.Persona;

@Controller
public class Primero {
	@Value("${valor.secreto}")
	private String val;
	@Autowired
	private ApplicationContext context;
	@RequestMapping("/")
	@ResponseBody
	public String saludo() {
		return "Hola a todos. Lo que les digo es: " + val;
	}
	
	@RequestMapping("/cerrar")
	public void cerrar() {
		SpringApplication.exit(context);
	}
	
	@RequestMapping(value="/registropersona", method= RequestMethod.POST)
	@ResponseBody
	public void prueba(@RequestBody Persona p) {
		System.out.printf("Se recibió a %s %s con id: %d", p.getNombre(), p.getApellido(), p.getId());
	}
	
	@RequestMapping(value="/person/{id}")
	@ResponseBody
	public void prueba2(@PathVariable("id") String codigo) {
		System.out.printf("El valor enviado es %s\n", codigo);
	}
	
	@RequestMapping("/ejemplo1")
	public ResponseEntity<String> ejemplo1(){
		return ResponseEntity.ok("Todo listo");
	}
	
	@RequestMapping("/ejemplo2")
	public ResponseEntity ejemplo2(){
		return (ResponseEntity) ResponseEntity.badRequest();
	}
	
}
