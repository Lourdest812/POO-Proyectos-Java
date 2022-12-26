package supermercado;

public class Cliente {
	private int idCliente;
	private String cliente;
	private long dni;
	private String direccion;
	
	public Cliente (int id, String nombre, long dni, String direccion) {
		super();
		this.idCliente=id;
		this.cliente=nombre;
		this.dni=dni;
		this.direccion=direccion;
	}
	
	public Cliente() {
		
	}

	public int getIdCliente() {
		return idCliente;
	}
	/*
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	*/
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "idCliente:" + idCliente + " cliente:" + cliente + " dni:" + dni + " direccion:" + direccion;
	}
	
}
