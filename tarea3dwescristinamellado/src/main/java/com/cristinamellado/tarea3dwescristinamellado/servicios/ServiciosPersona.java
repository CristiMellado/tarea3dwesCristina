package com.cristinamellado.tarea3dwescristinamellado.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Persona;
import com.cristinamellado.tarea3dwescristinamellado.repository.PersonaRepository;

@Service
public class ServiciosPersona {

	@Autowired
	PersonaRepository personaRepo;

	
	public void insertar(Persona p) {
		personaRepo.saveAndFlush(p);
			//guarda la entidad sobre la tabla que corresponda
		
	}

	


	
}//class
