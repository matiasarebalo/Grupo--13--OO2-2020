package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Empleado extends Persona{
	private LocalTime horarioEntrada;
	private String tipo;
	private float sueldo;
	private Local suLocal;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (horarioEntrada == null) {
			if (other.horarioEntrada != null)
				return false;
		} else if (!horarioEntrada.equals(other.horarioEntrada))
			return false;
		if (horarioSalida == null) {
			if (other.horarioSalida != null)
				return false;
		} else if (!horarioSalida.equals(other.horarioSalida))
			return false;
		if (suLocal == null) {
			if (other.suLocal != null)
				return false;
		} else if (!suLocal.equals(other.suLocal))
			return false;
		if (Float.floatToIntBits(sueldo) != Float.floatToIntBits(other.sueldo))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	private LocalTime horarioSalida;
	public Empleado(String nombre, int dni, String apellido, LocalDate fechaNacimiento,int idPersona, LocalTime horarioEntrada,
			String tipo, float sueldo, Local suLocal, LocalTime horarioSalida) {
		super(nombre, dni, apellido, fechaNacimiento,idPersona);
		this.horarioEntrada = horarioEntrada;
		this.tipo = tipo;
		this.sueldo = sueldo;
		this.suLocal = suLocal;
		this.horarioSalida = horarioSalida;
	}
	public LocalTime getHorarioEntrada() {
		return horarioEntrada;
	}
	public void setHorarioEntrada(LocalTime horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	public Local getSuLocal() {
		return suLocal;
	}
	public void setSuLocal(Local suLocal) {
		this.suLocal = suLocal;
	}
	public LocalTime getHorarioSalida() {
		return horarioSalida;
	}
	public void setHorarioSalida(LocalTime horarioSalida) {
		this.horarioSalida = horarioSalida;
	}
	@Override
	public String toString() {
		return "Empleado [tipo=" + tipo + ", nombre=" + nombre + ", dni=" + dni
				+ ", idPersona=" + idPersona + "sueldo"+sueldo+suLocal.getDireccion() +"]\n";
	}
	
	
	
}
