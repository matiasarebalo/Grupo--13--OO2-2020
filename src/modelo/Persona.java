package modelo;

import java.time.LocalDate;

public class Persona {
	protected String nombre;
	protected int dni;
	protected String apellido;
	protected LocalDate fechaNacimiento;
	protected int idPersona;
	public Persona(String nombre, int dni, String apellido, LocalDate fechaNacimiento, int idPersona) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", idPersona=" + idPersona + "]";
	}
	
	
	
}
