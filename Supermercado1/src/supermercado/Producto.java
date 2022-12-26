package supermercado;
import java.util.Objects;

public class Producto {
	
	private int idProducto;
	private String producto;
	private float precio;
	
	public Producto (int idProducto, String producto, float precio2) {
		super();
		this.idProducto=idProducto;
		this.producto=producto;
		this.precio=precio2;
	}
	
	public String getProducto() {
		return producto;
	}
	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	@Override
	public String toString() {
		return "idProducto: " + idProducto + " Nombre: " + producto + " Precio: " + precio;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idProducto, precio, producto);
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
		return idProducto == other.idProducto && Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio)
				&& Objects.equals(producto, other.producto);
	}
	
}
