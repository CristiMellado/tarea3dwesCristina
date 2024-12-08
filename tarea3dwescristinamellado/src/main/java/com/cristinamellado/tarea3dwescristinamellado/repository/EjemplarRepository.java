package com.cristinamellado.tarea3dwescristinamellado.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cristinamellado.tarea3dwescristinamellado.modelo.Ejemplar;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Mensaje;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Long>{


	/**
	 * Obtener la lista de todos los ejemplares. 
	 * Si la lista tiene ejemplares, se devuelve el numero de ejemplares + 1 y sino se devuelve 1
	 * @return Long que indica la siguiente posición del Ejemplar a insertar
	 */
	default Long siguienteIdEjemplar() {
		List<Ejemplar> listaEjemplares = findAll();
		if(!listaEjemplares.isEmpty()) {
			return count()+1;
		}
		return 1L;
	}

	@Query("Select e from Ejemplar e where e.planta.id in (:seleccionIds)")
	 List<Ejemplar> filtrarEjemplaresPlanta(@Param("seleccionIds") List<Long> seleccionIds);
	
	@Query("""
			Select e.listaMensajes from Ejemplar e
			JOIN e.listaMensajes m 
			JOIN m.persona 
			WHERE e.id = :idEjemplar
			ORDER BY m.fechahora
			""")
	List<Mensaje> seguimientoMensajes(@Param("idEjemplar") Long idEjemplar);
	
	Optional<Ejemplar> findById( Long id);
	
}
