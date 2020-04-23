package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import com.sun.java_cup.internal.runtime.Scanner;


public class Local {
	private String direccion;
	private float latitud;
	private float longitud;
	private int codigo;
	private int numeroTelefono;
	private Empleado gerente;
	private List<Lote> listaLoteLocal= new ArrayList<Lote>();
	private List<Empleado> listaEmpleadosLocal = new ArrayList<Empleado>();
	public Local(String direccion, float latitud, float longitud, int codigo, int numeroTelefono, Empleado gerente
			) {
		super();
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.codigo = codigo;
		this.numeroTelefono = numeroTelefono;
		this.gerente = gerente;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public Empleado getGerente() {
		return gerente;
	}
	public void setGerente(Empleado gerente) {
		this.gerente = gerente;
	}
	public List<Lote> getListaLoteLocal() {
		return listaLoteLocal;
	}
	public void setListaLoteLocal(List<Lote> listaLoteLocal) {
		this.listaLoteLocal = listaLoteLocal;
	}



	public List<Empleado> getListaEmpleadosLocal() {
		return listaEmpleadosLocal;
	}
	public void setListaEmpleadosLocal(List<Empleado> listaEmpleadosLocal) {
		this.listaEmpleadosLocal = listaEmpleadosLocal;
	}
	public boolean asignarEmpleado(Empleado empleado) {
		if(empleado.getTipo().equalsIgnoreCase("gerente")) {
			this.setGerente(empleado);
		}else {
		 listaEmpleadosLocal.add(empleado);
		}
		return true;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((gerente == null) ? 0 : gerente.hashCode());
		result = prime * result + Float.floatToIntBits(latitud);
		result = prime * result + ((listaEmpleadosLocal == null) ? 0 : listaEmpleadosLocal.hashCode());
		result = prime * result + ((listaLoteLocal == null) ? 0 : listaLoteLocal.hashCode());
		result = prime * result + Float.floatToIntBits(longitud);
		result = prime * result + numeroTelefono;
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
		Local other = (Local) obj;
		if (codigo != other.codigo)
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (gerente == null) {
			if (other.gerente != null)
				return false;
		} else if (!gerente.equals(other.gerente))
			return false;
		if (Float.floatToIntBits(latitud) != Float.floatToIntBits(other.latitud))
			return false;
		if (listaEmpleadosLocal == null) {
			if (other.listaEmpleadosLocal != null)
				return false;
		} else if (!listaEmpleadosLocal.equals(other.listaEmpleadosLocal))
			return false;
		if (listaLoteLocal == null) {
			if (other.listaLoteLocal != null)
				return false;
		} else if (!listaLoteLocal.equals(other.listaLoteLocal))
			return false;
		if (Float.floatToIntBits(longitud) != Float.floatToIntBits(other.longitud))
			return false;
		if (numeroTelefono != other.numeroTelefono)
			return false;
		return true;
	}

	public Empleado traerEmpleado(int dni) {
		boolean estado=false;
		Empleado e=null;
		int index=0;
		while (index<listaEmpleadosLocal.size() && !estado) {
			if(listaEmpleadosLocal.get(index) instanceof Empleado) {
				Empleado Emp = (Empleado) listaEmpleadosLocal.get(index);
				if (Emp.getDni()==dni) {
					estado=true;
					e=Emp;
				}
			}
			index++;
		}
		return e;
	}



	@Override
	public String toString() {
		return "Local direccion=" + direccion + ", latitud=" + latitud + ", longitud=" + longitud + ", codigo="
				+ codigo + "\n numeroTelefono=" + numeroTelefono + ", gerente=" + gerente + "\n"; }
	
	public String lista() {
		String todo="";
		for (int i = 0; i < listaLoteLocal.size(); i++) {
			todo=listaLoteLocal.get(i).toString();
		}
		return todo;
	}
	public boolean agregarLote(int cantidadRecibida, Producto producto) {

		int idLote=1;
		if(listaLoteLocal.size()<0) {
			idLote=listaLoteLocal.get(listaLoteLocal.size()-1).getNumeroDeLote()+1;
		}
		return listaLoteLocal.add(new Lote(cantidadRecibida, LocalDate.now(), producto, idLote, cantidadRecibida));

	}

	public boolean eliminarLote(int numerodeLote)throws Exception {
		boolean eliminado=false;
		int index=0;

		while(index<listaLoteLocal.size()&&eliminado==false) {

			if(listaLoteLocal.get(index).getNumeroDeLote()==numerodeLote) {

				listaLoteLocal.remove(index);
				eliminado=true;
			}
			index++;
		}

		if(eliminado==false)throw new Exception("Numero de Lote no encontrado");

		return eliminado;
	}
	public Lote traerLote(int nroDeLote)throws Exception {
		Lote l1=null;
		int i=0;
		while(i<listaLoteLocal.size()&&l1==null) {
			if(listaLoteLocal.get(i).getNumeroDeLote()==nroDeLote) {
				l1=listaLoteLocal.get(i);
			}
			i++;
		}
		if(l1==null)throw new Exception("el lote no existe");
		return l1;

	}
	public Lote traerLote(Producto producto)throws Exception {
		Lote l1=null;
		int i=0;
		while(i<listaLoteLocal.size()&&l1==null) {
			if(listaLoteLocal.get(i).getProducto().equals(producto)) {
				l1=listaLoteLocal.get(i);
			}
			i++;
		}
		if(l1==null)throw new Exception("el lote no existe");
		return l1;
		
	}

	public double calculardistancia(Local local1) {
		double lon1=this.longitud;
		double lon2=local1.getLongitud();
		double lat1=this.latitud;
		double lat2=local1.getLatitud();
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344;
		return (dist);
	}

	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}
		//--17
	public boolean validarStockInterno(int codigoProducto, int cantidad) {
		boolean valido=false;
		int index=0;
		int cantid=0;
		while(index<listaLoteLocal.size()) {
			if(listaLoteLocal.get(index).getProducto().getCodigoProducto()==codigoProducto) {
				cantid=cantid+listaLoteLocal.get(index).getCantidadExistente();
			}			
			index++;
		}
		if(cantidad>cantid) {
			valido=false;
		}else {
			valido=true;
		}
		return valido;
	}


