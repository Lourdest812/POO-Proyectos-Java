package negocio;

import java.util.ArrayList;
import java.util.List;

import supermercado.Producto;

public class AdmProducto {
	private List<Producto> ListProductos = new ArrayList<Producto>();
	
	public AdmProducto(List<Producto>ListProductos) {
		super();
		this.ListProductos=ListProductos;
	}
	
	public AdmProducto() {}
	
	public List<Producto> getListProductos() {
		return ListProductos;
	}

	public Producto traerProducto(int idProducto) {
		Producto objProducto = null;
		int i=0;
		while(i<ListProductos.size() && objProducto==null) {
			Producto aux = ListProductos.get(i);
			if(aux.getIdProducto()==idProducto) {
				objProducto=aux;
			}
			i++;
		}
		
		if(objProducto==null) {
			return null;
		}
		return objProducto;
	}
	
	public Producto traerProducto(String producto) {
		Producto objProducto = null;
		int i=0;
		while(i<ListProductos.size() && objProducto==null) {
			Producto aux = ListProductos.get(i);
			if(aux.getProducto().equals(producto)) {
				objProducto=aux;
			}
			i++;
		}
		if(objProducto==null) {
			return null;
		}
		return objProducto;
	}
	
	public boolean agregarProducto(String producto, float precio) throws Exception {
		Producto objProducto=traerProducto(producto);
		int id = 1;
		//boolean agregado = true;
		if(objProducto==null) {
			if(ListProductos.size()>0) {
				id=ListProductos.get(ListProductos.size()-1).getIdProducto()+1;
			}
			//Producto newObj = new Producto(id, producto, precio); 
			//agregado = ListProductos.add(newObj);
			objProducto = new Producto(id, producto, precio);
		}
		else {
			id=ListProductos.get(ListProductos.size()-1).getIdProducto()+1;
			objProducto.setPrecio(precio);
			objProducto.setProducto(producto);
		}
		for(int i=0;i<ListProductos.size();i++) {
			if(objProducto==ListProductos.get(i)) {
				throw new Exception("El producto ya existe");
			}
		}
		return ListProductos.add(objProducto);
		//return agregado;
	}
	
	public boolean modificarProducto(int idProducto, String producto, double precio) throws Exception{
		Producto objProducto = traerProducto(idProducto);
		if(objProducto==null) {
			throw new Exception("No existe el producto");
		}
		if(objProducto.getIdProducto()==idProducto) {
			objProducto.setPrecio((float)precio);
			objProducto.setProducto(producto);
		}
		return true;
	}
	
	public boolean eliminarProducto(int idProducto) throws Exception {
		Producto objProducto = traerProducto(idProducto);
		if(objProducto==null) {
			throw new Exception("No existe el producto");
		}else {
			return ListProductos.remove(objProducto);
		}
	}

	@Override
	public String toString() {
		//return "AdmProducto [ListProductos=" + ListProductos + "]";
		String ret = "";
		for (Producto p : ListProductos) {
			ret += p.toString() + "\n";
		}
		return "Gondola\n" + ret + "\n*******************************************************************";
	}
	
	
	
}
