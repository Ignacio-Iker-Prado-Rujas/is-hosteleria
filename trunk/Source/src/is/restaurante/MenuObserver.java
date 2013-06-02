package is.restaurante;

public interface MenuObserver {
	/**
	 * 
	 * @param consId
	 */
	public void addConsumption(String consId);
	
	public void deleteConsumption(String consId);
	
	public void editConsumption(String consId);

}
