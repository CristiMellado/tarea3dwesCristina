package com.cristinamellado.tarea3dwescristinamellado.modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="plantas")
public class Planta implements Serializable {

	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //el valor se genera automaticamente
	private Long id;
	
	@Column(unique = true)
	private String codigo;
	
	@Column
	private String nombreComun;
	
	@Column
	private String nombreCientifico;
	
	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name="id_planta")
	private List<Ejemplar> listaEjemplares = new LinkedList<Ejemplar>();
	
	public Planta() {}
	
	public Planta(String codigo, String nombreComun, String nombreCientifico, List<Ejemplar> listaEjemplares) {
		this.codigo = codigo;
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
		this.listaEjemplares = listaEjemplares;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public List<Ejemplar> getListaEjemplares() {
		return listaEjemplares;
	}

	public void setListaEjemplares(List<Ejemplar> listaEjemplares) {
		this.listaEjemplares = listaEjemplares;
	}


	public String datosVersionCorta() {
		String resultado = "";
		resultado += "ID: " + id;
		resultado += "\nCódigo: " + codigo;
		return resultado;
	}

	public String datosVersionLarga() {
		String resultado = "";
		resultado += "ID: " + id;
		resultado += "\nCódigo: " + codigo;
		resultado += "\nNombre común: " + nombreComun;
		resultado += "\nNombre científico: " + nombreCientifico;
		return resultado;
	}
	
	
	

	
}//class
