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
@Table(name = "empleo")
public class empleos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_empleos;
	
	@Column(name = "empleo")
	private String empleo;
	
	@Column(name = "empresa")
	private String empresa;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "ubicacion")
	private String ubicacion;
}
