package com.cristinamellado.tarea3dwescristinamellado.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Mensaje;
import com.cristinamellado.tarea3dwescristinamellado.repository.MensajeRepository;

@Service
public class ServiciosMensaje {

	@Autowired
	MensajeRepository mensajesRepository;

	
	public boolean insertarMensaje(Mensaje p) {
		if(mensajesRepository.saveAndFlush(p)!=null) {
			return true;
		}
		return false;
	}

	
}//class
