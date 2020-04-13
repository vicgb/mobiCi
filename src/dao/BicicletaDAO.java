<<<<<<< HEAD
package mobici.dao;


import java.util.Collection;

import mobici.model.Bicicleta;
=======
package dao;

import java.util.Collection;

import model.Bicicleta;
>>>>>>> Persistencia

public interface BicicletaDAO {
	
	public void create(Bicicleta bicicleta);
	public Bicicleta read(String id);
	public void update(Bicicleta bicicleta);
	public void delete(Bicicleta bicicleta);
	public Collection<Bicicleta> readAll();
<<<<<<< HEAD
}
=======
}
>>>>>>> Persistencia
