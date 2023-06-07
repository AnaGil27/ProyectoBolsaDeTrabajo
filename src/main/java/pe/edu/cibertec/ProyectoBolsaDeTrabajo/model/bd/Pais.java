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
@Table(name = "tb_pais")
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pais;
	
	@Column(name = "pais")
	private String pais;
	
	
	
}
