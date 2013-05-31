package is.restaurante;

import is.restaurante.consumicion.Consumicion;
import is.restaurante.consumicion.Plato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Iterator;


//hay que registrar los observadores en realizar pedido
//TODO delete  consumicion
//TODO menu y comanda tienen los mismos atributos
public class Comanda {
	
	
	public void addPrimero(Plato primero){
		if (primeros.containsKey(primero)){
			//primeros.
			primeros.put(primero, primeros.get(primero) + 1);
		}
		else
			primeros.put(primero, 1);
		//primeros.add(primero);
		this.precio += primero.getPrecio();
	}
	
	public void addSegundo(Plato segundo){
		if (segundos.containsKey(segundo)){
			//primeros.
			segundos.put(segundo, segundos.get(segundo) + 1);
		}
		else
			primeros.put(segundo, 1);
		//primeros.add(primero);
		this.precio += segundo.getPrecio();
		
	}
	
	public void addPostre(Plato postre){
		if (postres.containsKey(postre)){
			//primeros.
			postres.put(postre, primeros.get(postre) + 1);
		}
		else
			postres.put(postre, 1);
		//primeros.add(primero);
		this.precio += postre.getPrecio();
	}
	
	public void addBebida(Plato bebida){
		if (bebidas.containsKey(bebida)){
			//primeros.
			bebidas.put(bebida, bebidas.get(bebida) + 1);
		}
		else
			bebidas.put(bebida, 1);
		//primeros.add(primero);
		this.precio += bebida.getPrecio();
	}
	
	
	public String toString(){
		String pedido = null;
		for (Entry<Consumicion, Integer> entry : bebidas.entrySet()){
			pedido = pedido + entry.getKey().getNombre() + " "
					+ entry.getKey().getPrecio() + " Cantidad: "
					+ bebidas.get(entry.getKey());
		}
		for (Entry<Consumicion, Integer> entry : primeros.entrySet()){
			pedido = pedido + entry.getKey().getNombre() + " "
					+ entry.getKey().getPrecio() + " Cantidad: "
					+ primeros.get(entry.getKey());
		}
		for (Entry<Consumicion, Integer> entry : segundos.entrySet()){
			pedido = pedido + entry.getKey().getNombre() + " "
					+ entry.getKey().getPrecio() + " Cantidad: "
					+ segundos.get(entry.getKey());
		}
		for (Entry<Consumicion, Integer> entry : postres.entrySet()){
			pedido = pedido + entry.getKey().getNombre() + " "
					+ entry.getKey().getPrecio() + " Cantidad: "
					+ postres.get(entry.getKey());
		}/*
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
		*/
		
		pedido += "TOTAL: " + this.precio;
		
		return pedido;
	}
	
	public List<Consumicion> lista(){
		return null;
		
	}
	
	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private HashMap<Consumicion, Integer> primeros;
	private HashMap<Consumicion, Integer> segundos;
	private HashMap<Consumicion, Integer> postres;
	private HashMap<Consumicion, Integer> bebidas;
	
	private double precio = 0;

}
