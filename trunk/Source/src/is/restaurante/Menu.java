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
	
	/** Devuelve un string con los platos correspondientes **/
	public String[] mostrarPlatos(String tipoConsumicion){
		String[] nombres;
		switch (tipoConsumicion){
		 /* Acumulas los nombres de los tipos de consumicion seleccionados */
		}
		return nombres;
		
	}
	
//
	private String mostrarConsumiciones( ArrayList<Consumicion> consumiciones){
		String[] nombres;
		/* bucle acumulando todas las consumiciones del array pasado */
		return nombres;
		
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
