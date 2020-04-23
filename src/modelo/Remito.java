package modelo;

import java.time.LocalDate;

public class Remito extends Pedido {
	public String formaDePago;
	



    public Remito(int idPedido, LocalDate fecha, Producto producto, int cantidad, Empleado vendedor, Cliente cliente,boolean facturado
			,String formaDePago) {
		super(idPedido, fecha, producto, cantidad, vendedor, cliente, facturado);
		this.formaDePago = formaDePago;
	}

	public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formaDePago == null) ? 0 : formaDePago.hashCode());
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
		Remito other = (Remito) obj;
		if (formaDePago == null) {
			if (other.formaDePago != null)
				return false;
		} else if (!formaDePago.equals(other.formaDePago))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Remito [formaDePago=" + formaDePago + ", idPedido=" + idPedido + ", fecha=" + fecha + ", producto="
				+ producto + ", cantidad=" + cantidad + ", vendedor=" + vendedor + ", cliente=" + cliente + "]";
	}

	
    
}
