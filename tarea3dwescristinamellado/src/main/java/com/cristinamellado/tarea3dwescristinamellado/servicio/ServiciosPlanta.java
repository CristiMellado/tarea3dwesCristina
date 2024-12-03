package com.cristinamellado.tarea3dwescristinamellado.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Planta;
import com.cristinamellado.tarea3dwescristinamellado.repository.PlantaRepository;

@Service
public class ServiciosPlanta {

	
	@Autowired
	PlantaRepository plantaRepository;

	/**
	 * CU1: Ver Plantas
	 * @return lista completa de plantas
	 */
	public List<Planta> verPlantas(){
		return plantaRepository.findAll();
	}
	
	
	
	public boolean existePlanta(Planta planta) {
		return plantaRepository.existePlanta(planta);
	}
	
	
	public boolean insertarPlanta(Planta planta) {
		if(!existePlanta(planta)) {
			plantaRepository.saveAndFlush(planta);
			return true;
		}
		return false;
	}
	
	
	

	
}//class
