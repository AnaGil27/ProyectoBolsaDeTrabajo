package pe.edu.cibertec.ProyectoBolsaDeTrabajo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.NivelIdiomas;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository.NivelIdiomasRepository;

@Service
public class NivelIdiomaService {
	@Autowired
	private NivelIdiomasRepository nivelIdiomasRepository;
	
	public List<NivelIdiomas> listarNivelIdiomas(){
		return nivelIdiomasRepository.findAll();
	}
	
	public void registrarNivelIidomas( NivelIdiomas nivel) {
		nivelIdiomasRepository.save(nivel);
	}
	public void eliminarNivelIidomas(Integer id_nivel) {
		nivelIdiomasRepository.deleteById(id_nivel);
	}
}
