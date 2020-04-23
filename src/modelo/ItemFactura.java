package modelo;

public class ItemFactura {
	private Producto producto;
	private int cantidad;
	private double subTotal;
	public ItemFactura(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		setSubTotal( calcularSubTotal());
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	@Override
	public String toString() {
		return "IdemFactura [producto=" + producto + ", cantidad=" + cantidad + ", subTotal=" + subTotal + "]";
	}
	public double calcularSubTotal() {
		return cantidad*producto.getPrecioUnitario();
	}
}
