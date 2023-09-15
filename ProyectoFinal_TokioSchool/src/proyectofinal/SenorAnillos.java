package proyectofinal;

import java.util.ArrayList;

public abstract class SenorAnillos {
	private String nombre;
	private int puntosvida;
	private int nivelarmadura;
	

	public SenorAnillos(String nombre, int puntosvida, int nivelarmadura) {
		this.nombre = nombre;
		this.puntosvida = puntosvida;
		this.nivelarmadura = nivelarmadura;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosvida() {
		return puntosvida;
	}

	public void setPuntosvida(int puntosvida) {
		this.puntosvida = puntosvida;
	}

	public int getNivelarmadura() {
		return nivelarmadura;
	}

	public void setNivelarmadura(int nivelarmadura) {
		this.nivelarmadura = nivelarmadura;
	}
	
	@Override
	public String toString() {
		return nombre + " (Vida=" + puntosvida + " Armadura=" + nivelarmadura+")";
	}
	
	

@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nivelarmadura;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + puntosvida;
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
		SenorAnillos other = (SenorAnillos) obj;
		if (nivelarmadura != other.nivelarmadura)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (puntosvida != other.puntosvida)
			return false;
		return true;
	}

public abstract int LanzarAtaque();

}
