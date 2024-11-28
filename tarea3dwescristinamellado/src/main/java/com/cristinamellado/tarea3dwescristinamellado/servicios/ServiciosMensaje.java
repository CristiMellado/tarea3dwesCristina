package com.cristinamellado.tarea3dwescristinamellado.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Mensaje;
import com.cristinamellado.tarea3dwescristinamellado.repository.MensajeRepository;

@Service
public class ServiciosMensaje {

	@Autowired
	MensajeRepository mensajesRepository;

	
	public void insertar(Mensaje p) {
		mensajesRepository.saveAndFlush(p);
			//guarda la entidad sobre la tabla que corresponda
		
	}


	

	
}//class
