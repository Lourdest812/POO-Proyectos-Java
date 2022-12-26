package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import supermercado.Carrito;
import supermercado.Cliente;
import supermercado.Producto;

public class AdmCarrito {
	private List<Carrito> ListCarrito = new ArrayList<Carrito>();
	
	public List<Carrito> getListCarrito() {
		return ListCarrito;
	}
	
	public AdmCarrito() {}
	
	public AdmCarrito(List<Carrito> ListCarrito) {
		super();
		this.ListCarrito=ListCarrito;
	}
	
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception{
		Carrito objCarrito = traerCarrito(cliente.getIdCliente());
		int id = 1;
		if(objCarrito!=null) {
			throw new Exception ("El carrito ya existe");
		}
		else{
			if(ListCarrito.size()>0) {
				id=ListCarrito.get(ListCarrito.size()-1).getIdCarrito()+1;
			}
			objCarrito = new Carrito(id, fecha, hora, cliente);
		}
		return ListCarrito.add(objCarrito);
	}
	
	//+traerCarrito(int idCarrito): Carrito
	public Carrito traerCarrito(int idCarrito) {
		Carrito objCarrito = null;
		int i=0;
		while(i<ListCarrito.size() && objCarrito==null) {
			Carrito aux = ListCarrito.get(i);
			if(aux.getIdCarrito()==idCarrito) {
				objCarrito=aux;
			}
			i++;
		}
		return objCarrito;
	}
	
	public Carrito traerCarrito(long dniCliente) {
		Carrito objCarrito = null;
		int i=0;
		while(i<ListCarrito.size() && objCarrito==null) {
			Carrito aux = ListCarrito.get(i);
			if(aux.getCliente().getDni()==dniCliente) {
				objCarrito=aux;
			}
			i++;
		}
		return objCarrito;
	}
	
	public Carrito traerCarrito(Cliente cliente) {
		Carrito objCarrito = null;
		int i=0;
		while(i<ListCarrito.size() && objCarrito==null) {
			Carrito aux = ListCarrito.get(i);
			if(aux.getCliente().equals(cliente)) {
				objCarrito=aux;
			}
			i++;
		}
		return objCarrito;
	}
	
	public boolean eliminarCarrito(int idCarrito)throws Exception {
		Carrito carrito = traerCarrito(idCarrito);
		if(carrito==null) {
			throw new Exception("El carrito no existe");
		}else {return ListCarrito.remove(carrito);}
	}
	
	/*
	 * 14) +calcularTotal(Cliente cliente): float*/
	public float calcularTotal(Cliente cliente) throws Exception{
		float total = 0;
		for(int i=0;i<ListCarrito.size();i++) {
			Carrito carro = ListCarrito.get(i);
			if(cliente.equals(carro.getCliente())) {
				total = (float) total + carro.calcularTotal();
			}else {new Exception ("El cliente " + cliente.getCliente() + " no existe");}
		}
		return total;
	}
	
	
	public float calcularTotal(int idCliente) throws Exception{
		float total = 0;
		for(int i=0;i<ListCarrito.size();i++) {
			Carrito carro = ListCarrito.get(i);
			if(idCliente==carro.getIdCarrito()) {
				total = (float) total + carro.calcularTotal();
			}else {new Exception ("El cliente de id " + idCliente + "no existe");}
		}
		return total;
	}
	
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) {
		float total = 0;
		int i=0;
		LocalDate aux = fechaInicio;
			Carrito carro = ListCarrito.get(i);
			while(aux.compareTo(fechaFin)!=0 && i<ListCarrito.size()) {
				total = (float) total + carro.calcularTotal();
				aux = aux.plusDays(1);
				i++;
				//System.out.println("fecha: " + aux);
			}
			//else {new Exception ("El cliente de id " + idCliente + "no existe");}
		return total;
	}
	
	public float calcularTotal(LocalDate fecha) {
		float total = 0;
		for(int i=0;i<ListCarrito.size();i++) {
			Carrito carro = ListCarrito.get(i);
			if(fecha.compareTo(carro.getFecha())==0) {
				total = (float) total + carro.calcularTotal();
			}
		}
		return total;
	}
	
	public float calcularTotal(int mes, int anio) throws Exception{
		float total = 0;
		if(mes<=0 || mes>12) {
			new Exception ("Mes invalido");
		}
		for(int i=0;i<ListCarrito.size();i++) {
			Carrito carro = ListCarrito.get(i);
			if(carro.getFecha().getMonthValue()==mes && carro.getFecha().getYear()==anio) {
				total = (float) total + carro.calcularTotal();
			}
		}
		return total;
	}
	
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) {
		Carrito carro = traerCarrito(cliente);
		if(carro.getCliente()==null) {
			new Exception("El cliente no existe");
		}
		float total = 0;
		LocalDate aux = fechaInicio;
			for(int i=0;i<ListCarrito.size();i++) {
				carro = ListCarrito.get(i);
					total = (float) total + carro.calcularTotal();
					aux = aux.plusDays(1);
			}
		return total;
	}
	
	public float calcularTotal(LocalDate fecha, Cliente cliente) {
		Carrito carro = traerCarrito(cliente);
		if(carro.getCliente()==null) {
			new Exception("El cliente no existe");
		}
		float total = 0;
			for(int i=0;i<ListCarrito.size();i++) {
				carro = ListCarrito.get(i);
				if(carro.getFecha().compareTo(fecha)==0 && carro.getCliente().equals(cliente)) {
					total = (float) total + carro.calcularTotal();
				}
			}
		return total;
	}
	
	public float calcularTotal(int mes, int anio, Cliente cliente) {
		Carrito carro = traerCarrito(cliente);
		if(carro.getCliente()==null) {
			new Exception("El cliente no existe");
		}
		if(mes<=0 && mes>12) {
			new Exception("Mes invalido");
		}
		float total = 0;
			for(int i=0;i<ListCarrito.size();i++) {
				carro = ListCarrito.get(i);
				if(carro.getFecha().getMonthValue()==mes && carro.getFecha().getYear()==anio) {
					total = (float) total + carro.calcularTotal();
				}
			}
		return total;
	}
	
	
	public float calcularTotal(int mes, int anio, int dniCliente) {
		Carrito carro = traerCarrito((long)dniCliente);
		float total = 0;
		if(mes<=0 || mes>12) {
			new Exception ("Mes invalido");
		}
		for(int i=0;i<ListCarrito.size();i++) {
			Carrito aux = ListCarrito.get(i);
			if(aux.getFecha().getMonthValue()==mes && aux.getFecha().getYear()==anio && aux.getCliente().getDni()==(long)dniCliente) {
				total = (float) total + carro.calcularTotal();
			}
		}
		return total;
	}

	@Override
	public String toString() {
		//return "AdmCarrito [ListCarrito=" + ListCarrito + "]";
		String ret = "";
		for (Carrito carro : ListCarrito) {
			ret += carro.toString() + "\n";
		}
		return "Carritos\n" + ret + "\n*******************************************************************";
	}
	
	public void mostrarItems() {
		System.out.println(ListCarrito.toString());
	}
	
}
