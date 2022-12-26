package supermercado;

public class ItemCarrito {
	private int idItem;
	private int cantidad;
	private Producto producto;
	
	public ItemCarrito(int idItem, int cantidad, Producto producto) {
		super();
		this.cantidad=cantidad;
		this.idItem=idItem;
		this.producto=producto;
		
	}
	
	public ItemCarrito() {
		
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public float CalcularSubtotal() {
		return producto.getPrecio()*cantidad;
	}

	@Override
	public String toString() {
		return " idItem: " + idItem + " Cantidad: " + cantidad + " Producto: " + producto;
	}
	
	
	
}
