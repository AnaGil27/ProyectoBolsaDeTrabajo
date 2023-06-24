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
	
	
	@ManyToOne
	@JoinColumn(name="id_experi_laboral")
	private ExperiLaboral ExperiLaboral ;
	@Column(name = "educacion")
	private String educacion;
	@ManyToOne
	@JoinColumn(name="id_habilidad")
	private Habilidades Habilidades;
		
	@ManyToOne
	@JoinColumn(name="id_temas")
	private tema Tema;
	
	@ManyToOne
	@JoinColumn(name="id_idioma")
	private Idiomas Idiomas;
			
	@Column(name = "proyectos")
	private String proyectos;
		
		

	
	
}
