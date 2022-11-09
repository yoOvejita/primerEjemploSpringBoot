package com.soria.ejemplospring.Bean;

import org.springframework.stereotype.Component;

@Component("cosa")
public class Saludador {
	public String unMetodo() {
		return "este es un mensaje";
	}
}
