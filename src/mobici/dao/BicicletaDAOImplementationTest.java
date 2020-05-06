package mobici.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mobici.model.Bicicleta;
import mobici.model.EstadoBici;

class BicicletaDAOImplementationTest {

	@Test
	void testCreate() {
		BicicletaDAO bicicletadao= BicicletaDAOImplementation.getInstancia();

		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setId("111111");
		bicicleta.setEstado(EstadoBici.ANCLADA);
		bicicletadao.create(bicicleta);
		
        assertEquals(bicicleta, bicicletadao.read("111111"));
        
        bicicletadao.delete(bicicleta);
	}


	@Test
	void testReadAll() {
		BicicletaDAO bicicletadao= BicicletaDAOImplementation.getInstancia();

		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setId("111111");
		bicicleta.setEstado(EstadoBici.ANCLADA);
		bicicletadao.create(bicicleta);
		
		Bicicleta bicicleta2 = new Bicicleta();
		bicicleta2.setId("22222");
		bicicleta2.setEstado(EstadoBici.VIAJANDO);
		bicicletadao.create(bicicleta2);
		
		assertEquals(2, bicicletadao.readAll().size());
		bicicletadao.delete(bicicleta);
		bicicletadao.delete(bicicleta2);
		assertEquals(0, bicicletadao.readAll().size());
	}


	@Test
	void testUpdate() {
		BicicletaDAO bicicletadao= BicicletaDAOImplementation.getInstancia();

		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setId("111111");
		bicicleta.setEstado(EstadoBici.ANCLADA);
		bicicletadao.create(bicicleta);
		

		bicicleta.setEstado(EstadoBici.VIAJANDO);
		bicicletadao.update(bicicleta);
        
		assertEquals(EstadoBici.VIAJANDO, bicicletadao.read("111111").getEstado());
		
		bicicletadao.delete(bicicleta);
	}

	@Test
	void testDelete() {
		BicicletaDAO bicicletadao= BicicletaDAOImplementation.getInstancia();

		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setId("111111");
		bicicleta.setEstado(EstadoBici.ANCLADA);
		bicicletadao.create(bicicleta);
		
		bicicletadao.delete(bicicleta);
		
		Bicicleta bicicleta2= bicicletadao.read("111111");
		
		assertEquals(null, bicicleta2);
		

	}

}
