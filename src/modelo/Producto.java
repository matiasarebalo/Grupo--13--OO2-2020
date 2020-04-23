package modelo;

public class Producto {
	private String descripcion;
	private double precioUnitario;
	private int codigoProducto;
	private String talle;
	public Producto(String descripcion, double precioUnitario, int codigoProducto, String talle) {
		super();
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.codigoProducto = codigoProducto;
		this.talle = talle;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getTalle() {
		return talle;
	}
	public void setTalle(String talle) {
		this.talle = talle;
	}
	@Override
	public String toString() {
		return "Producto [descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + ", codigoProducto="
				+ codigoProducto + ", talle=" + talle + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoProducto;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precioUnitario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((talle == null) ? 0 : talle.hashCode());
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
		Producto other = (Producto) obj;
		if (codigoProducto != other.codigoProducto)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (Double.doubleToLongBits(precioUnitario) != Double.doubleToLongBits(other.precioUnitario))
			return false;
		if (talle == null) {
			if (other.talle != null)
				return false;
		} else if (!talle.equals(other.talle))
			return false;
		return true;
	}
	
	
}
