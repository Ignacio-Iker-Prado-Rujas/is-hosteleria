package is.restaurante;

public interface ComandaObserver {

	public void comandaHaCambiado(String comanda);

	public void comandaError(String error);

}
