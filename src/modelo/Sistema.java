package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Persona> listaPersonas = new ArrayList<Persona>(); 
	private List<Local> listaLocales = new ArrayList<Local>();
	private List<Producto> listaProductos = new ArrayList<Producto>();
	private List<Pedido> listaPedido = new ArrayList<Pedido>(); 
	private List<Lote> listaLote = new ArrayList<Lote>();
	private List<Factura> listFactura = new ArrayList<Factura>();
	public Sistema() {
		super();
	}

	public List<Local> getListaLocales() {
		return listaLocales;
	}
	public void setListaLocales(List<Local> listaLocales) {
		this.listaLocales = listaLocales;
	}
	public List<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public List<Pedido> getListaPedido() {
		return listaPedido;
	}
	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}
	public List<Lote> getListaLote() {
		return listaLote;
	}
	public void setListaLote(List<Lote> listaLote) {
		this.listaLote = listaLote;
	}


	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	//punto 
	public boolean agregarCliente(String nombre,String apellido, LocalDate fechaNacimiento, String email,int dni)throws Exception {
		
		if(traerCliente(dni)!=null) {
			throw new Exception("ERROR EL CLIENTE YA EXISTE");
		}
		int idPersona=1;
		if(listaPersonas.size()>0) {
			idPersona= listaPersonas.get(listaPersonas.size()-1).getIdPersona()+1;
		}
		return listaPersonas.add(new Cliente(nombre, dni, apellido, fechaNacimiento, idPersona, email));
	}
	public Cliente traerCliente(int dni) {
		Cliente c=null;
		int index=0;
		while (index<listaPersonas.size() &&c==null) {
			if(listaPersonas.get(index) instanceof Cliente) {
				Cliente cli = (Cliente) listaPersonas.get(index);
				if (cli.getDni()==dni) {
					c=cli;
				}
			}
			index++;
		}
		return c;
	}


	public boolean agregarEmpleado(String nombre,String apellido, LocalDate fechaNacimiento,LocalTime horarioEntrada,LocalTime horarioSalida,String tipo,float sueldo,int dni,Local local)throws Exception {
		if(this.traerEmpleado(dni)!=null) {
			throw new Exception("ERROR EL EMPLEADO EXISTE");
		}
		int idPersona=1;
		if(listaPersonas.size()>0) {
			idPersona= listaPersonas.get(listaPersonas.size()-1).getIdPersona()+1;
		}
		Empleado p= new Empleado(nombre,dni,apellido,fechaNacimiento,idPersona,horarioEntrada,tipo,sueldo,traerLocal(local.getCodigo()),horarioSalida);
		//lo asigno al local que mande por parametro
		traerLocal(local.getCodigo()).asignarEmpleado(p);
		
		return listaPersonas.add(p);
	}
	public Empleado traerEmpleado(int dni) {
		Empleado e=null;
		int index=0;
		while (index<listaPersonas.size() &&e==null) {
			if(listaPersonas.get(index) instanceof Empleado) {
				Empleado Emp = (Empleado) listaPersonas.get(index);
				if (Emp.getDni()==dni) {
					e=Emp;
				}
			}
			index++;
		}
		return e;
	}

	public boolean modificarEmpleado(String nombre,String apellido, LocalDate fechaNacimiento, String email,int dni) throws Exception{
		if(traerEmpleado(dni)==null) {
			throw new Exception("El Empleado con es dni no se puede moficar porque no existe");
		}
		int index=0;
		boolean modificado=false;
		while(index<listaPersonas.size() && !modificado) {
			if(listaPersonas.get(index) instanceof Empleado) {
				Empleado cli = (Empleado) listaPersonas.get(index);
				if (cli.getDni()==dni) {
					modificado=true;
					listaPersonas.get(index).setNombre(nombre);
					listaPersonas.get(index).setApellido(apellido);
					listaPersonas.get(index).setFechaNacimiento(fechaNacimiento);

				}
			}index++;
		}
		return modificado;
	}
	public boolean eliminarEmpleado(int dni) throws Exception{
		if(traerEmpleado(dni)==null) {
			throw new Exception("El Empleado con es dni no se puede eliminar porque no existe");
		}
		int index=0;
		boolean eliminado=false;
		while(index<listaPersonas.size() && !eliminado) {
			if(listaPersonas.get(index) instanceof Empleado) {
				Empleado Emp = (Empleado) listaPersonas.get(index);
				if (Emp.getDni()==dni) {
					eliminado=true;
					listaPersonas.remove(index);
				}
			}index++;
		}
		return eliminado;
	}


	public boolean modificarCliente(String nombre,String apellido, LocalDate fechaNacimiento, String email,int dni) throws Exception{
		if(traerCliente(dni)==null) {
			throw new Exception("El cliente con es dni no se puede moficar porque no existe");
		}
		int index=0;
		boolean modificado=false;
		while(index<listaPersonas.size() && !modificado) {
			if(listaPersonas.get(index) instanceof Cliente) {
				Cliente cli = (Cliente) listaPersonas.get(index);
				if (cli.getDni()==dni) {
					modificado=true;
					listaPersonas.get(index).setNombre(nombre);
					listaPersonas.get(index).setApellido(apellido);
					listaPersonas.get(index).setFechaNacimiento(fechaNacimiento);
				}
			}index++;
		}
		return modificado;
	}

	public boolean eliminarCliente(int dni) throws Exception{
		if(traerCliente(dni)==null) {
			throw new Exception("El cliente con es dni no se puede eliminar porque no existe");
		}
		int index=0;
		boolean eliminado=false;
		while(index<listaPersonas.size() && !eliminado) {
			if(listaPersonas.get(index) instanceof Cliente) {
				Cliente cli = (Cliente) listaPersonas.get(index);
				if (cli.getDni()==dni) {
					eliminado=true;
					listaPersonas.remove(index);
				}
			}index++;
		}
		return eliminado;
	}


	public Producto traerProducto(String descripcion, String talle) {
		Producto p=null;
		int i=0;
		while(i<listaProductos.size()&&p==null) {
			if(listaProductos.get(i).getDescripcion().equalsIgnoreCase(descripcion) && listaProductos.get(i).getTalle().equalsIgnoreCase(talle)) {
				p=listaProductos.get(i);
			}
			i++;}

		return p;
	}
	public Producto traerProducto(int codigoProducto) {
		Producto p=null;
		int i=0;
		while(i<listaProductos.size()&&p==null) {
			if(listaProductos.get(i).getCodigoProducto()==codigoProducto) {
				p=listaProductos.get(i);
			}
			i++;}

		return p;
	}

	public boolean agregarProducto(String descripcion, double precioUnitario, String talle)throws Exception{

		if(traerProducto(descripcion,talle)!=null) {
			throw new Exception("Error:El Producto ya existe!!");}
		int id=1;
		if(listaProductos.size()>0) {
			id=listaProductos.get(listaProductos.size()-1).getCodigoProducto()+1;
		}
		return listaProductos.add(new Producto(descripcion,precioUnitario,id,talle));
	}

	public boolean modificarProducto (String descripcion,double precio,String talle,int codigoProducto)throws Exception{
		if(this.traerProducto(codigoProducto)==null) {throw new Exception("Error:El producto que quiere  modificar no existe");}

		boolean modificado=false;
		int i=0;
		while(i<listaProductos.size()&& !modificado) {
			if(listaProductos.get(i).getCodigoProducto()==codigoProducto) {
				listaProductos.get(i).setDescripcion(descripcion);
				listaProductos.get(i).setPrecioUnitario(precio);
				listaProductos.get(i).setTalle(talle);
				modificado=true;
			}
			i++;
		}
		return modificado;
	}

	public boolean eliminarProducto(int codigoProducto) throws Exception{
		boolean productoEncontrado=false;
		int i=0;
		int j=1;
		while(j<listaLocales.size()) {
			if (listaLocales.get(j).traerLote(this.traerProducto(codigoProducto)).getCantidadExistente()>0) {
				throw new Exception("Este producto no se puede eliminar contiene lotes activos");
			};
		j++;}
		while(i<listaProductos.size()&&productoEncontrado==false) {
			if(listaProductos.get(i).getCodigoProducto()==codigoProducto) {
				productoEncontrado=true;
				listaProductos.remove(i);
				}
			i++;
			}

		if(productoEncontrado==false) {throw new Exception("Error:El producto que quiere modificar no existe");}
		
		return productoEncontrado;
		
	}

		
		
	
	public Producto prodMasVendido() {
		Producto p=null;
		int i=0;
		int pos=0;
		int mayor=0;
		while(i<listaPedido.size()) {
			if(listaPedido.get(i).getCantidad()>mayor) {
				pos=i;
				mayor=listaPedido.get(i).getCantidad();
			}	
			i++;
		}
		p=listaPedido.get(pos).getProducto();
		return p;
	}

	
	public Local traerLocal(int codigo)  {
		Local traer=null;
		int index=0;
		while(index<listaLocales.size() && traer==null)  {
			if(listaLocales.get(index).getCodigo()==codigo) {
				traer=listaLocales.get(index);
			}
			index++;
		}
		return traer;
	}
	public Local traerLocal(String direccion)  {
		Local traer=null;
		int index=0;
		while(index<listaLocales.size() && traer==null)  {
			if(listaLocales.get(index).getDireccion().equalsIgnoreCase(direccion)) {
				traer=listaLocales.get(index);
			}
			index++;
		}
		return traer;
	}

	public boolean agregarLocal(String direccion, float latitud, float longitud, int telefono,Empleado gerente)
			throws Exception{
		if(traerLocal(direccion)!=null){
			throw new Exception("ERROR EL LOCAL YA ESTA EN LA LISTA");
		}
		int id=1;
		if(listaLocales.size()>0) {
			id=listaLocales.get(listaLocales.size()-1).getCodigo()+1;
		}
		
		return listaLocales.add(new Local(direccion, latitud, longitud,id, telefono,gerente));
	}

	public boolean modificarLocal(String direccion, float latitud, float longitud, int telefono,Empleado gerente,List<Lote>listaLote,List<Empleado>vendedores) throws Exception {
		boolean modificado=false;
		int index=0;
		while (index<listaLocales.size()&&!modificado) {

			if(listaLocales.get(index).getDireccion().equalsIgnoreCase(direccion)) {

				listaLocales.get(index).setDireccion(direccion);
				listaLocales.get(index).setGerente(gerente);
				listaLocales.get(index).setLatitud(latitud);
				listaLocales.get(index).setLongitud(longitud);
				listaLocales.get(index).setNumeroTelefono(telefono);
				listaLocales.get(index).setListaLoteLocal(listaLote);

				modificado=true;
			}

			index++;
		}

		if(modificado==false)throw new Exception("No existe sucursal");

		return modificado;
	}



	
	public boolean eliminaLocal(int codigo)throws Exception {
		if(this.traerLocal(codigo)==null) {throw new Exception("Sucursal no encontrada");}
		boolean eliminado=false;
		int i=0;
		while(i<listaLocales.size()&&!eliminado) {
			if(listaLocales.get(i).getCodigo()==codigo) {
		listaLocales.remove(i);
		eliminado=true;
			}
		i++;
	}
		return eliminado;	
	}

	public List<Local> validarStockExterno(Producto producto, int cantidad,Local local){
		List<Local> lista = new ArrayList<Local>();
		Local listado[]=new Local[listaLocales.size()]; 
		Local aux=null;
		for (int i = 0; i < listaLocales.size(); i++) {
			listado[i]=listaLocales.get(i);

		}
		for(int a= 0; a<listaLocales.size()-1; a++) {
			for (int j = 0; j < listaLocales.size()-1; j++) {
				if(local.calculardistancia(listado[j])>local.calculardistancia(listado[j+1])) {
					aux=listado[j];
					listado[j]=listado[j+1];
					listado[j+1]=aux;
				}
			}	
		}
		int l=0;
		while(l<listaLocales.size()&&lista.size()<2) {
			if(listado[l].validarStockInterno(producto.getCodigoProducto(), cantidad)&&listado[l].getCodigo()!=local.getCodigo()) {
				lista.add(listado[l]);
			}
			l++;
		}
		return lista;	
	}

	public Remito traerRemito(int id) {
		Remito r=null;
		int i=0;
		while(i<listaPedido.size()&&r==null) {
			if(listaPedido.get(i).getIdPedido()==id) {
				r=(Remito) listaPedido.get(i);
			}
			i++;
		}
		return r;
	}

	public boolean generarRemito(Local local, LocalDate fecha,Producto producto,int cantidad,Empleado vendedor,Cliente cliente,boolean facturado,String formaDePago) throws Exception {
		Remito r= this.traerLocal(local.getCodigo()).generarRemito( producto, cantidad, vendedor, cliente, false, formaDePago);
		if(traerRemito(r.getIdPedido())!=null) {
			throw new Exception("El remito ya existe");		}
		int id=1;
		if(listaPedido.size()>0) {
			id=listaPedido.get(listaPedido.size()-1).getIdPedido()+1;
		}
		r.setIdPedido(id);
		return listaPedido.add(r);
	}
	public boolean generarSolicitudStock(Local local,LocalDate fecha, Producto producto, int cantidad, Empleado vendedor,
			Cliente cliente, Empleado colaborador, boolean aceptado, boolean facturado,Local destinatario) {
		SolicitudStock s= traerLocal(local.getCodigo()).generarSolicitudStock(fecha, producto, cantidad, vendedor, cliente, colaborador, false, false,destinatario);
		if(listaPedido.size()>0) {
			s.setIdPedido(listaPedido.get(listaPedido.size()-1).getIdPedido()+1);
		}
		return listaPedido.add(s);	
	}
	public List<SolicitudStock> traersolicitudes(){
		List<SolicitudStock> lista= new ArrayList<SolicitudStock>();
		int index=0;
		for(index=0;index<listaPedido.size();index++) {
			if(listaPedido.get(index) instanceof SolicitudStock) {
				SolicitudStock n = (SolicitudStock) listaPedido.get(index);
				lista.add(n);
			}
		}
		return lista;
	}
	public SolicitudStock traerSolicitudStock(int id) {
		SolicitudStock s=null;
		int i=0;
		while(i<listaPedido.size()&&s==null) {

			if(listaPedido.get(i).getIdPedido()==id)	{
				s=(SolicitudStock) listaPedido.get(i);
			}
			i++;}


		return s;	
	}
	public void aceptarSolcitudStock(SolicitudStock solicitud,Empleado colaborador,Local destinatario) {
		solicitud.setColaborador(this.traerLocal(destinatario.getCodigo()).traerEmpleado(colaborador.dni));
		solicitud.setAceptado(true);
		destinatario.consumoLote(solicitud.getProducto(), solicitud.getCantidad());
	}
	public Factura generearFactura(List<ItemFactura> listItem,Cliente cliente ,Local local ) {
		int idFactura=1;
		if(listFactura.size()>0) {
			idFactura=listFactura.get(listFactura.size()-1).getNroFactura()+1;
		}
		double total = 0;
		for (int i = 0; i < listItem.size(); i++) {
			total= total+listItem.get(i).calcularSubTotal();
		}
		
		Factura f= new Factura(local, cliente, idFactura, listItem,total );
		listFactura.add(f);
		return f;
	}
	
	
	public void cierreDeSueldo() {
		
			for (int j2 = 0; j2 < listaPersonas.size() ; j2++) {
				
				for (int i = 0; i < listaPedido.size(); i++) {
					if(listaPersonas.get(j2).equals(listaPedido.get(i).getVendedor()) ) {
					if(listaPedido.get(i) instanceof Remito) {
					double sueldoo=((Empleado) listaPersonas.get(j2)).getSueldo();
				((Empleado) listaPersonas.get(j2)).setSueldo((float) (sueldoo+listaPedido.get(i).getProducto().getPrecioUnitario()*listaPedido.get(i).getCantidad()*0.05));
						}
					}
				}
			}
		
	}

	
	
	
}
