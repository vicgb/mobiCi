package mobici.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import mobici.model.Usuario;
import mobici.model.Viaje;

public class ViajeDAOImplementation implements ViajeDAO {
	
	private static ViajeDAOImplementation instancia = null;

	private ViajeDAOImplementation() {
	}

	public static ViajeDAOImplementation getInstancia() {
		if (null == instancia)
			instancia = new ViajeDAOImplementation();
		return instancia;
	}

	@Override
	public void create(Viaje viaje) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(viaje);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Viaje read(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Viaje v = session.get(Viaje.class, id);
		session.getTransaction().commit();
		session.close();
		return v;
	}

	@Override
	public void update(Viaje viaje) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(viaje);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Viaje viaje) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(viaje);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Viaje> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Viaje> viajes = session.createQuery("from Viaje").list();
		session.getTransaction().commit();
		session.close();
		return viajes;
	}


}
