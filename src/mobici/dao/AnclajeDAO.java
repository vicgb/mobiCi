package mobici.dao;

import java.util.Collection;

import mobici.model.Anclaje;

public interface AnclajeDAO {
	
	public void create(Anclaje anclaje);
	public Anclaje read(String id);
	public void update(Anclaje anclaje);
	public void delete(Anclaje anclaje);
	public Collection<Anclaje> readAll();

}

