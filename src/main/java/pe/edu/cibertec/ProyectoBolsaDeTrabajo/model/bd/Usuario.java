package pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd;

import java.util.Collection;

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
import javax.persistence.ManyToOne;
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
	private String idUsu;
	@Column(name = "password")
	private String password;
	@Column(name = "nomUsu")
	private String nomUsu;
	@Column(name = "apeUsu")
	private String apeUsu;
	@Column(name = "FechaNac")
	private String FechaNac;
	@Column(name = "sexo")
	private String sexo;
	@Column(name = "direccionUsu")
	private String direccionUsu;
	@Column(name = "ciudadUsu")
	private String ciudadUsu;
	@Column(name = "TelefonoUusu")
	private String TelefonoUusu;
	@Column(name = "EmailUsu")
	private String EmailUsu;
	
	@ManyToOne
	@JoinColumn(name ="pais")
	private Pais pais;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "idUsu"), inverseJoinColumns = @JoinColumn(name = "idrol"))
	private Collection<Rol> roles;

}
