package com.soria.ejemplospring.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Primero {
	@RequestMapping("/")
	@ResponseBody
	public String saludo() {
		return "Hola a todos.";
	}
}
