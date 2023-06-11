package pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.NivelIdiomas;

@Repository
public interface NivelIdiomasRepository extends JpaRepository<NivelIdiomas, Integer>{
	
}
