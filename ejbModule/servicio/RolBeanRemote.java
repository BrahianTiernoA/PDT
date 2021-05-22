package servicio;

import java.util.List;

import javax.ejb.Remote;

import entities.Rol;
import entities.Usuario;


@Remote
public interface RolBeanRemote {

	void insertRol(Rol rol);
	
	boolean modificarRol(Rol rol);
	
	boolean bajaRol(long id);
	
	List<Rol> findAllRol();
	
	List<Rol>  buscarRolE(Long id);
	
}
