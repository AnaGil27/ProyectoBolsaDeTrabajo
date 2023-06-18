package pe.edu.cibertec.ProyectoBolsaDeTrabajo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Idiomas;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository.IdiomasRepository;


@Service
public class IdiomasService {
	
	@Autowired
	private IdiomasRepository idiomaRepository;

	

	public void registrarIdiomas(Idiomas objIdiomas) {
		idiomaRepository.save(objIdiomas);	
	}

	public void eliminarIdiomas(Integer id_idioma) {
		idiomaRepository.deleteById(id_idioma);
	}

	public  List<Idiomas> listarIdioma() {
		return idiomaRepository.findAll();
	}
}


