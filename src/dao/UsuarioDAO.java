package mobici.dao;
import mobici.model.*;
public interface UsuarioDAO {
	//Aqui se van a definir todas las cosas que "puede hacer" un usuario

	public Usuario loginUsuario(String email, String contraseña);
	public Usuario leerUsuario(Usuario usuario);
	public Usuario borrarUsuario(Usuario usuario);
	public void crearUsuario(Usuario usuario);
	


}
