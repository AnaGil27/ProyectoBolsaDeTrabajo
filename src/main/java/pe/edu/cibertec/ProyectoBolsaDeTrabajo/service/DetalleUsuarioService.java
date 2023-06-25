package pe.edu.cibertec.ProyectoBolsaDeTrabajo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Rol;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Usuario;

@Service
public class DetalleUsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.buscarNombre(nombre);
		return usuarioPorAutenticacion(usuario, obtenerAutorizacionUsuario(usuario.getRoles()));
	}

	private List<GrantedAuthority> obtenerAutorizacionUsuario(Set<Rol> listRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Rol rol : listRoles) {
			roles.add(new SimpleGrantedAuthority(rol.getNomrol()));
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;

	}

	private UserDetails usuarioPorAutenticacion(Usuario usuario, List<GrantedAuthority> authorityList) {
		return new User(usuario.getNomusu(), usuario.getPassword(), usuario.getActivo(), true, true, true,
				authorityList);
	}

}
