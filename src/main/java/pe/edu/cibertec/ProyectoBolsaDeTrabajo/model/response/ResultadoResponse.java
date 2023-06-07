package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.response;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ResultadoResponse {
	private Boolean respuesta;
	private String mensaje;
}
