package com.cristinamellado.tarea3dwescristinamellado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tarea3dwescristinamelladoApplication {
	
	//se añade referencia a la clase principal
	
	@Bean
	public Principal applicationStartupRunner() {
		return new Principal();
	}

	public static void main(String[] args) {
		SpringApplication.run(Tarea3dwescristinamelladoApplication.class, args);
	}

}
