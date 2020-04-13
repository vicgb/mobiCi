<<<<<<< HEAD
package mobici.dao;
=======
package dao;
>>>>>>> Persistencia

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

<<<<<<< HEAD

import mobici.model.Estacion;
=======
import model.Anclaje;
import model.Estacion;
>>>>>>> Persistencia

public class EstacionDAOImplementation implements EstacionDAO {
	
	private static  EstacionDAOImplementation instancia = null;
	
	private EstacionDAOImplementation() {
	}

	public static EstacionDAOImplementation getInstancia() {
		if( null == instancia ) 
			instancia = new EstacionDAOImplementation();
		return instancia;
	}

<<<<<<< HEAD
	
=======
	@SuppressWarnings("unchecked")
>>>>>>> Persistencia
	@Override
	public void create(Estacion estacion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(estacion);
		session.getTransaction().commit();
		session.close();
	}

<<<<<<< HEAD
	
=======
	@SuppressWarnings("unchecked")
>>>>>>> Persistencia
	@Override
	public Estacion read(String id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Estacion e =session.get(Estacion.class, id);
		session.getTransaction().commit();
		session.close();
		return e;
	}

<<<<<<< HEAD
	
=======
	@SuppressWarnings("unchecked")
>>>>>>> Persistencia
	@Override
	public void update(Estacion estacion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(estacion);
		session.getTransaction().commit();
		session.close();
	}

<<<<<<< HEAD
	
=======
	@SuppressWarnings("unchecked")
>>>>>>> Persistencia
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

<<<<<<< HEAD
}
=======
}
>>>>>>> Persistencia
