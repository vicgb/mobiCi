package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Clase Anclaje
@Entity
public class Anclaje implements Serializable {

	private static final long serialVersionUID = 1L;

	//Cada anclaje se identifica por su id
	@Id
	private String id;

	//Resto de atributos
	private String idEstacion;
	private EstadoAnclaje estado;
	
	//Relacion con Bicicleta
	private String bicicleta;
	
	//Relacion con Estacion
	@ManyToOne
	private Estacion estacion;

	//Constructor
	public Anclaje() {
		super();
	}

	//Geters y Seters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdEstacion() {
		return idEstacion;
	}

	public void setIdEstacion(String idEstacion) {
		this.idEstacion = idEstacion;
	}

	public EstadoAnclaje getEstado() {
		return estado;
	}

	public void setEstado(EstadoAnclaje estado) {
		this.estado = estado;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public String getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(String bicicleta) {
		this.bicicleta = bicicleta;
	}
	
	//HashCode y Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bicicleta == null) ? 0 : bicicleta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((estacion == null) ? 0 : estacion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((idEstacion == null) ? 0 : idEstacion.hashCode());
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
		Anclaje other = (Anclaje) obj;
		if (bicicleta == null) {
			if (other.bicicleta != null)
				return false;
		} else if (!bicicleta.equals(other.bicicleta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (estacion == null) {
			if (other.estacion != null)
				return false;
		} else if (!estacion.equals(other.estacion))
			return false;
		if (estado != other.estado)
			return false;
		if (idEstacion == null) {
			if (other.idEstacion != null)
				return false;
		} else if (!idEstacion.equals(other.idEstacion))
			return false;
		return true;
	}

	//ToString
	@Override
	public String toString() {
		return "Anclaje [id=" + id + ", idEstacion=" + idEstacion + ", estado=" + estado + ", estacion="
				+ estacion + ", bicicleta=" + bicicleta + "]";
	}
	
	
}
