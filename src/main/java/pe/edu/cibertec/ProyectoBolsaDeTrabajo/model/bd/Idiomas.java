package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd;


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
@Table(name = "tb_idiomas")
public class Idiomas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_idioma;
	
	@Column(name = "idioma")
	private String idioma;
	
	@ManyToOne
	@JoinColumn(name ="id_nivel")
	private NivelIdiomas NivelIdiomas;
}
