package com.cristinamellado.tarea3dwescristinamellado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Credencial;

@Repository
public interface CredencialRepository extends JpaRepository<Credencial, Long>{


	@Query("SELECT c FROM Credencial c WHERE c.usuario = :usuario")
	Credencial autenticar(@Param("usuario") String usuario);
	//metodos con operativa con la base de datos
	
	//el JPA repository tiene un montón de métodos que podemos
	//utilizar.
	
}
