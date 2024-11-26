package com.cristinamellado.tarea3dwescristinamellado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Planta;
import com.cristinamellado.tarea3dwescristinamellado.servicios.ServiciosPlanta;

public class Principal implements CommandLineRunner{

	@Autowired
	ServiciosPlanta serviciosPlanta;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("INI");
		System.out.println("-------");
		Planta p = new Planta();
		serviciosPlanta.validarPlanta(p);
		
		serviciosPlanta.insertar(p);
		System.out.println("FIN");
		
	}

}//
