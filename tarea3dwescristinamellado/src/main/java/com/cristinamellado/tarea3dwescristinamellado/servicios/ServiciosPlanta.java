package com.cristinamellado.tarea3dwescristinamellado.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Planta;
import com.cristinamellado.tarea3dwescristinamellado.repository.PlantaRepository;

@Service
public class ServiciosPlanta {

	@Autowired
	PlantaRepository plantarepo;

	public boolean validarPlanta(Planta p) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void insertar(Planta p) {
		plantarepo.saveAndFlush(p);
		
	}
	

	
}//class
