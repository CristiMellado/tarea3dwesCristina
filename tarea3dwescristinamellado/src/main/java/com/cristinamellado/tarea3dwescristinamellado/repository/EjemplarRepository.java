package com.cristinamellado.tarea3dwescristinamellado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Credencial;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Ejemplar;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Long>{

	
	//metodos con operativa con la base de datos
	
	//el JPA repository tiene un montón de métodos que podemos
	//utilizar.
	
}
