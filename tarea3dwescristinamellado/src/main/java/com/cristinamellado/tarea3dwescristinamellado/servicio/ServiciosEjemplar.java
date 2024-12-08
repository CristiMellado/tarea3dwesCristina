package com.cristinamellado.tarea3dwescristinamellado.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Ejemplar;
import com.cristinamellado.tarea3dwescristinamellado.repository.EjemplarRepository;


@Service
public class ServiciosEjemplar {

	@Autowired
	EjemplarRepository ejemplarRepository;

	
	public boolean insertarEjemplar(Ejemplar ejemplar) {
		if (ejemplarRepository.saveAndFlush(ejemplar) != null) {
			return true;
		}
		return false;
	}

	public Long siguienteIdEjemplar() {
		return ejemplarRepository.siguienteIdEjemplar();
	}

    /**
     * Obtiene los ejemplares asociados a el id o los ids de las plantas seleccionadas.
     * Recorremos e inicializamos la listaMensajes, ya que no se carga automaticamente la coleccion relacionada y por ello
     * utilizamos el ejemplar.getListaMensajes().size().
     * @param seleccionIds Lista de id o ids de planta para la obtención de ejemplares
     * @return Lista de Ejemplares
     */
    @Transactional
    public ArrayList<Ejemplar> filtrarEjemplaresPlanta(List<Long> seleccionIds) {
        ArrayList<Ejemplar> ejemplares = ejemplarRepository.filtrarEjemplaresPlanta(seleccionIds);
        for (Ejemplar ejemplar : ejemplares) {
            ejemplar.getListaMensajes().size();
        }
        return ejemplares;
    }
}//class
