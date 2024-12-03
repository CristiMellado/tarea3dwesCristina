package com.cristinamellado.tarea3dwescristinamellado;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Perfil;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Sesion;


@Component
public class FachadaAdministrador {

	private Sesion sesion;
	Scanner teclado = new Scanner(System.in);
	
    // Método para cambiar la sesión activa
    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }
    
	public void mostrarMenu() {
		boolean salir = false;
		while (!salir) {
			try {
				System.out.println("--> MENÚ ADMINISTRADOR <--");
				System.out.println("1. Registrar persona");
				System.out.println("2. Gestión de plantas");
				System.out.println("3. Gestión de ejemplares");
				System.out.println("4. Gestión de mensajes");
				System.out.println("5. Cerrar sesión");
				System.out.print("Introduce una opción: ");
				int opcion = teclado.nextInt();
				switch (opcion) {
				case 1:
					teclado.nextLine();
					System.out.print("Introduce nombre: ");
					String nombre = teclado.nextLine();
					System.out.print("Introduce email: ");
					String email = teclado.nextLine();
					System.out.print("Introduce usuario: ");
					String usuario = teclado.nextLine();
					System.out.print("Introduce password (mínimo 5 caracteres): ");
					String password = teclado.nextLine();
					break;
				case 2:
					mostrarMenuPlantas();
					break;
				case 3:
					mostrarMenuEjemplares();
					break;
				case 4:
					mostrarMenuMensajes();
					break;
				case 5:
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

	// *******************************************************************************************************
	public void mostrarMenuPlantas() {
		boolean salirPlantas = false;
		while (!salirPlantas) {
			try {
				System.out.println("--> GESTIÓN PLANTAS <--");
				System.out.println("1. Nueva Planta");
				System.out.println("2. Modificar Planta");
				System.out.println("3. Volver");
				System.out.print("Introduce una opcion: ");
				int opcion = teclado.nextInt();
				switch (opcion) {
				case 1:
					teclado.nextLine();
					System.out.print("Introduce codigo de planta (solo letras sin espacios): ");
					String codigo = teclado.nextLine().trim().toUpperCase();
					System.out.print("Introduce nombre comun: ");
					String nombreComun = teclado.nextLine();
					System.out.print("Introduce nombre científico: ");
					String nombreCientifico = teclado.nextLine();
					break;
				case 2:
					teclado.nextLine();
					System.out.print("Introduce codigo de planta: ");
					codigo = teclado.nextLine().trim().toUpperCase();
					System.out.print("Introduce nombre común de la planta: ");
					nombreComun = teclado.nextLine();
					System.out.print("Introduce nombre cientifico de la planta: ");
					nombreCientifico = teclado.nextLine();
					break;
				case 3:
					salirPlantas = true;
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

	// *******************************************************************************************************
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
					teclado.nextLine();
					System.out.print("Introduce el codigo de la Planta a seleccionar: ");
					String seleccion = teclado.nextLine().trim().toUpperCase();
					break;
				case 2:
					teclado.nextLine();
					break;
				case 3:
					teclado.nextLine();
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

	// *******************************************************************************************************
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
					teclado.nextLine();
					break;
				case 2:
					teclado.nextLine();
					break;
				case 3:
					// Añadi la hora por que no conseguí el manejo de fechas de manera adecuada sin error
					teclado.nextLine();
					System.out.print("Introduce fecha inicio para mostrar mensajes en formato (YYYY-MM-dd): ");
					String fechaInicio = teclado.nextLine();
					System.out.print("Introduce fecha fin para mostrar mensajes: ");
					String fechaFin = teclado.nextLine();
					break;
				case 4:
					teclado.nextLine();
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

	// *******************************************************************************************************
	private void cerrarSesion() {
		sesion.setPerfil(Perfil.INVITADO);
		sesion.setUsuario(null);
	}
	
}//class
