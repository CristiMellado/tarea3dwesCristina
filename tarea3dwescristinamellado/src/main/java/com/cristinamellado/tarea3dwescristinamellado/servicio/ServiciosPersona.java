package com.cristinamellado.tarea3dwescristinamellado.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Persona;
import com.cristinamellado.tarea3dwescristinamellado.repository.CredencialRepository;
import com.cristinamellado.tarea3dwescristinamellado.repository.PersonaRepository;

@Service
public class ServiciosPersona {
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	CredencialRepository credencialRepository;
	
	
	@Transactional 
	public String registrarPersona(Persona persona, String usuario, String password) {
		StringBuilder mensaje = new StringBuilder();
		
	    // Verificar existencia previa de email y usuario mediante consultas derivadas
	    boolean emailExiste = personaRepository.findByEmail(persona.getEmail()) != null;
	    boolean usuarioExiste = credencialRepository.findByUsuario(usuario) != null;
	    
	    if (emailExiste) {
	        mensaje.append("El email ").append(persona.getEmail()).append(" ya existe. ");
	    }
	    if (usuarioExiste) {
	        mensaje.append("El usuario ").append(usuario).append(" ya existe. ");
	    }
	    if (emailExiste || usuarioExiste) {
	        return mensaje.toString();
	    }
	    
	    try {
	        Persona p = personaRepository.saveAndFlush(persona);
	        if (p != null) {
	            credencialRepository.insertarCredencial(usuario, password);
	            mensaje.append("Se insertó correctamente la persona y su credencial.");
	        }
	    } catch (Exception e) {
	        mensaje.append("No se pudo insertar la persona. Intenta nuevamente.");
	    }

	    return mensaje.toString();
	}
	

	public boolean existePersona(String email) {
		if( personaRepository.existePersona(email)!=null) {
			return true;
		}
		return false;
	}

	public Persona findByNombre(String nombre) {
		return personaRepository.findByNombre(nombre);
	}
	
	public List<Persona> mostrarPersonas(){
		return personaRepository.findAll();
	}
	
	
}//class
