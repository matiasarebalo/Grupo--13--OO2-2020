package modelo;

import java.time.LocalDate;

public class Cliente extends Persona{
	private String email;

	public Cliente(String nombre, int dni, String apellido, LocalDate fechaNacimiento, int idPersona, String email) {
		super(nombre, dni, apellido, fechaNacimiento,idPersona);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", idPersona=" + idPersona + "]"+
				"Cliente [email=" + email +"]"+"\n";
	}
	
}
