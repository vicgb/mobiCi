<<<<<<< HEAD
package mobici.model;
=======
package model;
>>>>>>> Persistencia

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

//Clase Bicicleta
@Entity
public class Bicicleta implements Serializable {

	private static final long serialVersionUID = 1L;

	//Cada bici se identifica por su id
	@Id
	private String id;

	//Resto de atributos
	private EstadoBici estado;

	//Constructor
	public Bicicleta() {
		super();
	}

	//Seters y Geters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EstadoBici getEstado() {
		return estado;
	}

	public void setEstado(EstadoBici estado) {
		this.estado = estado;
	}

	//HashCode y Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Bicicleta other = (Bicicleta) obj;
		if (estado != other.estado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	//ToString
	@Override
	public String toString() {
		return "Bici [id=" + id + ", estado=" + estado + "]";
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> Persistencia
