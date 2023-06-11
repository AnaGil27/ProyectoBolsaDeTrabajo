package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request;

import lombok.Data;

@Data
public class UsuarioRequest {
	private String idUsu;
	private String password;
	private String nomUsu;
	private String apeUsu;
	private String FechaNac;
	private String sexo;
	private String direccionUsu;
	private String ciudadUsu;
	private String TelefonoUusu;
	private String EmailUsu;
	private String pais;
	
}
