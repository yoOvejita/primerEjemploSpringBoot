package com.soria.ejemplospring.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soria.ejemplospring.Bean.Saludador;

@Component
public class EjemploService {
	
	private Saludador saludador;
	
	@Autowired(required = false)
	public EjemploService(Saludador saludador) {
		
		this.saludador = saludador;
	}
	
	public void setSaludador(Saludador saludador) {
		this.saludador = saludador;
	}
	
}
