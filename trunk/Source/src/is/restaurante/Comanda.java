package is.restaurante;

import is.restaurante.consumicion.Bebida;
import is.restaurante.consumicion.Consumicion;
import is.restaurante.consumicion.Plato;
import is.restaurante.consumicion.Postre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Iterator;


//hay que registrar los observadores en realizar pedido
//TODO delete  consumicion

//TODO @Alejandro, hay mucha repeticion con los add y tal, en los hashmap que hay como atributo
//		, podriamos hacer que los atributos que son hashmap heredaran de una clase que tuviera
//		implementados todos esos add, y también los remove
//		El remove debbería ser igual que el add pero a la inversa, es decir si lo encuentra reduce su int, y si su int esta a 0 eliminarlo
public class Comanda implements ComandaInfo{

	public void addObserver(ComandaObserver obs){
		this.observers.add(obs);
	}
	
	public void addPrimero(Plato primero){
		if (primeros.containsKey(primero)){
			//primeros.
			primeros.put(primero, primeros.get(primero) + 1);
		}
		else
			primeros.put(primero, 1);
		//primeros.add(primero);
		this.precio += primero.getPrecio();
		emitirCambio();
	}
	
	public void setVecesPrimero(Plato primero){
		
	}
	
	public void setVecesSegundo(Plato segundo){
		
	}
	
	public void setVecesBebidas(Bebida drinking){
		
	}

	public void setVecesPostre(Postre postre){
	
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
		emitirCambio();
	}
	
	public void addPostre(Postre postre){
		if (postres.containsKey(postre)){
			//primeros.
			postres.put(postre, primeros.get(postre) + 1);
		}
		else
			postres.put(postre, 1);
		//primeros.add(primero);
		this.precio += postre.getPrecio();
		emitirCambio();
	}
	
	public void addBebida(Bebida bebida){
		if (bebidas.containsKey(bebida)){
			//primeros.
			bebidas.put(bebida, bebidas.get(bebida) + 1);
		}
		else
			bebidas.put(bebida, 1);
		//primeros.add(primero);
		this.precio += bebida.getPrecio();
		emitirCambio();
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
	
	private void emitirCambio(){
		for (ComandaObserver obs: observers)
			obs.comandaHaCambiado(this.toString());
	}
	
	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private HashMap<Consumicion, Integer> primeros;
	private HashMap<Consumicion, Integer> segundos;
	private HashMap<Consumicion, Integer> postres;
	private HashMap<Consumicion, Integer> bebidas;
	
	private double precio = 0;
	private ArrayList<ComandaObserver> observers = new ArrayList<ComandaObserver>();

}
