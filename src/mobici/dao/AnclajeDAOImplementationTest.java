package mobici.dao;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import mobici.model.Anclaje;
import mobici.model.EstadoAnclaje;

class AnclajeDAOImplementationTest {


	@Test
	void testCreate() {
		AnclajeDAO anclajedao = AnclajeDAOImplementation.getInstancia();

		Anclaje anclaje = new Anclaje();
		
		anclaje.setId("111111");
		anclaje.setBicicleta("bici644");
		anclaje.setEstado(EstadoAnclaje.LIBRE);
		
		anclajedao.create(anclaje);
		
        assertEquals(anclaje, anclajedao.read("111111"));
        
        anclajedao.delete(anclaje);
	}


	@Test
	void testReadAll() {
		AnclajeDAO anclajedao = AnclajeDAOImplementation.getInstancia();

		Anclaje anclaje = new Anclaje();
		anclaje.setId("111111");
		anclaje.setBicicleta("bici644");
		anclaje.setEstado(EstadoAnclaje.OCUPADO);
		anclajedao.create(anclaje);
		
		Anclaje anclaje2 = new Anclaje();
		anclaje2.setId("222222");
		anclaje2.setBicicleta("bici6444");
		anclaje2.setEstado(EstadoAnclaje.RESERVADO);
		anclajedao.create(anclaje2);
		
		assertEquals(2, anclajedao.readAll().size());
		anclajedao.delete(anclaje);
		anclajedao.delete(anclaje2);
		assertEquals(0, anclajedao.readAll().size());
	}


	@Test
	void testUpdate() {
		AnclajeDAO anclajedao = AnclajeDAOImplementation.getInstancia();

		Anclaje anclaje = new Anclaje();
		anclaje.setId("111111");
		anclaje.setBicicleta("bici644");
		anclaje.setEstado(EstadoAnclaje.OCUPADO);
		anclajedao.create(anclaje);

		anclaje.setBicicleta("new_bicicleta");
		anclajedao.update(anclaje);
        
		assertEquals("new_bicicleta", anclajedao.read("111111").getBicicleta());
		
		anclajedao.delete(anclaje);
	}

	@Test
	void testDelete() {
		AnclajeDAO anclajedao = AnclajeDAOImplementation.getInstancia();

		Anclaje anclaje = new Anclaje();
		anclaje.setId("111111");
		anclaje.setBicicleta("bici644");
		anclaje.setEstado(EstadoAnclaje.OCUPADO);
		anclajedao.create(anclaje);
		
		anclajedao.delete(anclaje);
		
		Anclaje anclaje2= anclajedao.read("111111");
		
		assertEquals(null, anclaje2);
		

	}


}
