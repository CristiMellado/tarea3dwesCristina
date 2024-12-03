package com.cristinamellado.tarea3dwescristinamellado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Ejemplar;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Planta;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Long>{

	
	default Long ultimoIdEjemplarByPlanta(Planta planta) {
		List<Ejemplar> listaEjemplares = findAll();
		if(!listaEjemplares.isEmpty()) {
			long ret = 0;
			for (Ejemplar ejemplar : listaEjemplares) {
				if(ejemplar.getPlanta().getId().equals(planta.getId())) {
					ret++;
				}
			}
			return ret;
		}
		return 0L;
	}

	
}
