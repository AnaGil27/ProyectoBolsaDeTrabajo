package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_experiLaboral")
public class ExperiLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_experiLaboral;
	
	@ManyToOne
	@JoinColumn(name ="idUsu")
	private Usuario usuario;
	
	@Column(name = "empresa")
	private String empresa;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "descripcionExp")
	private String descripcionExp;
	
	@Column(name = "fecha_ingreso")
	private Date fecha_ingreso;
	
	@Column(name = "fecha_egreso")
	private Date fecha_egreso;
}
