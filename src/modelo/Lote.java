package modelo;

import java.time.LocalDate;

public class Lote {
	private int cantidadRecibida;
	private LocalDate fechaIngreso;
	private Producto producto;
	private int numeroDeLote;
	private int cantidadExistente;
	public Lote(int cantidadRecibida, LocalDate fechaIngreso, Producto producto, int numeroDeLote,
			int cantidadExistente) {
		super();
		this.cantidadRecibida = cantidadRecibida;
		this.fechaIngreso = fechaIngreso;
		this.producto = producto;
		this.numeroDeLote = numeroDeLote;
		this.cantidadExistente = cantidadExistente;
	}
	public int getCantidadRecibida() {
		return cantidadRecibida;
	}
	public void setCantidadRecibida(int cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getNumeroDeLote() {
		return numeroDeLote;
	}
	public void setNumeroDeLote(int numeroDeLote) {
		this.numeroDeLote = numeroDeLote;
	}
	public int getCantidadExistente() {
		return cantidadExistente;
	}
	public void setCantidadExistente(int cantidadExistente) {
		this.cantidadExistente = cantidadExistente;
	}
	@Override
	public String toString() {
		return "Lote cantidadRecibida=" + cantidadRecibida + ", fechaIngreso=" + fechaIngreso + "\n producto="
				+ producto + "\n numeroDeLote=" + numeroDeLote + ", cantidadExistente=" + cantidadExistente+"\n"  ;
	}
	
}	
