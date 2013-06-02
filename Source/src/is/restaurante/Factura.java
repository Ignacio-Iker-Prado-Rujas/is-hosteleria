package is.restaurante;

import java.util.List;


/**
 * Clase que genera una factura a partir de una lista de comandas
 * @author JaimeDan
 *
 */
public class Factura {
	
	public static Comanda generarFactura(List<Comanda> listaComandas) {
		Comanda comanda = new Comanda();
		for (Comanda c : listaComandas)
			comanda.append(c);
		return comanda;
	}
	
}
