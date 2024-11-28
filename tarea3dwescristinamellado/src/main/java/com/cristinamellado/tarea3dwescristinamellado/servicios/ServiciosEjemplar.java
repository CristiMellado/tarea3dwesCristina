package com.cristinamellado.tarea3dwescristinamellado.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Credencial;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Ejemplar;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Persona;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Planta;
import com.cristinamellado.tarea3dwescristinamellado.repository.CredencialRepository;
import com.cristinamellado.tarea3dwescristinamellado.repository.EjemplarRepository;
import com.cristinamellado.tarea3dwescristinamellado.repository.PersonaRepository;
import com.cristinamellado.tarea3dwescristinamellado.repository.PlantaRepository;

@Service
public class ServiciosEjemplar {

	@Autowired
	EjemplarRepository ejemplarRepository;

	
	public void insertar(Ejemplar ejemplar) {
		ejemplarRepository.saveAndFlush(ejemplar);
			//guarda la entidad sobre la tabla que corresponda
		
	}


	

	
}//class
