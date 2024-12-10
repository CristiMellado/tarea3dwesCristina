package com.cristinamellado.tarea3dwescristinamellado.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Persona;
import com.cristinamellado.tarea3dwescristinamellado.repository.CredencialRepository;
import com.cristinamellado.tarea3dwescristinamellado.repository.PersonaRepository;
import com.cristinamellado.tarea3dwescristinamellado.validacion.Validacion;

@Service
public class ServiciosPersona {
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	CredencialRepository credencialRepository;
	
	
	@Transactional 
	public String registrarPersona(Persona persona, String usuario, String password) {
		StringBuilder mensaje = new StringBuilder();
		
		if (!Validacion.validarUsuario(usuario) ||
				!Validacion.validarContrasena(password) ||
				!Validacion.validarEmail(persona.getEmail())) {
			mensaje.append("Los campos nombre, email o contraseña no son válidos. Revisa los datos y vuelve a introducirlos");
		} else {
			boolean emailExiste = personaRepository.findByEmail(persona.getEmail()) != null;
			boolean usuarioExiste = credencialRepository.findByUsuario(usuario) != null;
			
			if (emailExiste) {
				mensaje.append("El email ").append(persona.getEmail()).append(" ya existe");
			}
			if (usuarioExiste) {
				mensaje.append("El usuario ").append(usuario).append(" ya existe");
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
	
	public Optional<Persona> findById(Long id){
		return personaRepository.findById(id);
	}
	
	
}//class
