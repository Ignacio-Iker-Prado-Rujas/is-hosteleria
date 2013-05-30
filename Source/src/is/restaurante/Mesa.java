package is.restaurante;

import java.util.ArrayList;
import java.util.Vector;

public class Mesa {
	
	public void addPedido(Comanda comanda){
		pedidos.add(comanda);
		//pedidos.
	}
	
	private Vector<Comanda> pedidos;
	private int capacidadMaxima;	//Por qué hay un máximo=???

}
