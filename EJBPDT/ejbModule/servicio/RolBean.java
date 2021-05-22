package servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;

import dao.RolDao;
import entities.Rol;


/**
 * Session Bean implementation class RolBean
 */
@Stateless
public class RolBean implements RolBeanRemote {

    /**
     * Default constructor. 
     */
    public RolBean() {
        // TODO Auto-generated constructor stub
    }

    
    @EJB
	private   RolDao rolDAO ;
    
    @PersistenceContext
 	private EntityManager em;
    
	@Override
	public void insertRol(Rol rol) {
		
		try {
			
			rolDAO.insertRol(rol);
 		
            }
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
 		
	}

	@Override
	public boolean bajaRol(long id) {
		boolean borre;
		try {
			borre = true;
			Rol rol = em.find(Rol.class, id);
			rolDAO.eliminarRol(rol);
		} catch(Exception e) {
			borre = false;
		}
		return borre;
	}

	@Override
	public List<Rol> findAllRol() {
		
		List<Rol> obtenido = rolDAO.findAllRoles();
		
		return obtenido;
	}

	@Override
	public boolean modificarRol(Rol rol) {
		boolean modifique;
		
		try {
			rolDAO.modificarRol(rol);
		} catch (Exception e) {
			 modifique=false;
     	}
		return true;
		
	}

	@Override
	public List<Rol> buscarRolE(Long id) {
    
		List<Rol> obtenido = rolDAO.buscarRolE(id);
		
		return obtenido;
	}

	
     




}

	
	
	

