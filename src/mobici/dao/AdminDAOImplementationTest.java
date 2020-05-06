package mobici.dao;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import mobici.model.Admin;

class AdminDAOImplementationTest {

	@Test
	void testCreate() {
		AdminDAO admindao = AdminDAOImplementation.getInstancia();

		Admin admin = new Admin();
		admin.setDni("12356fw");
		admin.setEmail("admin@admin.com");
		admin.setNombre("nombre-admin");
		admin.setPassword("pwd");
		admindao.create(admin);
		
        assertEquals(admin, admindao.read("admin@admin.com"));
        
        admindao.delete(admin);
	}

	@Test
	void testLogin() {
		
		AdminDAO admindao = AdminDAOImplementation.getInstancia();
		Admin admin = new Admin();
		admin.setDni("12356fw");
		admin.setEmail("admin@admin.com");
		admin.setNombre("nombre-admin");
		admin.setPassword("pwd");
		admindao.create(admin);
		
		Admin admin2 = admindao.login("admin@admin.com", "pwd");
		assertEquals(admin2.getEmail(), "admin@admin.com");
		
		Admin admin3 = admindao.login("admin@admin.com", "");
		assertNull(admin3);
		admindao.delete(admin);
	}

	@Test
	void testReadAll() {
		AdminDAO admindao = AdminDAOImplementation.getInstancia();
		assertEquals(0, admindao.readAll().size());

		Admin admin = new Admin();
		admin.setDni("zzz");
		admin.setEmail("admin@admin.com");
		admin.setNombre("nombre-admin");
		admin.setPassword("pwd");
		admindao.create(admin);

		Admin admin2 = new Admin();
		admin2.setDni("bbb");
		admin2.setEmail("admin2@admin2.com");
		admin2.setNombre("nombre-admin2");
		admin2.setPassword("pwd2");
		admindao.create(admin2);

		assertEquals(2, admindao.readAll().size());
		admindao.delete(admin);
		admindao.delete(admin2);
		assertEquals(0, admindao.readAll().size());
	}


	@Test
	void testUpdate() {
		AdminDAO admindao = AdminDAOImplementation.getInstancia();

		Admin admin = new Admin();
		admin.setDni("12356fw");
		admin.setEmail("admin@admin.com");
		admin.setNombre("nombre-admin");
		admin.setPassword("pwd");
		admindao.create(admin);

		admin.setNombre("new_nombre-admin");
		admindao.update(admin);
        
		assertEquals("new_nombre-admin", admindao.read("admin@admin.com").getNombre());
		
        admindao.delete(admin);
	}

	@Test
	void testDelete() {
		AdminDAO admindao = AdminDAOImplementation.getInstancia();

		Admin admin = new Admin();
		admin.setDni("12356fw");
		admin.setEmail("admin@admin.com");
		admin.setNombre("nombre-admin");
		admin.setPassword("pwd");
		admindao.create(admin);
		
		admindao.delete(admin);
		
		Admin admin2 = admindao.read("admin@admin.com");
		
		assertEquals(null, admin2);
		

	}

}
