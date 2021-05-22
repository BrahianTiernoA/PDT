package servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import dao.FuncionalidadDAO;
import entities.Funcionalidad;


/**
 * Session Bean implementation class FuncionalidadBean
 */
@Stateless
public class FuncionalidadBean implements FuncionalidadBeanRemote {

    @EJB
    private FuncionalidadDAO funDAO;
	
	@PersistenceContext
	private EntityManager em;
	
    public FuncionalidadBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insertFuncionalidad(Funcionalidad fun) {
		boolean pudeCrear;
		
     	try {
     		funDAO.insertFuncionalidad(fun);
     		pudeCrear = true;
     	} catch (Exception e) {
     		
     		pudeCrear = false;
     	}
     	
	}

	@Override
	public List<Funcionalidad> findNameFunc(String filtro) {
		
		List<Funcionalidad> obtenido = funDAO.findAllNameRoles(filtro);
		
		return obtenido;
	}

	

	@Override
	public List<Funcionalidad> findAllFuncionalidades() {
		
		List<Funcionalidad> obtenido = funDAO.findAllRoles();
		
		return obtenido;
		
	}

	@Override
	public boolean modificarFuncionalidad(Funcionalidad fun) {
		
		boolean pudeModificar;
		try {
			
			funDAO.modificarRol(fun);
			
			 pudeModificar=true;
			
     	
		} catch (Exception e) {
			 pudeModificar=false;
     	}
     	return  pudeModificar;
	}

	@Override
	public boolean bajaFuncionalidad(long id) {
		boolean pudeEliminar;
    	try {
    		Funcionalidad fun = em.find(Funcionalidad.class, id);
    		funDAO.eliminarRol(fun);
    		System.out.println("Funcionalidad eliminada correctamente");
    		pudeEliminar = true;
    	} catch (Exception e) {
    		System.out.println("No se elimino la funcionalidad.");
    		pudeEliminar = false;
    	}
    	return pudeEliminar;
	}

}
