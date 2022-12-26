package test;
import java.time.LocalDate;

import java.time.LocalTime;

import supermercado.Carrito;
import supermercado.Producto;
import negocio.Supermercado;
public class Test {
	public static void main(String[] args) { 
		Supermercado super1 = new Supermercado();
		Producto p1 = new Producto (1, "Salsa de tomate", 345.67f);
		LocalDate dia = LocalDate.now();
		LocalTime hora = LocalTime.now();
		LocalDate date = LocalDate.of(2019, 03, 01);
		LocalTime time = LocalTime.of(5, 30, 45, 35);
		
		try {
		super1.agregarProducto("Salsa de tomate", 345.67f);
		super1.agregarProducto("Fideos Luchetti", 123.45f);
		
		super1.agregarCliente("Maria", 12345, "Colon 987");
		super1.agregarCliente("Eduardo", 55555, "Alvear 123");
		
		//System.out.println("\n" + super1.getListProductos());
		super1.mostrarGondola();
		//System.out.println("\n" + super1.getLstCliente());
		super1.mostrarClientes();
		
	} catch(Exception e) {
		System.out.println("Excepcion: " + e.getMessage());
	}
		
		try {
			
			//carro.agregarItem(p1, 4);
			//super1.agregarCliente("Maria", 12345, "Colon 987");
			//super1.agregarCliente("Eduardo", 55555, "Alvear 123");
			
			super1.agregarCarrito(dia, hora, super1.traerCliente(1));
			super1.agregarCarrito(date, time, super1.traerCliente(2));
			super1.traerCarrito(1).agregarItem(p1, 4);
			super1.traerCarrito(1).agregarItem(super1.traerProducto(2), 3);
			super1.traerCarrito(2).agregarItem(super1.getListProductos().get(1), 4);
			
			//System.out.println("\n" + super1.getListCarrito());
			super1.mostrarCarritos();
			//System.out.println(carro.traerItemCarrito(super1.getListProductos().get(0)));
			
		} catch(Exception e) {
			
			System.out.println("Excepcion: " + e.getMessage());
			
		} try {
			super1.modificarProducto(1, "Manzana", 35.75f);
			//System.out.println("\n" + super1.getListProductos());
			super1.mostrarGondola();
			super1.eliminarProducto(2);
			//System.out.println("\n" + super1.getListProductos());
			super1.mostrarGondola();
			
		}catch(Exception e) {
			
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		try {
			
			super1.traerCarrito(1).eliminarItem(p1, 2);
			//System.out.println("\n" + super1.getListCarrito());
			super1.mostrarCarritos();
			
		}catch(Exception e) {
			
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		try {
			System.out.println("Total: " + super1.traerCarrito(1).calcularTotal());
			System.out.println("Subtotal: " + super1.traerCarrito(1).traerItemCarrito(p1).CalcularSubtotal());
		}
		catch(Exception e) {
			
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		try {
			System.out.println("Total por fechas: " + super1.calcularTotal(date, dia));
			System.out.println("Total en un dia: " + super1.calcularTotal(date));
			System.out.println("Total segun mes y anio: " + super1.calcularTotal(9, 2022));
			System.out.println("Total segun mes, anio y cliente: " + super1.calcularTotal(dia, date, super1.traerCliente(1)));
			System.out.println("Total del cliente en una fecha: " + super1.calcularTotal(date, super1.traerCliente(2)));
			System.out.println("Total del cliente en una fecha especifica: " + super1.calcularTotal(9, 2022, super1.traerCliente(1)));
		}catch(Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
	}
}
