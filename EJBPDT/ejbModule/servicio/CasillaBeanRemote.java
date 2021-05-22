package servicio;

import java.util.List;

import javax.ejb.Remote;

import entities.Casilla;

@Remote
public interface CasillaBeanRemote {

	boolean insertCasilla(Casilla casilla);
	
	boolean modificarCasilla(Casilla casilla);
	
	boolean bajaCasilla(Long id);
	
	  List<Casilla> findAllCasillas();
	
}
