package servicio;

import java.util.List;

import javax.ejb.Remote;

import entities.Funcionalidad;

@Remote
public interface FuncionalidadBeanRemote {
	
	void insertFuncionalidad(Funcionalidad funcionalidad);

	List<Funcionalidad> findNameFunc(String filtro); //Buscar funcionalidad por nombre
	
	
	
	List<Funcionalidad> findAllFuncionalidades(); //Buscar todas las funcionalidades

	boolean modificarFuncionalidad(Funcionalidad funcionalidad);
	
	boolean bajaFuncionalidad(long id);//Eliminar funcionalidad
	

}
