package com.soria.ejemplospring.Controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soria.ejemplospring.Exceptions.PersonaNoEncontradaException;
import com.soria.ejemplospring.Models.Persona;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PersonaController {
	public static Map<String,Persona> personas = new HashMap<>();
	
	static {
		Persona p = new Persona(1, "Pepe", "Perales");
		Persona pp = new Persona(2, "Ana", "Rocha");
		Persona ppp = new Persona(3, "Sofia", "Sosa");
		personas.put("1", p);
		personas.put("2", pp);
		personas.put("3", ppp);
	}
	@RequestMapping("/persona")
	public ResponseEntity<Object> getPersonas(){
		return new ResponseEntity<>(personas.values(), HttpStatus.OK);
	}
	@RequestMapping(value="/persona", method= RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> setPersona(@RequestBody Persona p) {
		personas.put(p.getId()+"", p);
		return new ResponseEntity<>("Se creó a la persona " + p.getId(), HttpStatus.CREATED);
	}
	@RequestMapping(value="/persona/{id}", method= RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Object> updatePersona(@PathVariable("id") int codigo, @RequestBody Persona p) {
		if(!personas.containsKey(codigo+""))
			throw new PersonaNoEncontradaException();
		personas.remove(codigo);
		p.setId(codigo);
		personas.put(codigo+"", p);
		return new ResponseEntity<>("Se actualizó a la persona " + p.getId(), HttpStatus.OK);
	}
	@RequestMapping(value="/persona/{id}", method= RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Object> deletePersona(@PathVariable("id") String codigo) {
		personas.remove(codigo);
		
		return new ResponseEntity<>("Se eliminó a la persona de ID " + codigo, HttpStatus.OK);
	}
	
	@RequestMapping(value="/persona/{id}")
	@ResponseBody
	public ResponseEntity<String> getPersona(@PathVariable("id") String codigo) {
		Persona p =personas.get(codigo);
		HttpHeaders headers = new HttpHeaders();
		headers.add("apellido-header",p.getApellido());
		return new ResponseEntity<>("Fiajte en el header",headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/persona/edad")
	public ResponseEntity<String> getEdad(@RequestParam("year") int year) {
		if(year > 2022)
			return ResponseEntity.badRequest().body("Valor de anyo demasiado a futuro.");
		else
			return ResponseEntity.status(HttpStatus.OK).header("el anyo enviado", year+"").body("La edad es: " + (2022 - year));
	}
	@RequestMapping(value="/persona/direccion")
	public void getDireccion(HttpServletResponse response) throws IOException {
		response.setHeader("un_valor", "abc123");
		response.setStatus(201);
		response.getWriter().println("Esta es una respuesta");
	}
	
	@RequestMapping(value="/persona/artificial")
	@ResponseBody
	// PostMapping(value="/persona/artificial", produces = MediaType.APPLICATION_XML_VALUE)
	public Persona getPersona2() {
		return new Persona(123, "Pepex","Pepper");
	}
}
