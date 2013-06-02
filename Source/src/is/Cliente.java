package is;

/**
 * Clase que gestiona los clientes, con su nombre y código.
 * @author Jesús
 */
public class Cliente {
	public Cliente(String nombre, int code) {
		name = nombre;
		codigo = code;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	private String name;
	private int codigo;
	
}
