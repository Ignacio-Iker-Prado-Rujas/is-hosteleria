package is.restaurante;

import java.util.List;

public class Factura {
	
	public static Comanda generarFactura(List<Comanda> listaComandas) {
		Comanda comanda = new Comanda();
		for (Comanda c : listaComandas)
			comanda.append(c);
		return comanda;
	}
	
}
