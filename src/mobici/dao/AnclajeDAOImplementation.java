package mobici.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import mobici.model.Anclaje;

public class AnclajeDAOImplementation implements AnclajeDAO {

	private static AnclajeDAOImplementation instancia = null;

	private AnclajeDAOImplementation() {
	}

	public static AnclajeDAOImplementation getInstancia() {
		if (null == instancia)
			instancia = new AnclajeDAOImplementation();
		return instancia;
	}

	@Override
	public void create(Anclaje anclaje) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(anclaje);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Anclaje read(String id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Anclaje a = session.get(Anclaje.class, id);
		session.getTransaction().commit();
		session.close();
		return a;
	}

	@Override
	public void update(Anclaje anclaje) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(anclaje);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Anclaje anclaje) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(anclaje);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Anclaje> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Anclaje> ancs = session.createQuery("from Anclaje").list();
		session.getTransaction().commit();
		session.close();
		return ancs;
	}

}