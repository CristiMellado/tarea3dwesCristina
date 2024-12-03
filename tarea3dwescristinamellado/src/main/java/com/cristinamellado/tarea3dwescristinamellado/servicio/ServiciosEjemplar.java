package com.cristinamellado.tarea3dwescristinamellado.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Ejemplar;
import com.cristinamellado.tarea3dwescristinamellado.repository.EjemplarRepository;


@Service
public class ServiciosEjemplar {

	@Autowired
	EjemplarRepository ejemplarRepo;

	
	public void insertarEjemplar(Ejemplar ejemplar) {
		ejemplarRepo.saveAndFlush(ejemplar);
	}


	

	
}//class
