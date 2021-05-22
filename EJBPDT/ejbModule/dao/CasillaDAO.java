package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Casilla;
import entities.Rol;
import entities.Usuario;

/**
 * Session Bean implementation class CasillaDAO
 */
@Stateless
@LocalBean
public class CasillaDAO {

    /**
     * Default constructor. 
     */
    public CasillaDAO() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
 	private EntityManager em;
 	
 	//Ingresar Casillas*******************************************
 	  public void insertCasilla(Casilla casilla) {
 		this.em.persist(casilla);
 		this.em.flush();
 		
 	  }
 	  
 	  public void eliminarCasilla(Casilla casilla) {
 		  
 		 em.remove(casilla);
		 em.flush();
 		  
 	  }
 	  
 	  public void modificarCasilla (Casilla casilla) {
		  
		  
		  em.merge(casilla);
		  em.flush();
 	 }
 	  
 	  
 	 public List<Casilla> findAllCasilla() {
	      try {
	    	  
	    	  TypedQuery<Casilla> query = em.createQuery("SELECT c FROM CASILLAS c", Casilla.class);
			  return query.getResultList();  
			  
			  } 
	     catch (NoResultException e) {
					
				   return null;
				}
			}
 	  
    
    
    

}
