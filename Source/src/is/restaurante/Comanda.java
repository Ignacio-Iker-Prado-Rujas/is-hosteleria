package is.restaurante;

import is.restaurante.consumicion.Plato;

import java.util.ArrayList;

public class Comanda {
	
	
	public void addPrimero(Plato primero){
		primeros.add(primero);
		this.precio += primero.getPrecio();
	}
	
	public void addSegundo(Plato segundo){
		
		segundos.add(segundo);
		this.precio += segundo.getPrecio();
	}
	
	public void addPostre(Plato postre){
		
		postres.add(postre);
		this.precio += postre.getPrecio();
	}
	
	public void addBebida(Plato bebida){
		bebidas.add(bebida);
		this.precio += bebida.getPrecio();
	}
	
	
	public String toString(){
		String pedido = null;
		for (Plato plato: primeros){
			pedido = pedido + plato.getNombre() + " " + plato.getPrecio() + LINE_SEPARATOR;
		}
		for(Plato plato: segundos){
			pedido = pedido + plato.getNombre() + " " + plato.getPrecio() + LINE_SEPARATOR;
		}
		for(Plato plato: postres){
			pedido = pedido + plato.getNombre() + " " + plato.getPrecio() + LINE_SEPARATOR;
		}
		for (Plato bebida: bebidas){
			pedido = pedido + bebida.getNombre() + " " + bebida.getPrecio() + LINE_SEPARATOR;
		}
		pedido += "TOTAL: " + this.precio;
		
		return pedido;
	}
	
	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private ArrayList<Plato> primeros;
	private ArrayList<Plato> segundos;
	private ArrayList<Plato> postres;
	private ArrayList<Plato> bebidas;
	
	private double precio = 0;

}
