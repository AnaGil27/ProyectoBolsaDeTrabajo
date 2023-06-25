package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request;

import lombok.Data;

@Data
public class empleosRequest {
	private Integer id_empleos;
	private String empleo;
	private String empresa;
	private String descripcion;
	private String ubicacion;
}