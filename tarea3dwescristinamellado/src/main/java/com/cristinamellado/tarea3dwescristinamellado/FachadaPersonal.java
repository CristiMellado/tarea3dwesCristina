package com.cristinamellado.tarea3dwescristinamellado;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cristinamellado.tarea3dwescristinamellado.modelo.*;
import com.cristinamellado.tarea3dwescristinamellado.servicio.*;


@Component
public class FachadaPersonal {

	Scanner teclado = new Scanner(System.in);
	
	private Sesion sesion;
	
	@Autowired
	ServiciosPlanta serviciosPlanta;
	
	@Autowired
	ServiciosPersona serviciosPersona;
	
	@Autowired
	ServiciosMensaje serviciosMensaje;
	
	@Autowired
	ServiciosEjemplar serviciosEjemplar;
	
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
					teclado.nextLine();
					List<Planta> listaPlantas=serviciosPlanta.verPlantas();
					for (Planta planta : listaPlantas) {
						System.out.println(planta.datosVersionCorta());
					}
					System.out.print("Indroduce el id de la  planta que quieres para crear el ejemplar: ");
					Long id=teclado.nextLong();
					teclado.nextLine();
					Optional<Planta> planta=serviciosPlanta.existePlanta(id);
					String nombreEjemplar= planta.get().getCodigo().toUpperCase()+"_"
													+serviciosEjemplar.siguienteIdEjemplar();
					
					Persona persona = serviciosPersona.findByNombre(sesion.getUsuario());
					String mensajeInicial= "Mensaje inicial escrito por " + persona.getNombre() + " a las " + new Date();
					
					List<Mensaje> listaMensajes= new LinkedList<Mensaje>();
					listaMensajes.add(new Mensaje(mensajeInicial, persona, null));
					
					Ejemplar ejemplar = new Ejemplar(nombreEjemplar, planta.get(), listaMensajes);
					if (serviciosEjemplar.insertarEjemplar(ejemplar)) {
						System.out.println("Se inserto el ejemplar " + nombreEjemplar);
					} else {
						System.out.println("No se pudo insertar el ejemplar");
					}
					break;
				case 2:
					teclado.nextLine();
					listaPlantas = serviciosPlanta.verPlantas();
					System.out.println("Lista de plantas:");
					for (Planta p : listaPlantas) {
						System.out.println(p.datosVersionCorta());
					}
					System.out.print("Introduce el id o id`s de plantas (separados por coma) para mostrar ejemplares: ");
					String ids = teclado.nextLine();
					String[] idsVarios = ids.split(",");
					ArrayList<Long> seleccionIds = new ArrayList<Long>();
					for (String idPlanta : idsVarios) {
						seleccionIds.add(Long.parseLong(idPlanta.trim()));
					}
					List<Ejemplar> listaEjemplares = serviciosEjemplar.filtrarEjemplaresPlanta(seleccionIds);
					if (listaEjemplares.size() > 0) {
				        System.out.println("Nombre del Ejemplar | Nº de Mensajes | Fecha/Hora del Último Mensaje");
				        System.out.println("--------------------------------------------------------------------");

				        // Mostrar los mensajes de cada ejemplar
				        for (Ejemplar ej : listaEjemplares) {
				            System.out.print(ej.getNombre() + "\t\t\t\t");
				            System.out.print(ej.getListaMensajes().size() + "\t");

				            // Mostrar la fecha del último mensaje si existe
				            if (!ej.getListaMensajes().isEmpty()) {
				            	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm");
				                Mensaje ultimoMensaje = ej.getListaMensajes().get(ej.getListaMensajes().size() - 1);
				                System.out.println(formatter.format(ultimoMensaje.getFechahora()));
				            } else {
				                System.out.println("No hay mensajes");
				            }
				        }
				    } else {
				        System.out.println("No se encontraron ejemplares para los IDs de plantas proporcionados.");
				    }
					break;
				case 3:
					teclado.nextLine();
					List<Ejemplar> lista=serviciosEjemplar.listaEjemplares();
					for (Ejemplar ej : lista) {
						System.out.println(ej.datosVersionCorta());
					}
					System.out.print("Introduce el id del ejemplar del cual quiere ver los mensajes de seguimiento: ");
					Long idEjemplar=teclado.nextLong();
					List<Mensaje> mensajes=serviciosEjemplar.seguimientoMensajes(idEjemplar);
					for (Mensaje mensaje : mensajes) {
						System.out.println(mensaje.datosVersionLarga());
					}
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
					teclado.nextLine();
					List<Ejemplar> listaEjemplares=serviciosEjemplar.listaEjemplares();
					for (Ejemplar ejemplar : listaEjemplares) {
						System.out.println(ejemplar.datosVersionCorta());
					}
					System.out.print("Introduce el id del ejemplar para añadir el mensaje: ");
					Long id=teclado.nextLong();
					teclado.nextLine();
					Ejemplar ejemplar = serviciosEjemplar.findById(id).get();
					System.out.print("Introduce tu mensaje: ");
					String mensaje = teclado.nextLine();
					Persona persona = serviciosPersona.findByNombre(sesion.getUsuario());
					Mensaje msj = new Mensaje(mensaje,persona, ejemplar);
					if(serviciosMensaje.insertarMensaje(msj)) {
						System.out.println("Se insertó correctamente el mensaje");
					}else {
						System.out.println("Error al introducir el mensaje");
					}
					break;
				case 2:
					teclado.nextLine();
					List<Persona> listaPersonas= serviciosPersona.mostrarPersonas();
					for (Persona ps : listaPersonas) {
						System.out.println(ps.datosVersionCorta());
					}
					System.out.print("Introduce el id de la persona para visualizar sus mensajes: ");
					Long idPersona=teclado.nextLong();
					List<Mensaje> listaMensajes= serviciosMensaje.filtrarMensajesPersona(idPersona);
					for (Mensaje msjs : listaMensajes) {
						System.out.println(msjs.datosVersionCorta());
					}
					break;
				case 3:
					teclado.nextLine();
					System.out.print("Introduce la fecha de inicio para visualizar los mensajes (formato DD-MM-YYYY): ");
					String fechaInicioString = teclado.nextLine().trim();
					System.out.print("Introduce la fecha de fin para visualizar los mensajes (formato DD-MM-YYYY): ");
					String fechaFinString = teclado.nextLine().trim();
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDateTime fechaInicio = LocalDate.parse(fechaInicioString, formatter).atTime(0, 0, 0);
					LocalDateTime fechaFin = LocalDate.parse(fechaFinString, formatter).atTime(23, 59, 59);
					List<Mensaje> mensajes = serviciosMensaje.filtrarMensajesRangoFechas(fechaInicio, fechaFin);
					for (Mensaje m : mensajes) {
						System.out.println(m.datosVersionCorta());
					}
					break;
				case 4:
					teclado.nextLine();
					List<Planta> listaPlantas=serviciosPlanta.verPlantas();
					for (Planta planta : listaPlantas) {
						System.out.println(planta.datosVersionCorta());
					}
					System.out.print("Introduce el id de la planta para visualizar sus mensajes: ");
					Long idPlanta=teclado.nextLong();
					List<Mensaje> listaMsj=serviciosMensaje.filtrarMensajesPlanta(idPlanta);
					for (Mensaje msjs : listaMsj) {
						System.out.println(msjs.datosVersionCorta());
					}
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
		System.out.println("Sesión Finalizada");
		sesion.setPerfil(Perfil.INVITADO);
		sesion.setUsuario(null);
	}
	
	
}//class
