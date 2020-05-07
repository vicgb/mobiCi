package mobici.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import mobici.model.Viaje;

class ViajeDAOImplementationTest {


	@Test
	void testCreate() {
		ViajeDAO viajedao= ViajeDAOImplementation.getInstancia();

		Viaje viaje= new Viaje();
		viaje.setId("idViaje");
		viaje.setFinDate((new Date()).toString());
		viajedao.create(viaje);
		
        assertEquals(viaje, viajedao.read(viaje.getId()));
        
        viajedao.delete(viaje);
	}


	@Test
	void testReadAll() {
		ViajeDAO viajedao= ViajeDAOImplementation.getInstancia();

		Viaje viaje= new Viaje();
		viaje.setId("idViaje");
		viaje.setFinDate((new Date()).toString());
		viajedao.create(viaje);

		Viaje viaje2= new Viaje();
		viaje2.setId("idViaje2");
		viaje2.setFinDate((new Date()).toString());
		viajedao.create(viaje2);
		
		
		assertEquals(2, viajedao.readAll().size());
		viajedao.delete(viaje);
		viajedao.delete(viaje2);
		assertEquals(0, viajedao.readAll().size());
	}



	@Test
	void testDelete() {
		ViajeDAO viajedao= ViajeDAOImplementation.getInstancia();

		Viaje viaje= new Viaje();
		viaje.setId("idViaje");
		viaje.setFinDate((new Date()).toString());
		viajedao.create(viaje);

		
		viajedao.delete(viaje);
		
		Viaje reserva2 = viajedao.read("idViaje");
		
		assertEquals(null, reserva2);
		

	}

}
