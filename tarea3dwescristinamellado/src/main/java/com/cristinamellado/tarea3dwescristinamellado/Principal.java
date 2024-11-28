package com.cristinamellado.tarea3dwescristinamellado;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.cristinamellado.tarea3dwescristinamellado.modelo.*;
import com.cristinamellado.tarea3dwescristinamellado.servicios.*;

public class Principal implements CommandLineRunner{

	@Autowired
	ServiciosPlanta serviciosPlanta;
	
	@Autowired
	ServiciosPersona serviciosPersona;
	
	@Autowired
	ServiciosCredencial serviciosCredencial;
	
	@Autowired
	ServiciosMensaje serviciosMensaje;
	
	@Autowired
	ServiciosEjemplar serviciosEjemplar;
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("INI");
		System.out.println("-------");
		
		//pruebas para checar relaciones
		//1. Crear planta
		Planta planta = new Planta("PE", "Petunia", "Petuniux", null);
		serviciosPlanta.insertar(planta);
		
		//2. Crear credencial y persona
		Credencial credencial = new Credencial("cristi");
		Persona persona = new Persona("Cristina", "cristi.mellado@gmail.com");
		persona.setCredencial(credencial);
		serviciosPersona.insertar(persona);
		
		//3. Crear ejemplar
		Ejemplar ejemplar = new Ejemplar("Ejemplar1", planta, null);
		serviciosEjemplar.insertar(ejemplar);
		
		//4. Crear mensajes
		Mensaje mensaje = new Mensaje("Prueba", persona, ejemplar);
		Mensaje mensaje1 = new Mensaje("Prueba1", persona, ejemplar);
		
		serviciosMensaje.insertar(mensaje);
		serviciosMensaje.insertar(mensaje1);
		
		System.out.println("FIN");
		
	}

}//
