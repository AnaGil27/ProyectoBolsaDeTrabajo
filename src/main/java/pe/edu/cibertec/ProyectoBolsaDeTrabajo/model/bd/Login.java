package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name ="Login", uniqueConstraints = @UniqueConstraint(columnNames = "id_alu"))
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_login;
	@Column(name = "id_alu")
	private String id_alu;
	@Column(name = "ingreso_Contrasenia")
	private String ingreso_Contrasenia;
}
