package dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import model.Usuario;

public class UsuarioDAOImplementation implements UsuarioDAO {

	private static  UsuarioDAOImplementation instancia = null;
	
	private UsuarioDAOImplementation() {
	}

	public static UsuarioDAOImplementation getInstancia() {
		if( null == instancia ) 
			instancia = new UsuarioDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Usuario usuario) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(usuario);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Usuario u =session.get(Usuario.class, email);
		session.getTransaction().commit();
		session.close();
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Usuario usuario) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(usuario);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Usuario usuario) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(usuario);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Usuario> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Usuario> usus = session.createQuery("from Usuario").list();
		session.getTransaction().commit();
		session.close();
		return usus;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Usuario u = null;
		Query q = session.createQuery("select u from Usuario u where u.email = :email and u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Usuario> usus = q.getResultList();
		if (usus.size() > 0)
			u = (Usuario) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return u;
	}

}
