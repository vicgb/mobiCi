package mobici.dao;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import mobici.model.Anclaje;
import mobici.model.EstadoAnclaje;
import mobici.model.EstadoUsuario;
import mobici.model.Reserva;
import mobici.model.Usuario;

public class ReservaDAOImplementation implements ReservaDAO {
	
	private static ReservaDAOImplementation instancia = null;
	
	private ReservaDAOImplementation(){
	}
	
	public static ReservaDAOImplementation getInstancia() {
		if (null == instancia)
			instancia = new ReservaDAOImplementation();
		return instancia;
	}

	@Override
	public void create(Reserva reserva) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(reserva);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public Reserva read(String idUsuario) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Reserva r = session.get(Reserva.class, idUsuario);
		session.getTransaction().commit();
		session.close();
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Reserva> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Reserva> resvs = session.createQuery("from Reserva").list();
		session.getTransaction().commit();
		session.close();
		return resvs;
	}

	@Override
	public void update(Reserva reserva) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(reserva);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Reserva reserva) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(reserva);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void compruebaReservas() {
		Calendar actual = Calendar.getInstance();
		Collection<Reserva> reservas = ReservaDAOImplementation.getInstancia().readAll();
		for (Reserva reserva : reservas) {
			Calendar vencimiento = reserva.getVencimiento();
			if (vencimiento.before(actual)) {
				Usuario usuario = UsuarioDAOImplementation.getInstancia().read(reserva.getUsuario());
				Anclaje anclaje = AnclajeDAOImplementation.getInstancia().read(reserva.getAnclaje());
				usuario.setEstadoUsuario(EstadoUsuario.NADA);
				anclaje.setEstado(EstadoAnclaje.OCUPADO);
				UsuarioDAOImplementation.getInstancia().update(usuario);
				AnclajeDAOImplementation.getInstancia().update(anclaje);
				System.out.println("Se ha borrado la reserva con ID usuario " + reserva.getUsuario());
				instancia.delete(reserva);
			}
		}
	}

}
