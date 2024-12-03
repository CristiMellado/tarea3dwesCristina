package com.cristinamellado.tarea3dwescristinamellado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


public class Principal implements CommandLineRunner{

	@Autowired
	FachadaInvitado fachada;
	@Autowired
	FachadaAdministrador fachadaAdmin;
	@Autowired
	FachadaPersonal fachadaPersonal;
	

	@Override
	public void run(String... args) throws Exception {
	
		fachada.mostrarMenu();
		
		
	}

}//
