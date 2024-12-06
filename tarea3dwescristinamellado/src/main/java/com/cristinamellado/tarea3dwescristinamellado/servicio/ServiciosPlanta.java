package com.cristinamellado.tarea3dwescristinamellado.servicio;

import java.util.List;
import java.util.Optional;

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
	
	
	/**
	 * CU4A: Insertar Planta
	 * @return boolean que indica si se pudo o no insertar la planta
	 */
	public boolean insertarPlanta(Planta planta) {
		if(plantaRepository.findByCodigo(planta.getCodigo()) == null) {
			plantaRepository.saveAndFlush(planta);
			return true;
		}
		return false;
	}
	
	
	/**
	 * CU4B: Modificar Planta
	 * @return boolean que indica si se pudo o no modificar la planta
	 */
	public boolean modificarPlanta(Planta planta) {
		if(plantaRepository.existsById(planta.getId())) {
			plantaRepository.saveAndFlush(planta);
			return true;
		}
		return false;
	}
	
	public Optional<Planta> existePlanta(Long id) {
		return plantaRepository.findById(id);
	}
	

	
}//class
