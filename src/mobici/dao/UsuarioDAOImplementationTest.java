package mobici.dao;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import mobici.model.Admin;
import mobici.model.Usuario;

class UsuarioDAOImplementationTest {

	@Test
	void testCreate() {
		UsuarioDAO usuariodao= UsuarioDAOImplementation.getInstancia();

		Usuario usuario = new Usuario();
		usuario.setEmail("a@email.com");
		usuario.setNombre("nombre");
		usuario.setApellido1("apellido");
		usuario.setApellido2("apellido2");
		usuario.setDni("dni1");
		usuario.setPassword("aaa");
		usuariodao.create(usuario);
		
        assertEquals(usuario, usuariodao.read("a@email.com"));
        
        usuariodao.delete(usuario);
	}

	@Test
	void testLogin() {
		UsuarioDAO usuariodao= UsuarioDAOImplementation.getInstancia();

		Usuario usuario = new Usuario();
		usuario.setEmail("a@email.com");
		usuario.setNombre("nombre");
		usuario.setApellido1("apellido");
		usuario.setApellido2("apellido2");
		usuario.setDni("dni1");
		usuario.setPassword("aaa");
		usuariodao.create(usuario);
		
		Usuario usuario2 = usuariodao.login("a@email.com", "aaa");
		assertEquals(usuario2.getEmail(), "a@email.com");
		
		Usuario usuario3= usuariodao.login("a@email.com", "");
		assertNull(usuario3);
		usuariodao.delete(usuario);
	}

	@Test
	void testReadAll() {
		UsuarioDAO usuariodao= UsuarioDAOImplementation.getInstancia();

		Usuario usuario = new Usuario();
		usuario.setEmail("a@email.com");
		usuario.setNombre("nombre");
		usuario.setApellido1("apellido");
		usuario.setApellido2("apellido2");
		usuario.setDni("dni1");
		usuario.setPassword("aaa");
		usuariodao.create(usuario);

		Usuario usuario2 = new Usuario();
		usuario2.setEmail("b@email.com");
		usuario2.setNombre("nombre2");
		usuario2.setApellido1("apellidooo");
		usuario2.setApellido2("apellidooo2");
		usuario2.setDni("dni2");
		usuario.setPassword("bbb");
		usuariodao.create(usuario2);

		assertEquals(2, usuariodao.readAll().size());
		usuariodao.delete(usuario);
		usuariodao.delete(usuario2);
		assertEquals(0, usuariodao.readAll().size());
	}


	@Test
	void testUpdate() {
		UsuarioDAO usuariodao= UsuarioDAOImplementation.getInstancia();

		Usuario usuario = new Usuario();
		usuario.setEmail("a@email.com");
		usuario.setNombre("nombre");
		usuario.setApellido1("apellido");
		usuario.setApellido2("apellido2");
		usuario.setDni("dni1");
		usuario.setPassword("aaa");
		usuariodao.create(usuario);

		usuario.setNombre("new_nombre");
		usuariodao.update(usuario);
        
		assertEquals("new_nombre", usuariodao.read("a@email.com").getNombre());
		
		usuariodao.delete(usuario);
	}

	@Test
	void testDelete() {
		UsuarioDAO usuariodao= UsuarioDAOImplementation.getInstancia();

		Usuario usuario = new Usuario();
		usuario.setEmail("a@email.com");
		usuario.setNombre("nombre");
		usuario.setApellido1("apellido");
		usuario.setApellido2("apellido2");
		usuario.setDni("dni1");
		usuario.setPassword("aaa");
		usuariodao.create(usuario);
		
		usuariodao.delete(usuario);
		
		Usuario usuario2 = usuariodao.read("a@email.com");
		
		assertEquals(null, usuario2);
		

	}

}
