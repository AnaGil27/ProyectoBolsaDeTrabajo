package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request;

import lombok.Data;

@Data
public class CvRequest {
	private Integer idCV;
	private String idUsu;
	private String resumen;
	private Integer id_experi_laboral;
	private String educacion;
	private Integer id_habilidad;
	private Integer id_temas;
	private Integer id_idioma;
	private String proyectos;
}