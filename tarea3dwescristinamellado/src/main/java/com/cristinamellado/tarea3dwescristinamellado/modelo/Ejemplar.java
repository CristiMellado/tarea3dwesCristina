package com.cristinamellado.tarea3dwescristinamellado.modelo;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ejemplar")
public class Ejemplar implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="idplanta")
	private Planta planta;
	
	public Ejemplar() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreString() {
		return nombre;
	}

	public void setNombreString(String nombreString) {
		this.nombre = nombreString;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}
	
	
	

}
