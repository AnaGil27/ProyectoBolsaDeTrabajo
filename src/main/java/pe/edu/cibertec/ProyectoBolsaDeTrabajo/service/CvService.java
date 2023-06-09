package pe.edu.cibertec.ProyectoBolsaDeTrabajo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Cv;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository.CvRepository;

@Service
public class CvService {
	@Autowired
	private CvRepository cvRepository;
	
	public List<Cv> listarCv(){
		return cvRepository.findAll();
	}
	
	public void registrarCv(Cv cv){
		cvRepository.save(cv);
	}
	
	public void eliminarCv(Integer idCv) {
		cvRepository.deleteById(idCv);
	}
	
}