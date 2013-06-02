package is.restaurante.consumicion;

public class Bebida implements Consumicion {

	public Bebida(String name, float price, boolean disp, String desc) {
		this.descripcion = desc;
		this.precio = price;
		this.nombre = name;
		this.disponible = disp;
	}

	@Override
	public float getPrecio() {
		// TODO Auto-generated method stub
		return this.precio;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return this.descripcion;
	}

	@Override
	public boolean isDisponible() {
		// TODO Auto-generated method stub
		return this.disponible;
	}

	public String toString() {
		String str = "";
		str += "\"" + nombre + "\" \"" + descripcion + "\" " + precio + " ";
		if (disponible)
			str += "Disponible";
		else
			str += "NoDisponible";
		str += LINE_SEPARATOR;
		return str;
	}

	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private String descripcion;
	private String nombre;
	private float precio;
	private boolean disponible;

}
