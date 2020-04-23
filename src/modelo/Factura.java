package modelo;

import java.util.List;

public class Factura {
	private Local local;
	private int nroFactura;
	private List<ItemFactura> listaItemFactura;
	private double importe;
	private Cliente cliente;
	public Factura(Local local, Cliente cliente, int nroFactura, List<ItemFactura> listaItemFactura, double importe) {
		super();
		this.local = local;
		this.cliente = cliente;
		this.nroFactura = nroFactura;
		this.listaItemFactura = listaItemFactura;
		this.importe = importe;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getNroFactura() {
		return nroFactura;
	}
	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}
	public List<ItemFactura> getListaItemFactura() {
		return listaItemFactura;
	}
	public void setListaItemFactura(List<ItemFactura> listaItemFactura) {
		this.listaItemFactura = listaItemFactura;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	@Override
	public String toString() {
		return "Factura [local=" + local + ", cliente=" + cliente + ", nroFactura=" + nroFactura + ", listaItemFactura="
				+ listaItemFactura + ", importe=" + importe + "]";
	}


}//cierre de clase
