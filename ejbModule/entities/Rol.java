package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Rol
 *
 */
@Entity
public class Rol implements Serializable {
	
	@Id
	@SequenceGenerator(name="SEQ_ROL" , initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ROL")
	@Column(name="ID_ROL", unique=true, nullable=false, precision=38)
	private long idRol;

	@Column(length=100)
	private String descripcion;

	@Column(length=50)
	private String nombre;
	
	//bi-directional many-to-many association to Funcionalidades
		@ManyToMany
		@JoinTable(name="ROL_FUNCION", joinColumns={
				@JoinColumn(name="ID_ROL", nullable=false)}
			, inverseJoinColumns={
				@JoinColumn(name="ID_FUNCION", nullable=false)
				}
			)
		private List<Funcionalidad> funcionalidades;
		
		
		
		
	
	private static final long serialVersionUID = 1L;	
	public Rol(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		
	}
	
	public Rol() {
		super();
		
		
	}
	
	
	public long getIdRol() {
		return idRol;
	}
	public void setIdRol(long idRol) {
		this.idRol = idRol;
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
	public List<Funcionalidad> getFuncionalidades() {
		return funcionalidades;
	}
	public void setFuncionalidades(List<Funcionalidad> funcionalidades) {
		this.funcionalidades = funcionalidades;
	} 
	
	
	
	
   
}
