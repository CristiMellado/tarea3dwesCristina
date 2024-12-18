package com.cristinamellado.tarea3dwescristinamellado.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cristinamellado.tarea3dwescristinamellado.FachadaInvitado;
import com.cristinamellado.tarea3dwescristinamellado.modelo.*;
import com.cristinamellado.tarea3dwescristinamellado.repository.CredencialRepository;


@Service
public class ServiciosCredencial {

	@Autowired
	CredencialRepository credencialRepository;

	
	public boolean existeCredencial(String usuario) {
		if( credencialRepository.findByUsuario(usuario)!=null) {
			return true;
		}
		return false;
	}
	
	public boolean autenticar(String usuario, String password) {
		if (usuario.equals("admin") && password.equals("admin")) {
			FachadaInvitado.sesion = new Sesion(Perfil.ADMINISTRADOR);
			return true;
		} else {
			Credencial ret = credencialRepository.autenticar(usuario, password);
			if (ret!=null) {
				FachadaInvitado.sesion = new Sesion(Perfil.PERSONAL);
				return true;
			}
		}
		return false;
	}

	

	
}
