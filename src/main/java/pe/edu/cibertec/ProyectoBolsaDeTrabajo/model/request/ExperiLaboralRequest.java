package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request;

import lombok.Data;

@Data
public class ExperiLaboralRequest {
	private Integer id_experi_laboral;
	private String empresa;
	private String cargo;
	private String descripcion_exp;
}
