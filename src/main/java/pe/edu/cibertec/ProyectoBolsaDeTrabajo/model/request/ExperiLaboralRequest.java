package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request;

import java.util.Date;
import lombok.Data;
 @Data
public class ExperiLaboralRequest {
	private Integer id_experi_laboral;
	private String idUsu;
	private String empresa;
	private String cargo;
	private String descripcionExp;
	private Date fecha_ingreso;
	private Date fecha_egreso;
}
