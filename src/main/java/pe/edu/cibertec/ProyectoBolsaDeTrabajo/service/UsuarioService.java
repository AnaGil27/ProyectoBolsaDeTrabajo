package pe.edu.cibertec.ProyectoBolsaDeTrabajo.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Rol;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Usuario;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository.UsuarioRepository;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository.RolRepository;


@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	private BCryptPasswordEncoder bCryptPass = new BCryptPasswordEncoder();
	
	public Usuario buscarUsuPorId(String idUsuario) {
		return usuarioRepository.findByIdUsu(idUsuario);
	}
	
	public Usuario guardarUsuario(Usuario usuario) {
		usuario.setPassword(bCryptPass.encode(usuario.getPassword()));
		usuario.setActivo(true);
		
		Rol rol = rolRepository.findByNomrol("ADMIN");
		usuario.setRoles(new HashSet<Rol>(Arrays.asList(rol)));
		
		return usuarioRepository.save(usuario);
	}
}
