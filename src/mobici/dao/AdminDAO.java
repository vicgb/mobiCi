package mobici.dao;

import java.util.Collection;


import mobici.model.Admin;


public interface AdminDAO {
	
	
	public void create(Admin admin);
	public Admin read(String email);
	public void update(Admin admin);
	public void delete(Admin admin);
	public Collection<Admin> readAll();
	public Admin login(String email, String password);
		
}
