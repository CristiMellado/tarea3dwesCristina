package com.cristinamellado.tarea3dwescristinamellado.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Persona;
import com.cristinamellado.tarea3dwescristinamellado.repository.CredencialRepository;
import com.cristinamellado.tarea3dwescristinamellado.repository.PersonaRepository;

@Service
public class ServiciosPersona {

	
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	CredencialRepository credencialRepository;
	
	
	public boolean insertarPersona(Persona persona, String usuario, String password) {
		if(!existePersona(persona.getEmail())) {
			Persona p = personaRepository.saveAndFlush(persona);
			if(p != null) {
				credencialRepository.insertarCredencial(usuario, password, p.getId());
				return true;
			}
		}
		return false;
	}
	

	public boolean existePersona(String email) {
		if( personaRepository.existePersona(email)!=null) {
			return true;
		}
		return false;
	}
	

	


	
}//class
