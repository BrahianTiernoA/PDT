package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Funcionalidad
 *
 */
@Entity
public class Funcionalidad implements Serializable {

	@Id
	@SequenceGenerator(name="SEQ_FUN" , initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_FUN")
	@Column(name="ID_FUNCIONALIDAD", unique=true, nullable=false, precision=38)
	private long idFuncionalidad;
	
	@Column(length=100)
	private String descripcion;

	@Column(length=50)
	private String nombre;

	//bi-directional many-to-many association to Roles
	@ManyToMany(mappedBy="funcionalidades")
	private List<Rol> roles;

	
	
	
	
	
	private static final long serialVersionUID = 1L;	
	public Funcionalidad() {
		super();
	}
	
	public Funcionalidad(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		
	}
	
	
	public long getIdFuncionalidad() {
		return idFuncionalidad;
	}
	public void setIdFuncionalidad(long idFuncionalidad) {
		this.idFuncionalidad = idFuncionalidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	} 
	
   
	
	
	
	
	
}