	public boolean consumoLote(Producto producto, int cantidad) {
		boolean consumo=false;
		boolean esta= false;
		int index=0;
		while(index<listaLoteLocal.size() && !esta) {
			if(listaLoteLocal.get(index).getProducto().equals(producto)) {
				if(listaLoteLocal.get(index).getCantidadExistente()-cantidad>0) {
					listaLoteLocal.get(index).setCantidadExistente(listaLoteLocal.get(index).getCantidadExistente()-cantidad);
				}
				if(listaLoteLocal.get(index).getCantidadExistente()-cantidad==0) {
					listaLoteLocal.remove(index);
				}
			}index++;
		}
		return consumo;
	}

	public Remito generarRemito( Producto producto, int cantidad, Empleado vendedor, Cliente cliente,boolean facturado
			,String formaDePago)throws Exception {
		if(validarStockInterno(producto.getCodigoProducto(), cantidad)==false) {
			throw new Exception("ERROR EL LOTE NO ALCANZA");
		}
		Remito remi = new Remito(0, LocalDate.now(), producto, cantidad, vendedor, cliente, facturado, formaDePago);
		boolean esta= false;
		int index=0;
		while(index<listaLoteLocal.size() && !esta) {
			if(listaLoteLocal.get(index).getProducto().equals(producto)) {
				if(listaLoteLocal.get(index).getCantidadExistente()-cantidad>0) {
					listaLoteLocal.get(index).setCantidadExistente(listaLoteLocal.get(index).getCantidadExistente()-cantidad);
				}
				if(listaLoteLocal.get(index).getCantidadExistente()-cantidad==0) {
					listaLoteLocal.remove(index);
				}
			}index++;
		}
		return remi;
	}
	public SolicitudStock generarSolicitudStock(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor,
			Cliente cliente, Empleado colaborador, boolean aceptado, boolean facturado, Local destinatario) {
		SolicitudStock s=new SolicitudStock(1,fecha,producto,cantidad,vendedor,cliente,colaborador,false,false,destinatario);

		return s;
	}


}

