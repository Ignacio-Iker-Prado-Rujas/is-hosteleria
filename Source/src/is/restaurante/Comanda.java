package is.restaurante;

import is.restaurante.consumicion.Consumicion;
import is.restaurante.consumicion.Plato;

import java.util.ArrayList;
import java.util.List;

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
		for (Consumicion bebida: bebidas){
			pedido = pedido + bebida.getNombre() + " " + bebida.getPrecio() + LINE_SEPARATOR;
		}
		for (Consumicion plato: primeros){
			pedido = pedido + plato.getNombre() + " " + plato.getPrecio() + LINE_SEPARATOR;
		}
		for(Consumicion plato: segundos){
			pedido = pedido + plato.getNombre() + " " + plato.getPrecio() + LINE_SEPARATOR;
		}
		for(Consumicion postre: postres){
			pedido = pedido + postre.getNombre() + " " + postre.getPrecio() + LINE_SEPARATOR;
		}
		
		pedido += "TOTAL: " + this.precio;
		
		return pedido;
	}
	
	public List<Consumicion> lista(){
		return null;
		
	}
	
	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private ArrayList<Consumicion> primeros;
	private ArrayList<Consumicion> segundos;
	private ArrayList<Consumicion> postres;
	private ArrayList<Consumicion> bebidas;
	
	private double precio = 0;

}
