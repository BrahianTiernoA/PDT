package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Casilla
 *
 */
@Entity
public class Casilla implements Serializable {
	
	@Id
	@SequenceGenerator(name="SEQ_CAS" , initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CAS")
	@Column(name="ID_CASILLA", unique=true, nullable=false, precision=38)
	private long idCasilla;
	
	@Column(nullable=false, length=30)
	private String parametro;
	
	@Column( length=30)
	private String unidadDeMedida;
	
	@Column( length=100)
	private String descripcion;
	
	@Column( length=100)
	private String tipoDeDato;
	

	
	private static final long serialVersionUID = 1L;	
	public Casilla() {
		super();
	}
	
	
	public long getIdCasilla() {
		return idCasilla;
	}
	public void setIdCasilla(long idCasilla) {
		this.idCasilla = idCasilla;
	}
	public String getParametro() {
		return parametro;
	}
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	public String getUnidadDeMedida() {
		return unidadDeMedida;
	}
	public void setUnidadDeMedida(String unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoDeDato() {
		return tipoDeDato;
	}
	public void setTipoDeDato(String tipoDeDato) {
		this.tipoDeDato = tipoDeDato;
	} 
	
	
	
	
	
   
}
