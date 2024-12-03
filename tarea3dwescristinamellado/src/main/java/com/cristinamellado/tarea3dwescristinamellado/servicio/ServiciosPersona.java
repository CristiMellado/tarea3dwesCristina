package com.cristinamellado.tarea3dwescristinamellado.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cristinamellado.tarea3dwescristinamellado.repository.CredencialRepository;
import com.cristinamellado.tarea3dwescristinamellado.repository.PersonaRepository;

@Service
public class ServiciosPersona {

	
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	CredencialRepository credencialRepository;

//	public boolean existePersona(Persona persona) {
//		return personaRepository.existePersona(persona);
//	}
	
//	public boolean insertarPersona(Persona persona) {
//		if(!existePersona(persona)) {
//			personaRepository.saveAndFlush(persona);
//			return true;
//		}
//		return false;
//	}

	


	
}//class
