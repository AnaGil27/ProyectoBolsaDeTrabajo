package pe.edu.cibertec.ProyectoBolsaDeTrabajo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.ExperiLaboral;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository.ExperiLaboralRepository;

@Service
public class ExperiLaboralService {

	@Autowired
	ExperiLaboralRepository experiLaboralRepository;
	
	public List<ExperiLaboral> listarExperiLaboral(){
		return experiLaboralRepository.findAll();
	}
	public void registrarExperiLaboral( ExperiLaboral ExperiLaboral) {
		experiLaboralRepository.save(ExperiLaboral);
	}
	public void eleiminarExperiLaboral( Integer id_experiLaboral) {
		experiLaboralRepository.deleteById(id_experiLaboral);
	}
}
