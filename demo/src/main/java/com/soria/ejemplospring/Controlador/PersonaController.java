package com.soria.ejemplospring.Controlador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soria.ejemplospring.Models.Persona;

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
		personas.remove(codigo);
		p.setId(codigo);
		personas.put(codigo+"", p);
		return new ResponseEntity<>("Se actualizó a la persona " + p.getId(), HttpStatus.OK);
	}
}
