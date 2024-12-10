package com.cristinamellado.tarea3dwescristinamellado;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristinamellado.tarea3dwescristinamellado.modelo.*;
import com.cristinamellado.tarea3dwescristinamellado.servicio.ServiciosCredencial;
import com.cristinamellado.tarea3dwescristinamellado.servicio.ServiciosPlanta;


@Component
public class FachadaInvitado {
	
	@Autowired
	ServiciosPlanta serviciosPlanta;
	@Autowired
	ServiciosCredencial serviciosCredencial;
    @Autowired
    FachadaAdministrador fachadaAdministrador;
    @Autowired
    FachadaPersonal fachadaPersonal;
    
	Scanner teclado = new Scanner(System.in);

	public static Sesion sesion = new Sesion(Perfil.INVITADO);
	
	public void mostrarMenu() {
		boolean salir = false;
			while(!salir) {
				try {
					System.out.println("--> MENU INVITADO <--");
					System.out.println("1. Ver plantas");
					System.out.println("2. Login");
					System.out.println("3. Salir");
					System.out.print("Introduce una opción: ");
					int opcion=teclado.nextInt();
					List<Planta> listaPlantas;
					switch(opcion) {
					case 1:
						listaPlantas = serviciosPlanta.verPlantas();
						if(!listaPlantas.isEmpty()) {
							for (Planta planta : listaPlantas) {
								System.out.println(planta.datosVersionLarga());
							}
						}else {
							System.out.println("No existe ninguna planta");
						}	
					break;
					case 2:
						teclado.nextLine();
						System.out.print("Introduce nombre del usuario: ");
						String usuario = teclado.nextLine();
						System.out.print("Introduce su contraseña: ");
						String password = teclado.nextLine();

						boolean correcto = serviciosCredencial.autenticar(usuario.trim(), password.trim());

						if (correcto) {
							sesion.setUsuario(usuario);
							System.out.println("¡Bienvenid@ "+ usuario.toUpperCase()+"!");
							if (sesion.getPerfil() == Perfil.ADMINISTRADOR) {
								fachadaAdministrador.setSesion(sesion);
								fachadaAdministrador.mostrarMenu();
							} else {
								fachadaPersonal.setSesion(sesion);
								fachadaPersonal.mostrarMenu();
							}
						} else {
							System.out.println("No se pudo autenticar el usuario");
						}
					break;
					case 3:
						System.out.println("Saliendo del programa...");
						salir=true;
						break;
					default:
						System.out.println("Opción incorrecta");
					}
				} catch (InputMismatchException e) {
					System.out.println("Entrada no válida. Introduce el tipo de dato correcto.");
					teclado.nextLine();
				} catch (Exception e) {
					System.out.println("Ocurrio un error " + e.getMessage());
				}

		}
		
	}
	
	
}//class
