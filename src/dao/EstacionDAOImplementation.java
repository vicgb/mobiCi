package mobici.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;


import mobici.model.Estacion;

public class EstacionDAOImplementation implements EstacionDAO {
	
	private static  EstacionDAOImplementation instancia = null;
	
	private EstacionDAOImplementation() {
	}

	public static EstacionDAOImplementation getInstancia() {
		if( null == instancia ) 
			instancia = new EstacionDAOImplementation();
		return instancia;
	}

	
	@Override
	public void create(Estacion estacion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(estacion);
		session.getTransaction().commit();
		session.close();
	}

	
	@Override
	public Estacion read(String id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Estacion e =session.get(Estacion.class, id);
		session.getTransaction().commit();
		session.close();
		return e;
	}

	
	@Override
	public void update(Estacion estacion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(estacion);
		session.getTransaction().commit();
		session.close();
	}

	
	@Override
	public void delete(Estacion estacion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(estacion);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Estacion> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Estacion> ests = session.createQuery("from Estacion").list();
		session.getTransaction().commit();
		session.close();
		return ests;
	}

}