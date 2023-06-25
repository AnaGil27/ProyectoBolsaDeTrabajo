package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request;

import lombok.Data;

@Data
public class UsuarioRequest {
	private Integer idusu;
	private String password;
	private String nomusu;
	private String apeusu;
	private String fechanac;
	private String sexo;
	private String direccionusu;
	private String ciudadusu;
	private String pais;
	private String telefonousu;
	private String email_usu;

	
}
