package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request;

import java.sql.Date;

import lombok.Data;

@Data
public class CursosRequest {
	private Integer id_curso;
	private String id_alu;
	private String curso;
	private String centro_estudios;
	private Date fecha_inicio;
	private Date fecha_fin;
}
