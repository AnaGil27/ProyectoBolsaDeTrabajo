package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request;

import lombok.Data;

@Data
public class CvRequest {
	private Integer idCV;
	private String resumen;
	private String educacion;
	private String proyectos;
	private String tema;
	private String habilidades;	
}