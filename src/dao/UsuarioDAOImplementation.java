package mobici.dao;

import mobici.model.Usuario;

public class UsuarioDAOImplementation implements UsuarioDAO{

	private static UsuarioDAOImplementation instance = null;
	private UsuarioDAOImplementation() {}
	public static UsuarioDAOImplementation getInstance() {
		if ( null == instance ) {
			instance = new UsuarioDAOImplementation();
		}
		return instance;
	}
	
	
	@Override
	public Usuario loginUsuario(String email, String contraseña) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario leerUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario borrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	//Aqui van a desarrollarse todas las acciones
}
