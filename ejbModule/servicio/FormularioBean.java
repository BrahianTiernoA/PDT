package servicio;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.FormularioDAO;

import entities.Formulario;


/**
 * Session Bean implementation class FormularioBean
 */
@Stateless
public class FormularioBean implements FormularioBeanRemote {

	
	@EJB
	private   FormularioDAO formularioDAO ;
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public FormularioBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean insertForBasico(Formulario form) {
		
		
		try {
    		formularioDAO.insertFormulario(form);
    		return true;
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    		return false;
    		
    	}
		
		
		
		
	}

	

	@Override
	public boolean modificarFormulario(Formulario form) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaFormulario(long id) {
		boolean borre;
		try {
			borre = true;
			Formulario f = em.find(Formulario.class, id);
			formularioDAO.bajaFormulario(f);
			
		} catch(Exception e) {
			borre = false;
		}
		return borre;
	}

	

	@Override
	public List<Formulario> findAllFormulario() {
		List<Formulario> resultado = formularioDAO.findAllFormularios();
		return resultado;
	}

	@Override
	public List<Formulario> findForMetdoMues(String filtro) {
		
       List<Formulario> resultado = formularioDAO.findForPorMetMue(filtro);
		
		return resultado;
		
		
		
		
	}

	@Override
	public List<Formulario> findForFecha(Date filtro) {
   List<Formulario> resultado = formularioDAO.findForPorFecha(filtro);
		
		return resultado;
	}

}
