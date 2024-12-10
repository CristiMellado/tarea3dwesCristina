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
		boolean valido = true;
		
		if(!Validacion.validarEmail(persona.getEmail())){
			mensaje.append("El campo email no es válido. ");
			valido = false;
		}
		if(!Validacion.validarUsuario(usuario)) {
			mensaje.append("El campo usuario no es válido. ");
			valido = false;
		}
		if(!Validacion.validarContrasena(password)){
			mensaje.append("El campo contraseña no es válido. ");
			valido = false;
		}
		
		if (valido) {
			boolean emailExiste = personaRepository.findByEmail(persona.getEmail()) != null;
			boolean usuarioExiste = credencialRepository.findByUsuario(usuario) != null;
			
			if (emailExiste) {
				mensaje.append("El email ").append(persona.getEmail().toUpperCase()).append(" ya existe. Prueba con otro. ");
			}
			if (usuarioExiste) {
				mensaje.append("El usuario ").append(usuario.toUpperCase()).append(" ya existe. Prueba con otro. ");
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
