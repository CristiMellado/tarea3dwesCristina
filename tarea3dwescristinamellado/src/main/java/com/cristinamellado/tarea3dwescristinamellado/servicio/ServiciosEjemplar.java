package com.cristinamellado.tarea3dwescristinamellado.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristinamellado.tarea3dwescristinamellado.modelo.Ejemplar;
import com.cristinamellado.tarea3dwescristinamellado.modelo.Mensaje;
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
    public List<Ejemplar> filtrarEjemplaresPlanta(List<Long> seleccionIds) {
        List<Ejemplar> ejemplares = ejemplarRepository.filtrarEjemplaresPlanta(seleccionIds);
        for (Ejemplar ejemplar : ejemplares) {
            ejemplar.getListaMensajes().size();
        }
        return ejemplares;
    }
    
    public List<Ejemplar> listaEjemplares(){
    	return ejemplarRepository.findAll();
    }
    
    public List<Mensaje> seguimientoMensajes(Long idEjemplar){
    	return ejemplarRepository.seguimientoMensajes(idEjemplar);
    }

	public Optional<Ejemplar> findById(Long id) {
		return ejemplarRepository.findById(id);
	}
}//class
