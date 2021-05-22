package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
public class Usuario implements Serializable {

	@Id
	@SequenceGenerator(name="SEQ_USU" , initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USU")
	@Column(name="ID_USUARIO", unique=true, nullable=false, precision=38)
	private long idUsuario;
	
	@Column(nullable=false, length=30)
	private String apellido;
	
	@Column(nullable=false, length=30, unique=true)
	private String nombreUsuario;

	@Column(length=50)
	private String clave;

	@Column( length=20)
	private String documento;

	@Column(length=50)
	private String mail;

	@Column(nullable=false, length=30)
	private String nombre;
	
	@Column(length=50)
	private String instituto;
	
	@Column(length=50)
	private String profesion;
   
	//bi-directional many-to-one association to Roles
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private Rol roles;
	

	private static final long serialVersionUID = 1L;	
	
	//Usuarios Administrador
	public Usuario(String nombre, String apellido, String email, String nombreUsuario, String clave, String documento, String instituto, Rol rol) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = email;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.documento = documento;
		this.instituto = instituto;
		this.roles = rol;
	
		
	} 
	
	// constructor Vacio
	public Usuario() {
		super();
		
		
	} 
	//comun
	public Usuario(String nombre, String apellido, String email, String nombreUsuario, String clave, Rol rol) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = email;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.roles = rol;
		
	} 
	
	//
	
	
	
	
	
	
	public long getIdUsuario() {
		return idUsuario;
	}


	@Override
	public String toString() {
		return "Usuario [roles=" + roles + "]";
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Rol getRoles() {
		return roles;
	}
	public void setRoles(Rol roles) {
		this.roles = roles;
	}
		

	public String getNombreUsuario() {
		return nombreUsuario;
	}



	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}



	public String getInstituto() {
		return instituto;
	}



	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}



	public String getProfesion() {
		return profesion;
	}



	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	
	
	
   
}
