package com.cristinamellado.tarea3dwescristinamellado.modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="personas")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column
	private String nombre;
	
	@Column(unique = true)
	private String email;
	
	//Relacion 1 a 1 unidireccional de Persona hacia Credencial
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_credencial")
	private Credencial credencial;
	
	//Relacion 1 n de mensajes 
	@OneToMany
	@JoinColumn(name="id_persona")
	private List<Mensaje> listaMensajes= new LinkedList<Mensaje>();

	public Persona() {}
		

	public Persona(String nombre, String email, Credencial credencial, List<Mensaje> listaMensajes) {
		this.nombre = nombre;
		this.email = email;
		this.credencial = credencial;
		this.listaMensajes = listaMensajes;
	}
	
	public Persona(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Credencial getCredencial() {
		return credencial;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}

	public List<Mensaje> getListaMensajes() {
		return listaMensajes;
	}

	public void setListaMensajes(List<Mensaje> listaMensajes) {
		this.listaMensajes = listaMensajes;
	}
	
	
	
	
}
