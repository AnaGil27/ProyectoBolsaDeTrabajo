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
@Table(name ="habilidades")
public class Habilidades {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_habilidad;
	@Column(name = "habilidad")
	private String habilidad;
}
