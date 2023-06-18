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
@Table(name="CV")
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCV;
	@Column(name = "resumen")
	private String resumen;
	@Column(name = "educacion")
	private String educacion;
	@Column(name = "proyectos")
	private String proyectos;
	
	@ManyToOne
	@JoinColumn(name="habilidades")
	private Habilidades habilidades;
	
	@ManyToOne
	@JoinColumn(name="empresa")
	private ExperiLaboral empresa;
	
	@ManyToOne
	@JoinColumn(name="cargo")
	private ExperiLaboral cargo;
	
	@ManyToOne
	@JoinColumn(name="descripcion_exp")
	private ExperiLaboral descripcion_exp;
		
	@ManyToOne
	@JoinColumn(name ="idUsu")
	private Usuario usuario;
	
}
