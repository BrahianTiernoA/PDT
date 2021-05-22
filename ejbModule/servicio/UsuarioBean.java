package servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;




import dao.UsuarioDao;
import entities.Rol;
import entities.Usuario;

/**

 */
@Stateless
public class UsuarioBean implements UsuarioBeanRemote {
	
	@EJB
	private   UsuarioDao usuarioDAO ;

	@PersistenceContext
	private EntityManager em;
    
	 
	 
    public UsuarioBean() {
        
    }

	
    
	@Override
	public boolean insertUsuarioComun(Usuario usuario) {
     
		
    	try {
    		usuarioDAO.insertUsuario(usuario);
    		return true;
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    		return false;
    		
    	}
    	
	}


	@Override
	public boolean insertUsuarioAdm(Usuario usuario) {
		  	
    	
    	try {
    		usuarioDAO.insertUsuario(usuario);
    		return true;
    	} catch (Exception e) {
    		
    		System.out.println(e.getMessage());
    		return false;
    	}
    	
	}

		
	


	@Override
	public boolean insertUsuarioExp(Usuario usuario) {
          	
	 	try {
	 		usuarioDAO.insertUsuario(usuario);
	 		return true;
	    	} catch (Exception e) {
	    		
	    	System.out.println(e.getMessage());
	    	return false;
	    	}
		
	}

    
	
	@Override
	public boolean modificarUsuarioComun(long id, String nombre, String apellido , String correo) {
		boolean modifique;
		
		try {
			Usuario u = em.find(Usuario.class, id);
			u.setNombre(nombre);
			u.setApellido(apellido);
			u.setMail(correo);
			usuarioDAO.modificarUsuario(u);
		} catch (Exception e) {
			 modifique=false;
     	}
		return true;
		
	}

	
	@Override
	public boolean bajaUsuario(long id) {
		boolean borre;
		try {
			borre = true;
			Usuario u = em.find(Usuario.class, id);
			usuarioDAO.bajaUsuario(u);
			
		} catch(Exception e) {
			borre = false;
		}
		return borre;
		
	}


	
	@Override
	public List<Usuario> findAllUsuario() {
		
		List<Usuario> resultado = usuarioDAO.findAllUsuarios();
		return resultado;
		
	}


	@Override
	public List<Usuario> findUsuarioNombre(String filtro) {
		
		List<Usuario> resultado = usuarioDAO.findUsPorNombre(filtro);
		
		return resultado;
		
	}


	@Override
	public List<Usuario> login(String usuario, String contra) {
		
		
				
			
	       TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :usuario AND u.clave = :clave", Usuario.class);
		   query.setParameter("usuario", usuario);
		   query.setParameter("clave", contra);
		   
		    query.getResultList();
		  
		    
		    
		    
		    if(  query.getResultList().isEmpty()) {
		    	
		    	
		    	return  null;
		    	
		    }else {
		    	return  query.getResultList();
		    	
		    }
		 
	}


	@Override
	public void asignarRol(Long idUsuario, Long idRol) {
		try{
			Usuario usu = em.find(Usuario.class, idUsuario);
			usu.setRoles(em.find(Rol.class, idRol));
			em.merge(usu);
			em.flush();
			 }catch(PersistenceException e){
			
			 } 
		
		
	}



	@Override
	public List<Usuario> loginReconocimiento(String usuario, String contra) {
		 
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :usuario AND u.clave = :clave", Usuario.class);
		   query.setParameter("usuario", usuario);
		   query.setParameter("clave", contra);
		   
		   
		    
		    
		    
		return  query.getResultList();
	}



	@Override
	public boolean modificarUsuarioAdm(long id, String nombre, String apellido, String correo, String instituto,
			String documento) {
         boolean modifique;
		
		try {
			Usuario u = em.find(Usuario.class, id);
			u.setNombre(nombre);
			u.setApellido(apellido);
			u.setMail(correo);
			u.setInstituto(instituto);
			u.setDocumento(documento);
			usuarioDAO.modificarUsuario(u);
		} catch (Exception e) {
			 modifique=false;
     	}
		return true;
	}



	@Override
	public boolean modificarUsuarioExper(long id, String nombre, String apellido, String correo, String profesion,
			String documento) {
		  boolean modifique;
			
			try {
				Usuario u = em.find(Usuario.class, id);
				u.setNombre(nombre);
				u.setApellido(apellido);
				u.setMail(correo);
				u.setProfesion(profesion);
				u.setDocumento(documento);
				usuarioDAO.modificarUsuario(u);
			} catch (Exception e) {
				 modifique=false;
	     	}
			return true;
	}



	}
    


    
    





    
    


