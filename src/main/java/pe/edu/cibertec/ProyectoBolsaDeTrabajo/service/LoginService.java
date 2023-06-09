package pe.edu.cibertec.ProyectoBolsaDeTrabajo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository LoginRepository;
}
