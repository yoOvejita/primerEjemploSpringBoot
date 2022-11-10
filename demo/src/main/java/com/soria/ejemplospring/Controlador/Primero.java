package com.soria.ejemplospring.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
