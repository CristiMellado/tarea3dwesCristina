package com.cristinamellado.tarea3dwescristinamellado.modelo;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="credenciales")
public class Credencial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_persona")
	Persona persona;

	public Credencial() {}
	
	public Credencial(String usuario, Persona persona) {
		this.usuario = usuario;
		this.persona = persona;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String datosVersionCorta() {
		String resultado = "";
		resultado += "Id: " + id;
		resultado += "\nUsuario " + usuario;
		return resultado;
	}
	
	
}
