package is.restaurante.consumicion;

import is.gui.CeldaPlato;

public interface Consumicion {

	public float getPrecio();
	
	public String getNombre();
	
	public String getDescripcion();
	
	public boolean isDisponible();

	public CeldaPlato generarInfo();
}
