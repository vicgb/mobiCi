package mobici.dao;

import java.util.Collection;

import mobici.model.Reserva;

public interface ReservaDAO {
	
	public void create(Reserva reserva);
	public Reserva read(String idUsuario);
	public Collection<Reserva> readAll();
	public void update(Reserva reserva);
	public void delete(Reserva reserva);
	public void compruebaReservas();

}
