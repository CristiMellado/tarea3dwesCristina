package com.cristinamellado.tarea3dwescristinamellado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Mensaje;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long>{

	
	//metodos con operativa con la base de datos
	
	//el JPA repository tiene un montón de métodos que podemos
	//utilizar.
	
}
