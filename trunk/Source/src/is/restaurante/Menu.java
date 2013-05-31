package is.restaurante;

import is.restaurante.consumicion.Bebida;
import is.restaurante.consumicion.Consumicion;
import is.restaurante.consumicion.Plato;

import java.util.ArrayList;

public class Menu {
	
	public Menu(){
		bebidas = new ArrayList<Consumicion>(2);
		bebidas.add(new Bebida("Vodka-Limón", 1, true, null));
		bebidas.add(new Bebida("Anticongelante", 5, true, null));
		primeros = new ArrayList<Consumicion>(2);
		primeros.add(new Plato("Lentejas", 5, true, null));
		primeros.add(new Plato("Canelones", 5, true, null));		
		segundos = new ArrayList<Consumicion>(2);
		segundos.add(new Plato("Filete de caballo", 5, true, null));		
		segundos.add(new Plato("Almondigas", 5, true, null));		
		
		postres = new ArrayList<Consumicion>(2);
		postres.add(new Plato("Helado de gordaco", 5, true, null));		
		postres.add(new Plato("Manzana de Newton", 5, true, null));		

	//	postres.get(index)

	}
	
	/** Devuelve una lista de los tipos de consumiciones que existen **/
	/*public Consumiciones[] verMenu(){
		return tipoConsumiciones;
	}*/
	
	/** Muestra todos los platos del tipo pasado **/
	public void mostrarPlatos(String tipoConsumicion){
		switch (tipoConsumicion){
		 /* En funcion del tipo muestra un arrayConsumicion */
		}
		
	}
	
//
	private void mostrarConsumiciones( ArrayList<Consumicion> consumiciones){
		/* bucle mostrando todas las consumiciones del array pasado */
		
	}
	public ArrayList<Consumicion> getBebidas(){
		return bebidas;
	}
	
	public ArrayList<Consumicion> getPrimeros(){
		return primeros;
	}
	
	public ArrayList<Consumicion> getSegundos(){
		return segundos;
	}
	
	public ArrayList<Consumicion> getPostres(){
		return postres;
	}
	
	/*private Consumicion[] tipoConsumiciones = { Bebida, Primero, Segundo, Postre};*/
	
	private ArrayList<Consumicion> bebidas;
	private ArrayList<Consumicion> primeros;
	private ArrayList<Consumicion> segundos;
	private ArrayList<Consumicion> postres;

}
