package is.restaurante;

import is.restaurante.consumicion.Bebida;
import is.restaurante.consumicion.Plato;

import java.util.ArrayList;

public class Menu {
	
	public Menu(){
		bebidas = new ArrayList<Bebida>(2);
		bebidas.add(new Bebida("Vodka-Limón", 1, true, null));
		bebidas.add(new Bebida("Anticongelante", 5, true, null));
		primeros = new ArrayList<Plato>(2);
		primeros.add(new Plato("Lentejas", 5, true, null));
		primeros.add(new Plato("Canelones", 5, true, null));		
		segundos = new ArrayList<Plato>(2);
		segundos.add(new Plato("Filete de caballo", 5, true, null));		
		segundos.add(new Plato("Almondigas", 5, true, null));		
		
		postres = new ArrayList<Plato>(2);
		postres.add(new Plato("Helado de gordaco", 5, true, null));		
		postres.add(new Plato("Manzana de Newton", 5, true, null));		
		
	
	}
	
	
	ArrayList<Bebida> getBebidas(){
		return bebidas;
	}
	
	ArrayList<Plato> getPrimeros(){
		return primeros;
	}
	
	ArrayList<Plato> getSegundos(){
		return segundos;
	}
	
	ArrayList<Plato> getPostres(){
		return postres;
	}
	
	
	
	
	
	
	
	
	
	private ArrayList<Bebida> bebidas;
	private ArrayList<Plato> primeros;
	private ArrayList<Plato> segundos;
	private ArrayList<Plato> postres;

}
