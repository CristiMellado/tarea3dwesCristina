package com.cristinamellado.tarea3dwescristinamellado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Planta;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long>{

	
	default boolean existePlanta(Planta planta) {
		List<Planta> listaPlantas = findAll();
		for (Planta aux : listaPlantas) {
			if(planta.getCodigo().equals(aux.getCodigo())) {
				return true;
			}
		}
		return false;
	};

	

	
}
