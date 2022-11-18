package com.soria.ejemplospring.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soria.ejemplospring.Models.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long>{
	List<Empleado> findByNombre(String nombre);
	List<Empleado> findByNombreAndApellido(String nombre, String apellido);
	
	//Variantes de findBy con Is y Equals
	Empleado findById(int id);
	Empleado findByIdIs(int id);
	Empleado findByIdEquals(int id);
	
	//Para la accion contraria al findBy
	List<Empleado> findByNombreNot(String nombre);
	List<Empleado> findByNombreIsNot(String nombre);
	
	//Like, NotLike, Containing, StartingWith y EndingWith
	List<Empleado> findByApellidoLike(String txt);
	List<Empleado> findByApellidoStartingWith(String txt);
	List<Empleado> findByApellidoEndingWith(String txt);
	List<Empleado> findByApellidoContaining(String txt);
	
	//SELECT * FROM empleado WHERE nombre = 'Samanta' OR ...containing
	List<Empleado> findByApellidoContainingOrNombre(String txt, String nombre);
	
	List<Empleado> findByApellidoContainingAndNombre(String txt, String nombre);
	
	
	//Manejo de booleanos
	//List<Empleado> findByCasadoTrue();
	//List<Empleado> findByCasadoFalse();
}
