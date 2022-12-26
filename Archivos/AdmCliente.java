package negocio;

import java.util.ArrayList;
import java.util.List;

import supermercado.Carrito;
import supermercado.Cliente;

public class AdmCliente {
	private List<Cliente> lstCliente = new ArrayList<Cliente>();

	public List<Cliente> getLstCliente() {
		return lstCliente;
	}
	
	public AdmCliente() {}

	public AdmCliente(List<Cliente> lstCliente) {
		super();
		this.lstCliente = lstCliente;
	}
	
	public boolean agregarCliente(String cliente, long dni, String direccion)throws Exception {
		Cliente objCliente = traerCliente(cliente);
		int id = 1;
		if(objCliente==null) {
			if(lstCliente.size()>0) {
				id = lstCliente.get(lstCliente.size()-1).getIdCliente()+1;
			}
			objCliente = new Cliente(id, cliente, dni, direccion);
		}else {throw new Exception("El cliente ya existe");}
		return lstCliente.add(objCliente);
	}
	
	public Cliente traerCliente(int idCliente) {
		Cliente objCliente = null;
		int i=0;
		while(i<lstCliente.size() && objCliente==null) {
			Cliente aux = lstCliente.get(i);
			if(aux.getIdCliente() == idCliente) {
				objCliente = lstCliente.get(i);
			}
			i++;
		}
		if(objCliente==null) {return null;}
		return objCliente;
	}
	
	public Cliente traerCliente(String cliente) {
		Cliente objCliente = null;
		int i=0;
		while(i<lstCliente.size() && objCliente==null) {
			Cliente aux = lstCliente.get(i);
			if(aux.getCliente().equals(cliente)) {
				objCliente = lstCliente.get(i);
			}
			i++;
		}
		if(objCliente==null) {return null;}
		return objCliente;
	}
	
	// +eliminarCliente(int idCliente): boolean
	public boolean eliminarCliente(int idCliente) throws Exception{
		Cliente client = traerCliente(idCliente);
		if(client==null) {
			throw new Exception("El cliente no existe");
		}else {return lstCliente.remove(client);}
	}

	@Override
	public String toString() {
		//return "AdmCliente [lstCliente=" + lstCliente + "]";
		String ret = "";
		for (Cliente client : lstCliente) {
			ret += client.toString() + "\n";
		}
		return "Clientes\n" + ret + "\n*******************************************************************";
	}
	
	
	
}
