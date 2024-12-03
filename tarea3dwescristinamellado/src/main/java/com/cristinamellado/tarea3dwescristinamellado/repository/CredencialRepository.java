package com.cristinamellado.tarea3dwescristinamellado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Credencial;

@Repository
public interface CredencialRepository extends JpaRepository<Credencial, Long>{


	@Query(value = "SELECT * FROM Credenciales c WHERE c.usuario = :usuario AND c.password = :password", nativeQuery = true)
	Credencial autenticar(@Param("usuario") String usuario, @Param("password") String password);

	@Query("SELECT c FROM Credencial c WHERE c.usuario = :usuario")
	Credencial existeCredencial(@Param("usuario") String usuario);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO Credenciales (usuario, password, id_persona) VALUES (:usuario, :password, :id_persona)", nativeQuery = true)
	void insertarCredencial(@Param("usuario") String usuario, @Param("password") String password, @Param("id_persona") Long id_persona);

	
	
}
