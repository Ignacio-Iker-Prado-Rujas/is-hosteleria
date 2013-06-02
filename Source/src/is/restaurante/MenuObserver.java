package is.restaurante;

public interface MenuObserver {
	/**
	 * 
	 * @param consId
	 */
	public void addConsumption(String consId, String tipo);
	
	public void deleteConsumption(String consId, String tipo);
	
	public void editConsumption(String consId, String tipo, String tipoNuevo);

}
