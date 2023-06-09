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
@Table(name = "temas")
public class tema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_temas;
	
	@Column(name = "tema")
	private String tema;
	
}
