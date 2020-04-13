<<<<<<< HEAD
package mobici.dao;
=======
package dao;
>>>>>>> Persistencia

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryService {
<<<<<<< HEAD
	private SessionFactory sessionFactory;
	private static SessionFactoryService sfs;
	private SessionFactoryService () {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory get() {
		if (sfs == null) sfs = new SessionFactoryService();
=======

	private SessionFactory sessionFactory;
	private static SessionFactoryService sfs;

	private SessionFactoryService() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory get() {
		if( null == sfs )
			sfs = new SessionFactoryService();
>>>>>>> Persistencia
		return sfs.sessionFactory;
	}
}