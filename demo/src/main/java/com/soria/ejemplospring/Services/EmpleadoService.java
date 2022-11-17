package com.soria.ejemplospring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soria.ejemplospring.Models.Empleado;
import com.soria.ejemplospring.repositorio.EmpleadoRepositorio;

@Service
public class EmpleadoService {
	@Autowired
	private EmpleadoRepositorio empleadoRepo;
	
	public List<Empleado> lista(){
		return empleadoRepo.findAll();
	}
	public List<Empleado> listaPorNombres(String nom){
		return empleadoRepo.findByNombre(nom);
	}
	
	public List<Empleado> listaPorNombreApellido(String nom, String apellido){
		return empleadoRepo.findByNombreAndApellido(nom, apellido);
	}
}
