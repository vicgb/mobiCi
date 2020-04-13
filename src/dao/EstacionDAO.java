<<<<<<< HEAD
package mobici.dao;

import java.util.Collection;

import mobici.model.Estacion;
=======
package dao;

import java.util.Collection;

import model.Estacion;
>>>>>>> Persistencia

public interface EstacionDAO {
	
	public void create(Estacion estacion);
	public Estacion read(String id);
	public void update(Estacion estacion);
	public void delete(Estacion estacion);
	public Collection<Estacion> readAll();


<<<<<<< HEAD
}
=======
}
>>>>>>> Persistencia
