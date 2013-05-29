package is.restaurante;

public class Plato {
	
	public Plato(){
		
	}

	/**
	 * Constructor de un plato
	 * @param descripción: descripción del plato
	 * @param nombre: nombre del plato
	 * @param precio: precio del plato
	 */
	public Plato(String descripción, String nombre, double precio){
		this.descripción = descripción;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	
	/**
	 * 
	 * @return precio del plato
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Precio que queremos que tenga el plato
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	/**
	 * comprueba si el plato está disponible
	 * @return disponible si el plato está disponible
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * marca la disponibilidad de un plato
	 * @param 
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}



	private String descripción;
	private String nombre;
	private double precio;
	private boolean disponible;

}
