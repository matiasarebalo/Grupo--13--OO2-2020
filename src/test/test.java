package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import modelo.ItemFactura;
import modelo.Sistema;

public class test {

	public static void main(String[] args) {
		
		Sistema sistemas = new Sistema();
		
		//agrego empleados clientes locales y productos sin excepciones
		try {
			sistemas.agregarCliente("cliente1", "apellido1", LocalDate.of(1988, 10, 31), "MailCliente1", 11111111);
			sistemas.agregarCliente("cliente2", "apellido2", LocalDate.of(1987, 10, 31), "MailCliente1", 11111112);
			sistemas.agregarCliente("cliente3", "apellido3", LocalDate.of(1986, 10, 31), "MailCliente1", 11111113);
			sistemas.agregarCliente("cliente4", "apellido4", LocalDate.of(1985, 10, 31), "MailCliente1", 11111114);
			sistemas.agregarCliente("cliente5", "apellido5", LocalDate.of(1984, 10, 31), "MailCliente1", 11111115);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			sistemas.agregarLocal("Direccion1", 10, 10, 41111111, null);
			sistemas.agregarLocal("Direccion2", 20, 20, 41111112, null);
			sistemas.agregarLocal("Direccion3", 30, 30, 41111113, null);
			sistemas.agregarLocal("Direccion4", 40, 40, 41111114, null);
			sistemas.agregarLocal("Direccion5", 50, 50, 41111115, null);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			sistemas.agregarEmpleado("Empleado 1", "Apellido1", LocalDate.of(1988, 1, 01), LocalTime.of(8, 0), LocalTime.of(16, 0), "Gerente",2000, 22222222, sistemas.traerLocal("Direccion1"));
			sistemas.agregarEmpleado("Empleado 2", "Apellido2", LocalDate.of(1988, 2, 01), LocalTime.of(8, 0), LocalTime.of(16, 0), "Vendedor",1000, 22222223, sistemas.traerLocal("Direccion1"));
			sistemas.agregarEmpleado("Empleado 3", "Apellido3", LocalDate.of(1988, 3, 01), LocalTime.of(8, 0), LocalTime.of(16, 0), "Gerente",2000, 22222224, sistemas.traerLocal("Direccion2"));
			sistemas.agregarEmpleado("Empleado 4", "Apellido4", LocalDate.of(1988, 4, 01), LocalTime.of(8, 0), LocalTime.of(16, 0), "Vendedor",1000, 22222225, sistemas.traerLocal("Direccion2"));
			sistemas.agregarEmpleado("Empleado 5", "Apellido5", LocalDate.of(1988, 5, 01), LocalTime.of(8, 0), LocalTime.of(16, 0), "Gerente",2000, 22222226, sistemas.traerLocal("Direccion3"));
			sistemas.agregarEmpleado("Empleado 6", "Apellido6", LocalDate.of(1988, 6, 01), LocalTime.of(8, 0), LocalTime.of(16, 0), "Vendedor",1000, 22222227, sistemas.traerLocal("Direccion3"));
			sistemas.agregarEmpleado("Empleado 7", "Apellido7", LocalDate.of(1988, 7, 01), LocalTime.of(8, 0), LocalTime.of(16, 0), "Gerente",2000, 22222228, sistemas.traerLocal("Direccion4"));
			sistemas.agregarEmpleado("Empleado 8", "Apellido8", LocalDate.of(1988, 8, 01), LocalTime.of(8, 0), LocalTime.of(16, 0), "Vendedor",1000, 22222229, sistemas.traerLocal("Direccion4"));
			sistemas.agregarEmpleado("Empleado 9", "Apellido9", LocalDate.of(1988, 9, 01), LocalTime.of(8, 0), LocalTime.of(16, 0), "Gerente",2000, 22222221, sistemas.traerLocal("Direccion5"));
			sistemas.agregarEmpleado("Empleado 10", "Apellido10", LocalDate.of(1988, 10, 01), LocalTime.of(8, 0), LocalTime.of(16, 0), "Vendedor",1000, 22222220, sistemas.traerLocal("Direccion5"));
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		//asigno gerentes de cada local
		sistemas.traerLocal("Direccion1").setGerente(sistemas.traerEmpleado(22222222));
		sistemas.traerLocal("Direccion2").setGerente(sistemas.traerEmpleado(22222224));
		sistemas.traerLocal("Direccion3").setGerente(sistemas.traerEmpleado(22222225));
		sistemas.traerLocal("Direccion4").setGerente(sistemas.traerEmpleado(22222228));
		sistemas.traerLocal("Direccion5").setGerente(sistemas.traerEmpleado(22222221));
		
		try {
			sistemas.agregarProducto("Producto1", 100, "1");
			sistemas.agregarProducto("Producto1", 100, "2");
			sistemas.agregarProducto("Producto2", 200, "1");
			sistemas.agregarProducto("Producto2", 200, "2");
			sistemas.agregarProducto("Producto3", 300, "1");
			sistemas.agregarProducto("Producto3", 300, "2");
			sistemas.agregarProducto("Producto4", 400, "1");
			sistemas.agregarProducto("Producto4", 400, "2");
			sistemas.agregarProducto("Producto5", 500, "1");
			sistemas.agregarProducto("Producto5", 500, "2");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		///agrego mismos lotes en todos los locales todo talle 1
		
		sistemas.traerLocal("Direccion1").agregarLote(10, sistemas.traerProducto(1));
		sistemas.traerLocal("Direccion1").agregarLote(10, sistemas.traerProducto(2));
		sistemas.traerLocal("Direccion1").agregarLote(10, sistemas.traerProducto(3));
		
		sistemas.traerLocal("Direccion2").agregarLote(10, sistemas.traerProducto(1));
		sistemas.traerLocal("Direccion2").agregarLote(10, sistemas.traerProducto(2));
		sistemas.traerLocal("Direccion2").agregarLote(10, sistemas.traerProducto(3));
		
		sistemas.traerLocal("Direccion3").agregarLote(10, sistemas.traerProducto(1));
		sistemas.traerLocal("Direccion3").agregarLote(10, sistemas.traerProducto(2));
		sistemas.traerLocal("Direccion3").agregarLote(10, sistemas.traerProducto(3));
		
		sistemas.traerLocal("Direccion4").agregarLote(10, sistemas.traerProducto(1));
		sistemas.traerLocal("Direccion4").agregarLote(10, sistemas.traerProducto(2));
		sistemas.traerLocal("Direccion4").agregarLote(10, sistemas.traerProducto(3));

	
		
		
		//imprimo datos ingresados
		System.out.println("Imprimo listas de personas");
		System.out.println(sistemas.getListaPersonas());
		System.out.println("Imprimo listas de productos");
		System.out.println(sistemas.getListaProductos());
		System.out.println("Imprimo listas de locales");
		System.out.println(sistemas.getListaLocales());
		System.out.println("Imprimo listas de lotes");
		
		//excepciones
		
		System.out.println("Excepciones");
		try {
			sistemas.agregarCliente("cliente1", "apellido1", LocalDate.of(1988, 10, 31), "MailCliente1", 11111111);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			sistemas.agregarLocal("Direccion1", 10, 10, 41111111, null);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			sistemas.agregarEmpleado("Empleado 1", "Apellido1", LocalDate.of(1988, 1, 01), LocalTime.of(8, 0), LocalTime.of(16, 0), "Gerente",2000, 22222222, sistemas.traerLocal("Direccion1"));	
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			sistemas.agregarProducto("Producto1", 100, "1");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("MODIFICACIONES");
		System.out.println(sistemas.traerLocal(5));
		System.out.println(sistemas.traerEmpleado(22222220));
		System.out.println(sistemas.traerCliente(11111115));
		System.out.println(sistemas.traerProducto(10));
		
		try {
			sistemas.modificarCliente("cliente6", "apellido6", LocalDate.of(2018, 01, 01), "MailCliente1", 11111115);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			sistemas.modificarLocal("Direccion5", 1, 1,	 00000000, null, null,null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			sistemas.modificarEmpleado("EmpleadoModificado", "borrado", null, null, 22222220);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			sistemas.modificarProducto("Productomodificado", 0, "1", 10);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(sistemas.traerLocal(5));
		System.out.println(sistemas.traerEmpleado(22222220));
		System.out.println(sistemas.traerCliente(11111115));
		System.out.println(sistemas.traerProducto(10));
		
		//Excepciones
		try {
			sistemas.modificarCliente("cliente6", "apellido6", LocalDate.of(2018, 01, 01), "MailCliente1", 00000000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			sistemas.modificarLocal("sindireccion", 1, 1,	 00000000, null, null,null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			sistemas.modificarEmpleado("EmpleadoModificado", "borrado", null, null, 99999999);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			sistemas.modificarProducto("Productomodificado", 0, "1", 1000000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		//Eliminar
		System.out.println(sistemas.traerLocal(5));
		System.out.println(sistemas.traerEmpleado(22222220));
		System.out.println(sistemas.traerCliente(11111115));
		System.out.println(sistemas.traerProducto(10));
		
		try {
			sistemas.eliminarCliente(11111115);
		} catch (Exception e) {

			System.out.println(e.getMessage());}
		try {
			sistemas.eliminarEmpleado(22222220);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sistemas.eliminarProducto(sistemas.traerProducto("ProductoModificado", "1").getCodigoProducto());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sistemas.eliminaLocal(sistemas.traerLocal("Direccion5").getCodigo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(sistemas.traerLocal("Dirreccion5"));		
		System.out.println(sistemas.traerEmpleado(22222220));
		System.out.println(sistemas.traerCliente(11111115));
		
		
		//Excepciones
		System.out.println("Imprimo Excepciones de Eliminar");
		try {
			sistemas.eliminarCliente(1);
		} catch (Exception e) {

			System.out.println(e.getMessage());}
		try {
			sistemas.eliminarEmpleado(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sistemas.eliminaLocal(sistemas.traerLocal("dirrecion20").getCodigo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		//Finalizado test de altas bajas y modificaciones
		
		//validar stock interno
		System.out.println("hay 10 unidades de cada producto pruebo primero con uno y despues con mil");
		System.out.println(sistemas.traerLocal(1).validarStockInterno(1, 1));
		System.out.println(sistemas.traerLocal(1).validarStockInterno(1, 1000));
		//validar stock externo
		System.out.println("validar stock externo me fijo que locales tienen");
		System.out.println(sistemas.validarStockExterno(sistemas.traerProducto(1), 1, sistemas.traerLocal(1)));
		System.out.println(sistemas.validarStockExterno(sistemas.traerProducto(1), 10000, sistemas.traerLocal(1)));
		
		System.out.println("Genero remitos");
		
		try {
			sistemas.generarRemito(sistemas.traerLocal(1), LocalDate.now(), sistemas.traerProducto(1), 2, sistemas.traerLocal(1).traerEmpleado(222222223), sistemas.traerCliente(11111111), false, "Efectivo");
			sistemas.generarRemito(sistemas.traerLocal(1), LocalDate.now(), sistemas.traerProducto(2), 2, sistemas.traerLocal(1).traerEmpleado(222222223), sistemas.traerCliente(11111112), false, "Efectivo");
			sistemas.generarRemito(sistemas.traerLocal(2), LocalDate.now(), sistemas.traerProducto(3), 2, sistemas.traerLocal(2).traerEmpleado(222222225), sistemas.traerCliente(11111113), false, "Efectivo");
			sistemas.generarRemito(sistemas.traerLocal(2), LocalDate.now(), sistemas.traerProducto(3), 2, sistemas.traerLocal(2).traerEmpleado(222222225), sistemas.traerCliente(11111114), false, "Efectivo");
			sistemas.generarRemito(sistemas.traerLocal(3), LocalDate.now(), sistemas.traerProducto(3), 2, sistemas.traerLocal(3).traerEmpleado(222222227), sistemas.traerCliente(11111114), false, "Efectivo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			sistemas.generarRemito(sistemas.traerLocal(1), LocalDate.now(), sistemas.traerProducto(1), 10, sistemas.traerLocal(1).traerEmpleado(222222223), sistemas.traerCliente(11111111), false, "Efectivo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("validar stock externo me fijo que locales tienen");
		System.out.println(sistemas.validarStockExterno(sistemas.traerProducto(1), 1, sistemas.traerLocal(1)));
		
		sistemas.generarSolicitudStock(sistemas.traerLocal(1), LocalDate.now(), sistemas.traerProducto(1), 10, sistemas.traerLocal(1).traerEmpleado(22222223), sistemas.traerCliente(11111114), sistemas.traerLocal(2).traerEmpleado(22222225),false, false, sistemas.traerLocal(2));
		

		System.out.println("Traigo solicitudes");
		System.out.println(sistemas.traersolicitudes());
		sistemas.aceptarSolcitudStock(sistemas.traerSolicitudStock(6), sistemas.traerLocal(2).traerEmpleado(22222225), sistemas.traerLocal(2));

		System.out.println("Traigo solicitud ACEPTADA");
		System.out.println(sistemas.traerSolicitudStock(6));	
		List<ItemFactura> list = new ArrayList<ItemFactura>();
		try {
			list.add(new ItemFactura(sistemas.traerProducto(1), 4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("!factura!");
		System.out.println(sistemas.generearFactura(list, sistemas.traerCliente(11111111), sistemas.traerLocal(1)));
	
		try {
			sistemas.modificarEmpleado("modifique", "modifique", LocalDate.of(2010, 10, 10), "modifique", 22222223);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aaaaaaa"+sistemas.traerEmpleado(22222223));
		
		System.out.println("aaa"+sistemas.traerLocal("Direccion1").traerEmpleado(22222223));
	

		System.out.println(sistemas.prodMasVendido());
	
	}

}
