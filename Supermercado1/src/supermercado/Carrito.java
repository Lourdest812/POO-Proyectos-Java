package supermercado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private Cliente cliente;
	private List<ItemCarrito> ListCarrito = new ArrayList <ItemCarrito>();
	
	public Carrito (int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
		super();
		this.fecha=fecha;
		this.hora=hora;
		this.idCarrito=idCarrito;
		this.cliente=cliente;
		}

	public Carrito() {
		
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemCarrito> getListCarrito() {
		return ListCarrito;
	}
	
	public ItemCarrito traerItemCarrito(Producto producto) {
		ItemCarrito objItem = null;
		int i=0;
		while(i<ListCarrito.size() && objItem==null) {
			ItemCarrito aux = ListCarrito.get(i);
			if(aux.getProducto().equals(producto)) {
				objItem = aux;
			}
			i++;
		}
		return objItem;
	}
	
	public boolean agregarItem(Producto producto, int cantidad) {
		ItemCarrito objItem = traerItemCarrito(producto);
		boolean agregado = true;
		int id = 1;
		if(objItem==null) {
			if(ListCarrito.size()>0) {
				id = ListCarrito.get(ListCarrito.size()-1).getIdItem()+1;
			}
			ItemCarrito newItem = new ItemCarrito(id, cantidad, producto);
			agregado = ListCarrito.add(newItem);
		}else {
			objItem.setCantidad(objItem.getCantidad()+cantidad);
		}
		return agregado;
	}

	public boolean eliminarItem(Producto producto, int cantidad)throws Exception {
		ItemCarrito objItem = traerItemCarrito(producto);
		if(objItem==null) {
			throw new Exception ("No existe el/los producto/s");
		}else {
			objItem.setCantidad(objItem.getCantidad()-cantidad);
			if(objItem.getCantidad()==0) {ListCarrito.remove(objItem);}
			return true;
		}
	}
	
	public float calcularTotal() {
		float total = 0;
		for(int i=0;i<ListCarrito.size();i++){
			total += ListCarrito.get(i).CalcularSubtotal();
		}
		return total;
	}
	
	public boolean eliminarItemsCarrito(){
		return ListCarrito.removeAll(ListCarrito);
	}

	@Override
	public String toString() {
		
		//return "idCarrito:" + idCarrito + " fecha:" + fecha + " hora:" + hora + " cliente:" + cliente
		//		+ " ListCarrito:" + ListCarrito.toString();
		String ret = "";
		for (ItemCarrito item : ListCarrito) {
			ret += item.toString();
		}
		return "Item: " + ret;
	}
	
	
	
}

