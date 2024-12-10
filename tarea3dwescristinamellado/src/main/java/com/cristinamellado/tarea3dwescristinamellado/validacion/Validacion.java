package com.cristinamellado.tarea3dwescristinamellado.validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Mensaje;


public class Validacion {

	/**
	 * Valida que el nombre del usuario no sea nulo, no este vacio y no contenga
	 * espacios.
	 * 
	 * @param nombre
	 * @return boolean indicando si es válido o no
	 */
	public static boolean validarUsuario(String usuario) {
		String userRegex = "^[a-zA-Z0-9]+$";
		Pattern pattern = Pattern.compile(userRegex);
		Matcher matcher = pattern.matcher(usuario);
		if (usuario == null || usuario.isEmpty() || usuario.contains(" ") || !matcher.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * Valida que la contraseña cumpla con la expresión regular tenga al menos 5
	 * caracteres alfanuméricos no sea nula, no este vacía y no contenga espacios
	 * 
	 * @param password
	 * @return boolean indicando si es válido o no
	 */
	public static boolean validarContrasena(String password) {
		String passwordRegex = "^[a-zA-Z0-9]+$";
		Pattern pattern = Pattern.compile(passwordRegex);
		Matcher matcher = pattern.matcher(password);

		if (password == null || password.isEmpty() || password.length() < 5 || password.contains(" ")
				|| !matcher.matches()) {
			return false;
		}

		return true;
	}

	/**
	 * Valida que el email cumpla con la expresión regular que no sea nulo, no este
	 * vacío y no contenga espacios
	 * 
	 * @param email
	 * @return boolean indicando si es válido o no
	 */
	public static boolean validarEmail(String email) {
		String emailRegex = "^[a-z0-9_.]+@+[a-z]+\\.[a-z]{2,3}$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);

		if (email == null || email.isEmpty() || !matcher.matches() || email.contains(" ")) {
			return false;
		}

		return true;
	}

	/**
	 * Valida que el código de la planta cumpla con la expresión regular que no sea
	 * nulo, no este vacío y no contenga espacios
	 * 
	 * @param código
	 * @return boolean indicando si es válido o no
	 */
	public static boolean validarCodigoPlanta(String codigo) {
		String codigoRegex = "^[a-zA-Z]+$";
		Pattern pattern = Pattern.compile(codigoRegex);
		Matcher matcher = pattern.matcher(codigo);
		if (codigo == null || codigo.isEmpty() || codigo.contains(" ") || !matcher.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * Valida que el nombre del ejemplar no sea nulo, no este vacio y no contenga
	 * espacios.
	 * 
	 * @param nombreEjemplar
	 * @return boolean indicando si es válido o no
	 */
	public static boolean validarNombreEjemplar(String nombreEjemplar) {
		if (nombreEjemplar == null || nombreEjemplar.isEmpty() || nombreEjemplar.contains(" ")) {
			return false;
		}
		return true;
	}

	/**
	 * Valida que el mensaje no sea nulo.
	 * 
	 * @param mensaje
	 * @return boolean indicando si es válido o no
	 */
	public static boolean validarMensaje(Mensaje mensaje) {
		if (mensaje == null) {
			return false;
		}
		return true;
	}

	/**
	 * Valida que el nombre de la persona cumpla con la expresión regular que no sea
	 * nulo, no este vacío y no contenga espacios
	 * 
	 * @param nombrePersona
	 * @return boolean indicando si es válido o no
	 */
	public static boolean validarNombrePersona(String nombrePersona) {
		String nombrePersonaRegex = "^[a-zA-Z]+$";
		Pattern pattern = Pattern.compile(nombrePersonaRegex);
		Matcher matcher = pattern.matcher(nombrePersona);
		if (nombrePersona == null || nombrePersona.isEmpty() || nombrePersona.contains(" ") || !matcher.matches()) {
			return false;
		}
		return true;
	}

}
