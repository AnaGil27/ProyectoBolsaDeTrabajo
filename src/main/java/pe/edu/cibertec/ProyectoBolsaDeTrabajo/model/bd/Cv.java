package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
@Table(name="Tb_Curriculum")
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCV;

	@Column(name = "resumen")
	private String resumen;
	
	@Column(name = "empresa")
	private String empresa;
	
	@Column(name = "cargo ")
	private String cargo ;
	
	@Column(name = "descripcion_exp")
	private String descripcion_exp;
	
	@Column(name = "educacion")
	private String educacion;
	
	@Column(name = "proyectos")
	private String proyectos;
	
	@ManyToOne
	@JoinColumn(name="id_habilidad")
	private Habilidades habilidades;
		
	@ManyToOne
	@JoinColumn(name="id_temas")
	private tema tema;
	
	@ManyToOne
	@JoinColumn(name="id_idioma")
	private Idiomas idiomas;
	
	@ManyToOne
	@JoinColumn(name="id_nivel")
	private NivelIdiomas NivelIdiomas;
			
	
		
		

	
	
}