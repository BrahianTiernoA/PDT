package servicio;

import java.util.List;

import javax.ejb.Remote;

import entities.Rol;
import entities.Usuario;

@Remote
public interface UsuarioBeanRemote {
	
	 boolean insertUsuarioComun(Usuario usuario);
	 boolean insertUsuarioAdm(Usuario usuario);
	 boolean insertUsuarioExp(Usuario usuario);
	

	
	//CONSULTAR
	boolean modificarUsuarioComun(long id,  String nombre, String apellido , String correo);
	
	boolean modificarUsuarioAdm(long id,  String nombre, String apellido , String correo, String instituto , String documento);
	
	boolean modificarUsuarioExper(long id,  String nombre, String apellido , String correo, String profesion , String documento);
	

	boolean bajaUsuario(long id);

	List<Usuario> findUsuarioNombre(String filtro);

	List<Usuario> findAllUsuario();

	

	void asignarRol(Long idUsuario, Long idRol);
	
	List<Usuario>  login(String usuario, String contra);
	
	List<Usuario> loginReconocimiento(String usuario, String contra);
	
	

}
