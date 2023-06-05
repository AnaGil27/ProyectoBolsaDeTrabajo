package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CursosResponse {
	private Boolean respuesta;
	private String mensaje;
}
