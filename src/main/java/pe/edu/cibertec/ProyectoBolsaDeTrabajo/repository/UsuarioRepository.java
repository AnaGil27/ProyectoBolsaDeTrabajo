package pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	public Usuario findByIdUsu(String idUsu);
	
	public Usuario findByPassword(String password);
}