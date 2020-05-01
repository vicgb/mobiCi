package mobici.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;

//Clase Reserva
@Entity
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	//Email (ID) del usuario que hace la reserva
	private String usuario;
	
	//ID del anclaje reservado por el usuario
	private String anclaje;
	
	//Momento en que se cancela la reserva de forma automática
	private Calendar vencimiento;
	
	//Constructor
	public Reserva() {
		super();
	}

	//Geters y Seters
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getAnclaje() {
		return anclaje;
	}

	public void setAnclaje(String anclaje) {
		this.anclaje = anclaje;
	}

	public Calendar getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Calendar vencimiento) {
		this.vencimiento = vencimiento;
	}

	//HashCode y Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anclaje == null) ? 0 : anclaje.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((vencimiento == null) ? 0 : vencimiento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (anclaje == null) {
			if (other.anclaje != null)
				return false;
		} else if (!anclaje.equals(other.anclaje))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (vencimiento == null) {
			if (other.vencimiento != null)
				return false;
		} else if (!vencimiento.equals(other.vencimiento))
			return false;
		return true;
	}

	//ToString
	@Override
	public String toString() {
		return "Reserva [usuario=" + usuario + ", anclaje=" + anclaje + ", vencimiento=" + vencimiento + "]";
	}
}
