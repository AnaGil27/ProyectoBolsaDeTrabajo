package pe.edu.cibertec.ProyectoBolsaDeTrabajo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.tema;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository.temaRepository;


@Service
public class temaService {
	@Autowired
	private temaRepository temaRepository;

	public List<tema> listarTema() {
		return temaRepository.findAll();
	}

	public void registrarTema(tema objTema) {
		temaRepository.save(objTema);	
	}

	public void eliminarTema(Integer id_temas) {
		temaRepository.deleteById(id_temas);
	}
}
