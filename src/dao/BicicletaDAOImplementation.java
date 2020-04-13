<<<<<<< HEAD
package mobici.dao;
=======
package dao;
>>>>>>> Persistencia

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

<<<<<<< HEAD
import mobici.model.Bicicleta;
=======
import model.Bicicleta;
>>>>>>> Persistencia

public class BicicletaDAOImplementation implements BicicletaDAO {
	
	private static  BicicletaDAOImplementation instancia = null;
	
	private BicicletaDAOImplementation() {
	}

	public static BicicletaDAOImplementation getInstancia() {
		if( null == instancia ) 
			instancia = new BicicletaDAOImplementation();
		return instancia;
	}

<<<<<<< HEAD
	
=======
	@SuppressWarnings("unchecked")
>>>>>>> Persistencia
	@Override
	public void create(Bicicleta bicicleta) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(bicicleta);
		session.getTransaction().commit();
		session.close();
	}

<<<<<<< HEAD
	
=======
	@SuppressWarnings("unchecked")
>>>>>>> Persistencia
	@Override
	public Bicicleta read(String id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Bicicleta b =session.get(Bicicleta.class, id);
		session.getTransaction().commit();
		session.close();
		return b;
	}

<<<<<<< HEAD
	
=======
	@SuppressWarnings("unchecked")
>>>>>>> Persistencia
	@Override
	public void update(Bicicleta bicicleta) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(bicicleta);
		session.getTransaction().commit();
		session.close();
	}

<<<<<<< HEAD

=======
	@SuppressWarnings("unchecked")
>>>>>>> Persistencia
	@Override
	public void delete(Bicicleta bicicleta) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(bicicleta);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Bicicleta> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Bicicleta> bicis = session.createQuery("from Bicicleta").list();
		session.getTransaction().commit();
		session.close();
		return bicis;
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> Persistencia
