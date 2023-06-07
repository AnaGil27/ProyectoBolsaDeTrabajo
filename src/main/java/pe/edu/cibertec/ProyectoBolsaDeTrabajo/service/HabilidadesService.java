package pe.edu.cibertec.ProyectoBolsaDeTrabajo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Habilidades;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository.HabilidadesRepository;
@Service
public class HabilidadesService {
	@Autowired
	private HabilidadesRepository habilidadesRepository;
	
	public List<Habilidades> listarHabilidades(){
		return habilidadesRepository.findAll();
	}
	
	public void registrarHabilidades(Habilidades habilidades) {
		habilidadesRepository.save(habilidades);
	}
	
	public void eliminarHabilidades(Integer id_habilidades) {
		habilidadesRepository.deleteById(id_habilidades);
	}
}