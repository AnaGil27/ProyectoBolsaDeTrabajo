package pe.edu.cibertec.ProyectoBolsaDeTrabajo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Cursos;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository.CursosRepository;

@Service
public class CursosService {
	@Autowired
	private CursosRepository CursosRepository;
	
	public List<Cursos> listarCursos(){
		return CursosRepository.findAll();
	}
	
	public void registrarCursos(Cursos cursos) {
		CursosRepository.save(cursos);
	}
	
	public void eliminarSala(Integer idcurso) {
		CursosRepository.deleteById(idcurso);
	}
}
