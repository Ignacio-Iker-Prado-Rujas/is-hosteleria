package is.restaurante;

import java.util.ArrayList;

public class Mesa {
	
	public void addPedido(Comanda comanda){
		pedidos.add(comanda);
	}
	
	private ArrayList<Comanda> pedidos;
	private int capacidadMaxima;

}
