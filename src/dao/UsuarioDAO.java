<<<<<<< HEAD
package mobici.dao;
import mobici.model.*;


import java.util.Collection;
	//Aqui se van a definir todas las cosas que "puede hacer" un usuario

	public interface UsuarioDAO {

		public void create(Usuario usuario);
		public Usuario read(String email);
		public void update(Usuario usuario);
		public void delete(Usuario usuario);
		public Collection<Usuario> readAll();
		public Usuario login(String email, String contrase√±a);
	}


=======
package dao;

import java.util.Collection;

import model.Usuario;

public interface UsuarioDAO {

	public void create(Usuario usuario);
	public Usuario read(String email);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
	public Collection<Usuario> readAll();
	public Usuario login(String email, String contraseÒa);
}
>>>>>>> Persistencia
