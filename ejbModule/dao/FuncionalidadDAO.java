package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Funcionalidad;
import entities.Rol;

/**
 * Session Bean implementation class FuncionalidadDAO
 */
@Stateless
@LocalBean
public class FuncionalidadDAO {

    /**
     * Default constructor. 
     */
    public FuncionalidadDAO() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext
 	private EntityManager em;
 	
 	//Ingresar Roles*******************************************
 	  public void insertFuncionalidad(Funcionalidad fun) {
 		this.em.persist(fun);
 		this.em.flush();
 		
 	  }
 	  
 	  public void eliminarRol(Funcionalidad fun) {
 		  
 		 em.remove(fun);
		 em.flush();
 		  
 	  }
 	  
 	  public void modificarRol (Funcionalidad fun) {
		  
		  
		  em.merge(fun);
		  em.flush();
 	 }
 	  
 	  
 	 public List <Funcionalidad> findAllNameRoles(String filtro) {
 		TypedQuery<Funcionalidad> query = em.createQuery("SELECT f FROM Funcionalidad f WHERE f.nombre LIKE :nombre", Funcionalidad.class).setParameter("nombre", filtro);
		return query.getResultList();
  	  }
 	  
 	  
 	  
    
 	  public List <Funcionalidad> findAllRoles() {
 		 try {
 			TypedQuery<Funcionalidad> query = this.em.createQuery("SELECT f FROM Funcionalidad f ORDER BY f.nombre", Funcionalidad.class);
 			return query.getResultList();        
 		} catch (NoResultException e) {
 			return null;
 		}
 	  }
    

    
    
    
    
    
    
    
}
