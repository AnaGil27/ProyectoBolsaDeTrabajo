package pe.edu.cibertec.ProyectoBolsaDeTrabajo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.ExperiLaboral;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository.ExperiLaboralRepository;;

@Service
public class ExperiLaboralService {

	@Autowired
	private ExperiLaboralRepository ExperiLaboralRepository;

	public void registrarExp(ExperiLaboral objExp) {
		ExperiLaboralRepository.save(objExp);
		
	}

	public void eliminarExp(Integer id_experi_laboral) {
		ExperiLaboralRepository.deleteById(id_experi_laboral);
		
	}

	public List<ExperiLaboral> listarExps() {
		return ExperiLaboralRepository.findAll();
	}



}
