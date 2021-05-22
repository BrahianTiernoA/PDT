package dao;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Rol;
import entities.Usuario;

/**
 * Session Bean implementation class RolDao
 */
@Stateless
@LocalBean
public class RolDao {

    /**
     * Default constructor. 
     */
    public RolDao() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext
 	private EntityManager em;
 	
 	//Ingresar Roles*******************************************
 	  public void insertRol(Rol rol) {
 		this.em.persist(rol);
 		this.em.flush();
 		
 	  }
 	  
 	  public void eliminarRol(Rol rol) {
 		  
 		 em.remove(rol);
		 em.flush();
 		  
 	  }
 	  
 	  public void modificarRol (Rol rol) {
		  
		  
		  em.merge(rol);
		  em.flush();
 	 }
 	  
 	  
    
 	  public List <Rol> findAllRoles() {
 		 TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r ", Rol.class);
 		return query.getResultList();
 	  }
    
 	   	  
 	  public  List <Rol> buscarRolE(Long id) {
 		 TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r WHERE r.id  =:id", Rol.class).setParameter("id", id);
  		return query.getResultList();
  	  }
}
