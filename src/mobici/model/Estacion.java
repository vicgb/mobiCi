package mobici.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Clase Entity
@Entity
public class Estacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Cada estacion se identifica por su id
	@Id
	private String id;
	
	//Resto de atributos
	private String direccion;
	private String latitud;
	private String longitud;
	private int capacidad;
	
	@OneToMany(mappedBy = "estacion", fetch =
	FetchType.EAGER)
	private Collection<Anclaje> anclajes;
	
	//Constructor
	public Estacion() {
		super();
	}

	//Geters y Seters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Collection<Anclaje> getAnclajes() {
		return anclajes;
	}

	public void setAnclajes(Collection<Anclaje> anclajes) {
		this.anclajes = anclajes;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	//HashCode y Equeals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anclajes == null) ? 0 : anclajes.hashCode());
		result = prime * result + capacidad;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((latitud == null) ? 0 : latitud.hashCode());
		result = prime * result + ((longitud == null) ? 0 : longitud.hashCode());
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
		Estacion other = (Estacion) obj;
		if (anclajes == null) {
			if (other.anclajes != null)
				return false;
		} else if (!anclajes.equals(other.anclajes))
			return false;
		if (capacidad != other.capacidad)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (latitud == null) {
			if (other.latitud != null)
				return false;
		} else if (!latitud.equals(other.latitud))
			return false;
		if (longitud != other.longitud)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estacion [id=" + id + ", latitud=" + latitud + ", longitud=" + longitud + ", capacidad=" + capacidad + "]";
	}

	
}