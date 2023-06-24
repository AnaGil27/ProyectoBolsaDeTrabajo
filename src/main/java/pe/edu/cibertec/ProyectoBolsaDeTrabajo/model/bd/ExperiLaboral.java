package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "experiencia")
public class ExperiLaboral {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_experi_laboral;
	
	@Column(name = "empresa")
	private String empresa;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "descripcion_exp")
	private String descripcion_exp;
	
	
}

