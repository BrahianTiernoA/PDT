package servicio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entities.Formulario;


@Remote
public interface FormularioBeanRemote {
	
	
	 boolean insertForBasico(Formulario form);
	
	

	
	//CONSULTAR
	boolean modificarFormulario(Formulario form);
	

	boolean bajaFormulario(long id);

	List<Formulario> findForMetdoMues(String filtro);

	List<Formulario> findAllFormulario();
	
	//FECHA
	
	List<Formulario> findForFecha(Date filtro);
	

	
	

}
