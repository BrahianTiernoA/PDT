package servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.CasillaDAO;
import dao.UsuarioDao;
import entities.Casilla;



/**
 * Session Bean implementation class CasillaBean
 */
@Stateless
public class CasillaBean implements CasillaBeanRemote {

	
	@EJB
	private  CasillaDAO casillaDao ;
	
    /**
     * Default constructor. 
     */
    public CasillaBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean insertCasilla(Casilla casilla) {
		
		
		try {
			
				casillaDao.insertCasilla(casilla);
				return true;
				
			
		}catch (Exception ex) {
			
			
			System.out.println(ex.getMessage());
    		return false;
		}
		
		
	
		
	}

	@Override
	public boolean modificarCasilla(Casilla casilla) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaCasilla(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Casilla> findAllCasillas() {
		
		List<Casilla>resultado = casillaDao.findAllCasilla();
		
		return null;
	}

}
