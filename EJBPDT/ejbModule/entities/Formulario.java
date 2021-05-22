package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Formulario
 *
 */
@Entity
public class Formulario implements Serializable {
	
	@Id
	@SequenceGenerator(name="SEQ_FOR" , initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_FOR")
	@Column(name="ID_FORMULARIO", unique=true, nullable=false, precision=38)
	private long idFormulario;
	
	private String metodomuestreo;
	
	private String equipamiento;
	
	private String nombre_for;
	
	private String resumen;
	
	private String departamento;
	
	private Date   fecha;
	
	private int zona;
	
	private String tipo_muestreo;
	
	private String geopunto;
	
	private String localidad;
		
	@OneToMany
	private List<Usuario> usuario;
	
	
	
	
	
	private static final long serialVersionUID = 1L;
	
	//Constructor Vacio
	public Formulario() {
		super();
	}
	
	
	
	
	//Geters and seters
	public long getIdFormulario() {
		return idFormulario;
	}
	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}
	public String getMetodo_muestreo() {
		return metodomuestreo;
	}
	public void setMetodo_muestreo(String metodo_muestreo) {
		this.metodomuestreo = metodo_muestreo;
	}
	public String getEquipamiento() {
		return equipamiento;
	}
	public void setEquipamiento(String equipamiento) {
		this.equipamiento = equipamiento;
	}
	public String getNombre_for() {
		return nombre_for;
	}
	public void setNombre_for(String nombre_for) {
		this.nombre_for = nombre_for;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getZona() {
		return zona;
	}
	public void setZona(int zona) {
		this.zona = zona;
	}
	public String getTipo_muestreo() {
		return tipo_muestreo;
	}
	public void setTipo_muestreo(String tipo_muestreo) {
		this.tipo_muestreo = tipo_muestreo;
	}
	public String getGeopunto() {
		return geopunto;
	}
	public void setGeopunto(String geopunto) {
		this.geopunto = geopunto;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public List<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	} 
	
	
	
	
	
   
}
