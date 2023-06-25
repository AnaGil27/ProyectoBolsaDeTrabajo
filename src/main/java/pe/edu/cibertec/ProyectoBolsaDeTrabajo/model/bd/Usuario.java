package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="usuario", uniqueConstraints = @UniqueConstraint(columnNames = "idUsu"))
public class Usuario {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusu;
	@Column(name = "password")
	private String password;
	@Column(name = "nomusu")
	private String nomusu;
	@Column(name = "apeusu")
	private String apeusu;
	@Column(name = "fechanac")
	private Date fechanac;
	@Column(name = "sexo")
	private String sexo;
	@Column(name = "direccionusu")
	private String direccionusu;
	@Column(name = "ciudadusu")
	private String ciudadusu;
	@Column(name = "telefonousu")
	private String telefonousu;
	@Column(name = "email_usu")
	private String email_usu;
	@Column(name = "activo")
	private Boolean activo;
	
	
	@Column(name ="pais")
	private String pais;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "idusu"), inverseJoinColumns = @JoinColumn(name = "idrol"))
	private Set<Rol> roles;

}
