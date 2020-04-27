package mobici.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Viaje implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;

	private String idUsuario;
	
	private String idBicileta;

	private String inicioDate;
	
	private String finDate;
	
	private double coste;
	
	@ManyToOne
	private Anclaje anclajeInicio;
	
	@ManyToOne
	private Anclaje anclajeFin;
	
	public Viaje() {		
		super();
	}
	
	public Viaje(Anclaje anclajeInicio, String idUsuario, String idBicicleta) {
		super();

		this.setId(Math.abs(new Random().nextInt()));
		Date date = new Date();
		String str = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		this.setInicioDate(str);
		this.setAnclajeInicio(anclajeInicio);
		this.setIdUsuario(idUsuario);
		this.setIdBicileta(idBicicleta);
	}
	
	public void terminarViaje(Anclaje anclajeFin){
		double PRECIO_BASE = 1; // Euros
		double PRECIO_MINUTO = 0.15;// Euros
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  

		String dateStart = this.getInicioDate();
		Date date = new Date();
		String dateStop =format.format(date);
				
		Date d1 = null;
		Date d2 = null;
		try {
		    d1 = format.parse(dateStart);
		    d2 = format.parse(dateStop);
		} catch (ParseException e) {
		    e.printStackTrace();
		}    

		long diff = d2.getTime() - d1.getTime();
		long diffInMinutes = diff / (60 * 1000);
		double coste = PRECIO_BASE + diffInMinutes*PRECIO_MINUTO;
		
		this.setFinDate(dateStop);
		this.setAnclajeFin(anclajeFin);
		this.setCoste(coste);
	}

	public Anclaje getAnclajeInicio() {
		return anclajeInicio;
	}

	public void setAnclajeInicio(Anclaje anclajeInicio) {
		this.anclajeInicio = anclajeInicio;
	}

	public Anclaje getAnclajeFin() {
		return anclajeFin;
	}

	public void setAnclajeFin(Anclaje anclajeFin) {
		this.anclajeFin = anclajeFin;
	}

	public int getId() {
		return id;
	}

	public String getIdBicileta() {
		return idBicileta;
	}

	public void setIdBicileta(String idBicileta) {
		this.idBicileta = idBicileta;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getInicioDate() {
		return inicioDate;
	}

	public void setInicioDate(String inicioDate) {
		this.inicioDate = inicioDate;
	}

	public String getFinDate() {
		return finDate;
	}

	public void setFinDate(String finDate) {
		this.finDate = finDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anclajeFin == null) ? 0 : anclajeFin.hashCode());
		result = prime * result + ((anclajeInicio == null) ? 0 : anclajeInicio.hashCode());
		long temp;
		temp = Double.doubleToLongBits(coste);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((finDate == null) ? 0 : finDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((idBicileta == null) ? 0 : idBicileta.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((inicioDate == null) ? 0 : inicioDate.hashCode());
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
		Viaje other = (Viaje) obj;
		if (anclajeFin == null) {
			if (other.anclajeFin != null)
				return false;
		} else if (!anclajeFin.equals(other.anclajeFin))
			return false;
		if (anclajeInicio == null) {
			if (other.anclajeInicio != null)
				return false;
		} else if (!anclajeInicio.equals(other.anclajeInicio))
			return false;
		if (Double.doubleToLongBits(coste) != Double.doubleToLongBits(other.coste))
			return false;
		if (finDate == null) {
			if (other.finDate != null)
				return false;
		} else if (!finDate.equals(other.finDate))
			return false;
		if (id != other.id)
			return false;
		if (idBicileta == null) {
			if (other.idBicileta != null)
				return false;
		} else if (!idBicileta.equals(other.idBicileta))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (inicioDate == null) {
			if (other.inicioDate != null)
				return false;
		} else if (!inicioDate.equals(other.inicioDate))
			return false;
		return true;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}



	@Override
	public String toString() {
		return "Viaje [id=" + id + ", inicioDate=" + inicioDate + ", finDate=" + finDate + ", coste=" + coste + "]";
	}
	
	
	

}
