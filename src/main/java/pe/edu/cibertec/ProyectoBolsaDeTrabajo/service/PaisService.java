package pe.edu.cibertec.ProyectoBolsaDeTrabajo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Pais;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository.PaisRepository;


@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;
	
	public List<Pais> listarPais() {
		return paisRepository.findAll();
	}
	public void registrarPais(Pais pais) {
		paisRepository.save(pais);
	}
	
	public void eliminarPais(Integer id_pais) {
		paisRepository.deleteById(id_pais);
	}
	

}
