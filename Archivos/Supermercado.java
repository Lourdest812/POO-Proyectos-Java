package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import supermercado.Carrito;
import supermercado.Cliente;
import supermercado.Producto;

public class Supermercado {
	private AdmCliente admCliente = new AdmCliente();
	private AdmProducto admProducto = new AdmProducto();
	private AdmCarrito admCarrito = new AdmCarrito();
	
	public boolean agregarCliente(String cliente, long dni, String direccion)throws Exception{
		return admCliente.agregarCliente(cliente, dni, direccion);
	}
	
	public Cliente traerCliente(int idCliente) {
		return admCliente.traerCliente(idCliente);
	}
	
	public Cliente traerCliente(String cliente) {
		return admCliente.traerCliente(cliente);
	}
	
	public boolean eliminarCliente(int idCliente) throws Exception{
		return admCliente.eliminarCliente(idCliente);
	}
	
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception{
		return admCarrito.agregarCarrito(fecha, hora, cliente);
	}
	
	public Carrito traerCarrito(int idCarrito) {
		return admCarrito.traerCarrito(idCarrito);
	}
	
	public Carrito traerCarrito(Cliente cliente) {
		return admCarrito.traerCarrito(cliente);
	}
	
	public boolean eliminarCarrito(int idCarrito)throws Exception {
		return admCarrito.eliminarCarrito(idCarrito);
	}
	
	public Producto traerProducto(int idProducto) {
		return admProducto.traerProducto(idProducto);
	}
	
	public Producto traerProducto(String producto) {
		return admProducto.traerProducto(producto);
	}
	
	public boolean agregarProducto(String producto, float precio) throws Exception {
		return admProducto.agregarProducto(producto, precio);
	}
	
	public boolean modificarProducto(int idProducto, String producto, double precio) throws Exception{
		return admProducto.modificarProducto(idProducto, producto, precio);
	}
	
	public boolean eliminarProducto(int idProducto) throws Exception {
		return admProducto.eliminarProducto(idProducto);
	}
	
	public List<Carrito> getListCarrito() {
		return admCarrito.getListCarrito();
	}
	
	public List<Cliente> getLstCliente() {
		return admCliente.getLstCliente();
	}
	
	public List<Producto> getListProductos() {
		return admProducto.getListProductos();
	}

	public void mostrarGondola() {
		System.out.println(admProducto.toString());
	}
	
	public void mostrarCarritos() {
		System.out.println(admCarrito.toString());
	}
	
	public void mostrarClientes() {
		System.out.println(admCliente.toString());
	}
	
	public float calcularTotal(Cliente cliente) throws Exception{
		return admCarrito.calcularTotal(cliente);
	}
	
	public float calcularTotal(int idCliente) throws Exception{
		return admCarrito.calcularTotal(idCliente);
	}
	
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) {
		return admCarrito.calcularTotal(fechaInicio, fechaFin);
	}
	
	public float calcularTotal(LocalDate fecha) {
		return admCarrito.calcularTotal(fecha);
	}
	
	public float calcularTotal(int mes, int anio) throws Exception{
		return admCarrito.calcularTotal(mes, anio);
	}
	
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) {
		return admCarrito.calcularTotal(fechaInicio, fechaFin, cliente);
	}
	
	public float calcularTotal(LocalDate fecha, Cliente cliente) {
		return admCarrito.calcularTotal(fecha, cliente);
	}
	
	public float calcularTotal(int mes, int anio, Cliente cliente) {
		return admCarrito.calcularTotal(mes, anio, cliente);
	}
	
	public float calcularTotal(int mes, int anio, int dniCliente) {
		return admCarrito.calcularTotal(mes, anio, dniCliente);
	}
}
