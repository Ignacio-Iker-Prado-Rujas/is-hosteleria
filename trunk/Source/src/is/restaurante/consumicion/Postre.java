package is.restaurante.consumicion;

public class Postre implements Consumicion {

	public Postre(String name, float price, boolean disp, String desc) {
		this.descripción = desc;
		this.precio = price;
		this.nombre = name;
		this.disponible = disp;
	}

	@Override
	public float getPrecio() {
		return this.precio;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String getDescripcion() {
		return this.descripción;
	}

	@Override
	public boolean isDisponible() {
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

	private String descripción;
	private String nombre;
	private float precio;
	private boolean disponible;

}
