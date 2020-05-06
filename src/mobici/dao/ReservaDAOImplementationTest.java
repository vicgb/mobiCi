package mobici.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import mobici.model.Estacion;
import mobici.model.Reserva;


class ReservaDAOImplementationTest {

	@Test
	void testCreate() {
		ReservaDAO reservadao= ReservaDAOImplementation.getInstancia();

		Reserva reserva= new Reserva();
		reserva.setUsuario("usuario 8");
		reserva.setAnclaje("anclaje5");
		Calendar vencimiento = Calendar.getInstance();
		vencimiento.add(Calendar.MINUTE, 15);
		reserva.setVencimiento(vencimiento);
		reservadao.create(reserva);
		
        assertEquals(reserva.getUsuario(), reservadao.read("usuario 8").getUsuario());
        
        reservadao.delete(reserva);
	}


	@Test
	void testReadAll() {
		ReservaDAO reservadao= ReservaDAOImplementation.getInstancia();

		Reserva reserva= new Reserva();
		reserva.setUsuario("usuario 8");
		reserva.setAnclaje("anclaje5");
		Calendar vencimiento = Calendar.getInstance();
		vencimiento.add(Calendar.MINUTE, 15);
		reserva.setVencimiento(vencimiento);
		reservadao.create(reserva);

		Reserva reserva2 = new Reserva();
		reserva2.setUsuario("usuario 89");
		reserva2.setAnclaje("anclaje3");
		Calendar vencimiento2 = Calendar.getInstance();
		vencimiento2.add(Calendar.MINUTE, 15);
		reserva2.setVencimiento(vencimiento2);
		reservadao.create(reserva2);
		
		assertEquals(2, reservadao.readAll().size());
		reservadao.delete(reserva);
		reservadao.delete(reserva2);
		assertEquals(0, reservadao.readAll().size());
	}



	@Test
	void testDelete() {
		ReservaDAO reservadao= ReservaDAOImplementation.getInstancia();

		Reserva reserva= new Reserva();
		reserva.setUsuario("usuario 8");
		reserva.setAnclaje("anclaje5");
		Calendar vencimiento = Calendar.getInstance();
		vencimiento.add(Calendar.MINUTE, 15);
		reserva.setVencimiento(vencimiento);
		reservadao.create(reserva);
		
		reservadao.delete(reserva);
		
		Reserva reserva2 = reservadao.read("usuario 8");
		
		assertEquals(null, reserva2);
		

	}

}
