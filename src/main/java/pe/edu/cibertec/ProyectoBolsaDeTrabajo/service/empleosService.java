package pe.edu.cibertec.ProyectoBolsaDeTrabajo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.empleos;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository.empleosRepository;

@Service
public class empleosService {
	@Autowired
	private empleosRepository empleosRepository;

	public List<empleos> listarEmpleo() {
		return empleosRepository.findAll();
	}

	public void registrarEmpleo(empleos objEmpleo) {
		empleosRepository.save(objEmpleo);
		
	}

	public void eliminarEmpleo(Integer id_empleos) {
		empleosRepository.deleteById(id_empleos);
		
	}

}
