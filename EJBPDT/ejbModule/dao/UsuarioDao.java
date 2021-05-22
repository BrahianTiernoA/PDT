package dao;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import entities.Usuario;

/**
 * Session Bean implementation class UsuarioDao
 */
@Stateless
@LocalBean
public class UsuarioDao {

   
    public UsuarioDao() {
        // TODO Auto-generated constructor stub
    }

        
    @PersistenceContext
	private EntityManager em;
	
	//Insertar Usuarios
    public void insertUsuario(Usuario usuario) throws SQLException {
		
    	this.em.persist(usuario);
		this.em.flush();
  	}
    
	
	//Baja de Usuario
	  public void bajaUsuario(Usuario usuario) throws SQLException {
					
		this.em.remove(usuario);
		this.em.flush();
	}
	
			
	  public void modificarUsuario (Usuario usuario) {
		  
		    this.em.persist(usuario);
			this.em.flush();
		  
		  
		  /*
		  this.em.merge(usuario);
		  this.em.flush();
		  */
			  
		  
	  }
			
			
			
			
	  //Busca todos los Usuarios
	  public List<Usuario> findAllUsuarios() {
	      try {
	    	  
	    	  TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
			  return query.getResultList();  
			  
			  } 
	     catch (NoResultException e) {
					
				   return null;
				}
			}
		
	  
	  
	  
	  public List<Usuario> findUsPorNombre (String filtro) {
		     
		   TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre LIKE :nombre", Usuario.class).setParameter("nombre", filtro);
		    return query.getResultList();
			
	  		}

	}
			

