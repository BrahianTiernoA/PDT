package dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Formulario;
import entities.Usuario;

/**
 * Session Bean implementation class FormularioDAO
 */
@Stateless
@LocalBean
public class FormularioDAO {

    /**
     * Default constructor. 
     */
    public FormularioDAO() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext
 	private EntityManager em;
 	
 	//Insertar 	Formulario
     public void insertFormulario(Formulario formulario) throws SQLException {
 		
     	this.em.persist(formulario);
 		this.em.flush();
   	}
    
     public List<Formulario> findAllFormularios() {
	      try {
	    	  
	    	  TypedQuery<Formulario> query = em.createQuery("SELECT f FROM Formulario f", Formulario.class);
			  return query.getResultList();  
			  
			  } 
	     catch (NoResultException e) {
					
				   return null;
				}
	}
     
     
  // Eliminar   Formulario
     
     public void bajaFormulario(Formulario formulario) throws SQLException {
			
 		this.em.remove(formulario);
 		this.em.flush();
 	}
    
     public List<Formulario> findForPorMetMue (String filtro) {
	     
		   TypedQuery<Formulario> query = em.createQuery("SELECT f FROM Formulario f WHERE f.metodomuestreo LIKE :metodomuestreo", Formulario.class).setParameter("metodomuestreo", filtro);
		    return query.getResultList();
			
	  		}
     
     //SACA UNA COPIA DEL WORKSPACE POR LAS DUDAS JAJAJA
     
     //FECHA
     
     public List<Formulario> findForPorFecha (Date filtro) {
	     
		   TypedQuery<Formulario> query = em.createQuery("SELECT f FROM Formulario f WHERE f.fecha = :fecha2", Formulario.class).setParameter("fecha2", filtro);
		    return query.getResultList();
			
	  		}

	
    
 
}
