package mobici.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mobici.model.Estacion;

class EstacionDAOImplementationTest {

	@Test
	void testCreate() {
		EstacionDAO estaciondao= EstacionDAOImplementation.getInstancia();

		Estacion estacion= new Estacion();
		estacion.setId("111111");
		estacion.setCapacidad(15);
		estacion.setDireccion("avenida 5");
		estacion.setLatitud("12,56");
		estacion.setLongitud("-5,45");
		estaciondao.create(estacion);
		
        assertEquals(estacion, estaciondao.read("111111"));
        
        estaciondao.delete(estacion);
	}


	@Test
	void testReadAll() {
		EstacionDAO estaciondao= EstacionDAOImplementation.getInstancia();

		Estacion estacion= new Estacion();
		estacion.setId("111111");
		estacion.setCapacidad(5);
		estacion.setDireccion("avenida");
		estacion.setLatitud("12.345");
		estacion.setLongitud("67.890");
		estaciondao.create(estacion);

		Estacion estacion2= new Estacion();
		estacion2.setId("22222");
		estacion2.setCapacidad(2);
		estacion2.setDireccion("avenida2");
		estacion2.setLatitud("12.345222");
		estacion2.setLongitud("67.890222");
		estaciondao.create(estacion2);
		
		assertEquals(2, estaciondao.readAll().size());
		estaciondao.delete(estacion);
		estaciondao.delete(estacion2);
		assertEquals(0, estaciondao.readAll().size());
	}


	@Test
	void testUpdate() {
		EstacionDAO estaciondao= EstacionDAOImplementation.getInstancia();

		Estacion estacion= new Estacion();
		estacion.setId("111111");
		estacion.setCapacidad(5);
		estacion.setDireccion("avenida");
		estacion.setLatitud("12.345");
		estacion.setLongitud("67.890");
		estaciondao.create(estacion);
		
		estacion.setCapacidad(500);
		estaciondao.update(estacion);
        
		assertEquals(500, estaciondao.read("111111").getCapacidad());
		
		estaciondao.delete(estacion);
	}

	@Test
	void testDelete() {
		EstacionDAO estaciondao= EstacionDAOImplementation.getInstancia();

		Estacion estacion= new Estacion();
		estacion.setId("111111");
		estacion.setCapacidad(5);
		estacion.setDireccion("avenida");
		estacion.setLatitud("12.345");
		estacion.setLongitud("67.890");
		estaciondao.create(estacion);
		
		
		estaciondao.delete(estacion);
		
		Estacion estacion2= estaciondao.read("111111");
		
		assertEquals(null, estacion2);
		

	}

}
