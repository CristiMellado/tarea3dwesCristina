package com.cristinamellado.tarea3dwescristinamellado.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cristinamellado.tarea3dwescristinamellado.FachadaInvitado;
import com.cristinamellado.tarea3dwescristinamellado.modelo.*;
import com.cristinamellado.tarea3dwescristinamellado.repository.CredencialRepository;
import com.cristinamellado.tarea3dwescristinamellado.validacion.Validacion;



@Service
public class ServiciosCredencial {

	@Autowired
	CredencialRepository credencialRepository;

	
	public void insertarCredencial(Credencial p) {
		credencialRepository.saveAndFlush(p);
	}
	
	public boolean autenticar(String usuario, String password) {
		if (Validacion.validarContrasena(password)) {
			if (usuario.equals("admin") && password.equals("admin")) {
				FachadaInvitado.sesion = new Sesion(Perfil.ADMINISTRADOR);
				return true;
			} else {
				Credencial ret = credencialRepository.autenticar(usuario);
				if (ret!=null) {
					FachadaInvitado.sesion = new Sesion(Perfil.PERSONAL);
					return true;
				}
			}
		}
		return false;
	}

	

	
}//class
