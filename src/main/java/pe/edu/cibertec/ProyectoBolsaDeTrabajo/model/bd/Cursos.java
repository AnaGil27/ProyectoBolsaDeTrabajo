package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="tb_cursos")
public class Cursos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_curso;
	@Column(name = "curso")
	private String id_alu;
	@Column(name = "id_alu")
	private String curso;
	@Column(name = "centro_estudios")
	private String centro_estudios;
	@Column(name = "fecha_inicio")
	private Date fecha_inicio;
	@Column(name = "fecha_fin")
	private Date fecha_fin;
}
