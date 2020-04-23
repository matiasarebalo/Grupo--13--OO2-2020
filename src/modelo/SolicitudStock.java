package modelo;

import java.time.LocalDate;

public class SolicitudStock extends Pedido {
	private Empleado colaborador;
	private boolean aceptado;
	private Local localdestinatario;
	public SolicitudStock(int idPedido, LocalDate fecha, Producto producto, int cantidad, Empleado vendedor,
			Cliente cliente, Empleado colaborador, boolean aceptado, boolean facturado,Local localdestinatario) {
		super(idPedido, fecha, producto, cantidad, vendedor, cliente, facturado);
		this.colaborador = colaborador;
		this.aceptado = aceptado;
		this.localdestinatario =localdestinatario;
	}
	public Empleado getColaborador() {
		return colaborador;
	}
	public void setColaborador(Empleado colaborador) {
		this.colaborador = colaborador;
	}
	public boolean isAceptado() {
		return aceptado;
	}
	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}
	
	public Local getLocaldestinatario() {
		return localdestinatario;
	}
	public void setLocaldestinatario(Local localdestinatario) {
		this.localdestinatario = localdestinatario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (aceptado ? 1231 : 1237);
		result = prime * result + ((colaborador == null) ? 0 : colaborador.hashCode());
		result = prime * result + ((localdestinatario == null) ? 0 : localdestinatario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolicitudStock other = (SolicitudStock) obj;
		if (aceptado != other.aceptado)
			return false;
		if (colaborador == null) {
			if (other.colaborador != null)
				return false;
		} else if (!colaborador.equals(other.colaborador))
			return false;
		if (localdestinatario == null) {
			if (other.localdestinatario != null)
				return false;
		} else if (!localdestinatario.equals(other.localdestinatario))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SolicitudStock [colaborador=" + colaborador + ", aceptado=" + aceptado + ", localdestinatario="
				+ localdestinatario + ", idPedido=" + idPedido + ", fecha=" + fecha + ", producto=" + producto
				+ ", cantidad=" + cantidad + ", vendedor=" + vendedor + ", cliente=" + cliente + ", facturado="
				+ facturado + "]";
	}
	
	

}