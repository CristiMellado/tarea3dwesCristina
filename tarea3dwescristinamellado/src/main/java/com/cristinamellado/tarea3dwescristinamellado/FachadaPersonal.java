package com.cristinamellado.tarea3dwescristinamellado;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Perfil;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Sesion;

@Component
public class FachadaPersonal {

	Scanner teclado = new Scanner(System.in);
	
	private Sesion sesion;
	
    // Método para cambiar la sesión activa
    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }
	
	public void mostrarMenu() {
		boolean salir = false;
		while (!salir) {
			try {
				System.out.println("--> MENÚ PERSONAL <--");
				System.out.println("1. Gestión de ejemplares");
				System.out.println("2. Gestión de mensajes");
				System.out.println("3. Cerrar Sesión");
				System.out.print("Introduce una opción: ");
				int opcion = teclado.nextInt();
				switch (opcion) {
				case 1:
					mostrarMenuEjemplares();
					break;
				case 2:
					mostrarMenuMensajes();
					break;
				case 3:
					cerrarSesion();
					salir = true;
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

 //************************************************************************************************	

	public void mostrarMenuEjemplares() {
		boolean salirEjemplares = false;
		while (!salirEjemplares) {
			try {
				System.out.println("--> GESTIÓN EJEMPLARES <--");
				System.out.println("1. Registrar un nuevo ejemplar");
				System.out.println("2. Filtrar ejemplares por tipo de planta");
				System.out.println("3. Ver mensajes de seguimiento de un ejemplar");
				System.out.println("4. Volver");
				System.out.print("Introduce una opción: ");
				int opcion = teclado.nextInt();
				switch (opcion) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					salirEjemplares = true;
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
	
//*************************************************************************************************
	private void mostrarMenuMensajes() {
		boolean salirMensajes = false;
		while (!salirMensajes) {
			try {
				System.out.println("--> GESTIÓN MENSAJES <--");
				System.out.println("1. Insertar mensaje de seguimiento de un ejemplar");
				System.out.println("2. Filtrar mensajes por persona");
				System.out.println("3. Filtrar mensajes por rango de fechas");
				System.out.println("4. Filtrar mensajes por tipo de planta");
				System.out.println("5. Volver");
				System.out.print("Introduce una opción: ");
				int opcion = teclado.nextInt();
				switch (opcion) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					salirMensajes = true;
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
	
	
//**************************************************************************************************
	private void cerrarSesion() {
		sesion.setPerfil(Perfil.INVITADO);
		sesion.setUsuario(null);
	}
	
	
}//class
