package is.restaurante;

import java.util.List;

public class Factura {
	
	public Factura() {
		comanda = new Comanda();
	}
	
	public Factura(List<Comanda> listaComandas) {
		comanda = new Comanda();
		uneComandas(listaComandas);
	}
	
	public void uneComandas(List<Comanda> listaComandas) {
		for (Comanda c: listaComandas)
			comanda.append(c);
	}
	
	private Comanda comanda;
}
