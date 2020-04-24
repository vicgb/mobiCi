package mobici.dao;

import java.util.Collection;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import mobici.model.Admin;

public class AdminDAOImplementation implements AdminDAO {

	private static AdminDAOImplementation instancia = null;

	private AdminDAOImplementation() {
	}

	public static AdminDAOImplementation getInstancia() {
		if (null == instancia)
			instancia = new AdminDAOImplementation();
		return instancia;
	}

	@Override
	public void create(Admin admin) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Admin login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Admin a = null;
		Query q = session.createQuery("select u from Admin u where u.email = :email and u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);

		@SuppressWarnings("unchecked")
		List<Admin> ads = q.getResultList();
		if (ads.size() > 0)
			a = (Admin) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return a;
	}

	@Override
	public Collection<Admin> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Admin> ads = session.createQuery("from Admin").list();
		session.getTransaction().commit();
		session.close();
		return ads;
	}

	@Override
	public Admin read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Admin a = session.get(Admin.class, email);
		session.getTransaction().commit();
		session.close();
		return a;
	}

	@Override
	public void update(Admin admin) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(admin);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Admin admin) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(admin);
		session.getTransaction().commit();
		session.close();
	}

}