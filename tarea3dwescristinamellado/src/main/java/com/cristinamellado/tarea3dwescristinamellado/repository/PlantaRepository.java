package com.cristinamellado.tarea3dwescristinamellado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Planta;
@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long>{

}
