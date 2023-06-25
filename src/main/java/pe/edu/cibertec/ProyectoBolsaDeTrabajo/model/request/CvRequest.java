package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request;

import lombok.Data;

@Data
public class CvRequest {
	private Integer idCV;
	private String resumen;
	private String cargo;
	private String empresa;
	private String descripcion_exp;
	private String educacion;
	private String proyectos;
	private Integer id_habilidad;
	private Integer id_temas;
	private Integer id_idioma;
	private Integer id_nivel;
	
}