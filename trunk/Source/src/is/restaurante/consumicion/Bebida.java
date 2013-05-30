package is.restaurante.consumicion;

public class Bebida implements Consumicion{

	@Override
	public float getPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDisponible() {
		// TODO Auto-generated method stub
		return false;
	}

	private String descripción;
	private String nombre;
	private float precio;
	private boolean disponible;
}
