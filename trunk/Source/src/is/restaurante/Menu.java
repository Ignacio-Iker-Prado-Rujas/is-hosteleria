package is.restaurante;

import is.restaurante.consumicion.Bebida;
import is.restaurante.consumicion.Consumicion;
import is.restaurante.consumicion.Plato;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Menu implements MenuInfo {

	public Menu() {
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

		// postres.get(index)

	}

	public Menu(ArrayList<Consumicion> listaPrimeros,
			ArrayList<Consumicion> listaSegundos,
			ArrayList<Consumicion> listaBebidas,
			ArrayList<Consumicion> listaPostres) {
		primeros = listaPrimeros;
		segundos = listaSegundos;
		bebidas = listaBebidas;
		postres = listaPostres;
	}

	/** Devuelve una lista de los tipos de consumiciones que existen **/
	/*
	 * public Consumiciones[] verMenu(){ return tipoConsumiciones; }
	 */

	/** Devuelve un string con los platos correspondientes **/
	public ArrayList<Consumicion> getPlatos(TipoPlatos tipoPlato) {
		switch (tipoPlato) {
		case BEBIDA:
			return bebidas;
		case PRIMERO:
			return primeros;
		case SEGUNDO:
			return segundos;
		case POSTRE:
			return postres;
		default:
			return null;
		}
	}
	
	//Añade un plato al array del tipo
	
	public void deleteConsumicion(Consumicion consumicion, TipoPlatos tPlato){
		switch (tPlato) {
		case BEBIDA:
			 bebidas.remove(consumicion);//TODO notificar observers
		case PRIMERO:
			primeros.remove(consumicion);
		case SEGUNDO:
			segundos.remove(consumicion);
		case POSTRE:
			postres.remove(consumicion);
		default:
			;
		}
		
	}
	
	//Actualiza un plato al array del tipo
	
	public void actualizaConsumicion(Consumicion consAntigua, Consumicion consNueva, TipoPlatos tPlato){
		for(Consumicion c: bebidas)
			if(c.getNombre().equals(consAntigua.getNombre())) bebidas.remove(consAntigua);//TODO notificar observer de borrado
		for(Consumicion c: primeros)
			if(c.getNombre().equals(consAntigua.getNombre())) primeros.remove(consAntigua);
		for(Consumicion c: segundos)
			if(c.getNombre().equals(consAntigua.getNombre())) segundos.remove(consAntigua);
		for(Consumicion c: postres)
			if(c.getNombre().equals(consAntigua.getNombre())) postres.remove(consAntigua);
		
		switch (tPlato) {
		case BEBIDA:
			bebidas.add(consNueva);	//TODO notificar observers de añadido
		case PRIMERO:
			primeros.add(consNueva);
		case SEGUNDO:
			segundos.add(consNueva);
		case POSTRE:
			postres.add(consNueva);
		default:
			;
		}
		
	}
	
	//Añade un plato al array del tipo
	
	public void addConsumicion(Consumicion consumicion, TipoPlatos tPlato){
		switch (tPlato) {
		case BEBIDA:
			bebidas.add(consumicion);//TODO notificar observers
		case PRIMERO:
			primeros.add(consumicion);
		case SEGUNDO:
			segundos.add(consumicion);
		case POSTRE:
			postres.add(consumicion);
		default:
			;
		}
		
	}

	//
	private String[] mostrarConsumiciones(ArrayList<Consumicion> consumiciones) {
		String[] nombres = null;
		/* bucle acumulando todas las consumiciones del array pasado */
		return nombres;

	}

	public ArrayList<Consumicion> getBebidas() {
		return bebidas;
	}

	public ArrayList<Consumicion> getPrimeros() {
		return primeros;
	}

	public ArrayList<Consumicion> getSegundos() {
		return segundos;
	}

	public ArrayList<Consumicion> getPostres() {
		return postres;
	}

	private String stringConsumiciones(ArrayList<Consumicion> listaConsumiciones) {
		String str = "";
		for (Consumicion consumicion : listaConsumiciones)
			str += consumicion.toString();
		return str;
	}

	public String toString() {
		String menu = "";
		menu += "BeginMenu" + LINE_SEPARATOR + "BeginPrimeros" + LINE_SEPARATOR;
		menu += stringConsumiciones(primeros);
		menu += "EndPrimeros" + LINE_SEPARATOR + "BeginSegundos"
				+ LINE_SEPARATOR;
		menu += stringConsumiciones(segundos);
		menu += "EndSegundos" + LINE_SEPARATOR + "BeginBebidas"
				+ LINE_SEPARATOR;
		menu += stringConsumiciones(bebidas);
		menu += "EndBebidas" + LINE_SEPARATOR + "BeginPostres" + LINE_SEPARATOR;
		menu += stringConsumiciones(postres);
		menu += "EndPostres" + LINE_SEPARATOR + "EndMenu" + LINE_SEPARATOR;
		return menu;
	}

	public boolean saveMenu(String fileName) {
		String menu = toString();
		try {
			FileWriter fichero = new FileWriter(fileName + ".txt");
			PrintWriter printer = new PrintWriter(fichero);
			printer.println(menu);
			fichero.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public Consumicion getConsumicion(String name){
		for(Consumicion c: bebidas)
			if(c.getNombre().equals(name)) return c;
		for(Consumicion c: primeros)
			if(c.getNombre().equals(name)) return c;
		for(Consumicion c: segundos)
			if(c.getNombre().equals(name)) return c;
		for(Consumicion c: postres)
			if(c.getNombre().equals(name)) return c;
		return null;
	}
	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private ArrayList<Consumicion> bebidas;
	private ArrayList<Consumicion> primeros;
	private ArrayList<Consumicion> segundos;
	private ArrayList<Consumicion> postres;

}
