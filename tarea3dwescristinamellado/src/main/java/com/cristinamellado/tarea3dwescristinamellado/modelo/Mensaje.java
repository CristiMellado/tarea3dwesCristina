package com.cristinamellado.tarea3dwescristinamellado.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="mensajes")
public class Mensaje implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private LocalDateTime fechahora;
	
	@Column
	private String mensaje;
	
	//relación mensajes-persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;
	
	//relación mensajes-ejemplar
	@ManyToOne
	@JoinColumn(name="id_ejemplar")
	private Ejemplar ejemplar;
	
	public Mensaje() {}

	public Mensaje(String mensaje, Persona persona,Ejemplar ejemplar) {
		this.fechahora = LocalDateTime.now();
		this.mensaje = mensaje;
		this.persona = persona;
		this.ejemplar = ejemplar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechahora() {
		return fechahora;
	}

	public void setFechahora(LocalDateTime fechahora) {
		this.fechahora = fechahora;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}
	
	
	
}
