package is.restaurante;

import is.restaurante.consumicion.Consumicion;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Clase que guarda el menu, clasificando las consumiciones segun sean bebidas,
 * primeros, segundos
 * 
 * @author JaimeDan
 * 
 */
public class Menu implements MenuInfo {

	public Menu() {
		observers = new ArrayList<MenuObserver>();
		bebidas = new ArrayList<Consumicion>();
		primeros = new ArrayList<Consumicion>();
		segundos = new ArrayList<Consumicion>();
		postres = new ArrayList<Consumicion>();
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

	// Añade un plato al array del tipo

	public void deleteConsumicion(Consumicion consumicion) {
		for (MenuObserver obs : observers)
			obs.deleteConsumption(consumicion.getNombre(),
					tipoPlato(consumicion.getNombre()).toString());
		dondeEsta(consumicion).remove(consumicion);

	}

	/* Devuelve el array list donde está el elemento buscado */
	private ArrayList<Consumicion> dondeEsta(Consumicion consumicion) {
		for (Consumicion c : bebidas)
			if (c.getNombre().equals(consumicion.getNombre()))
				return bebidas;
		for (Consumicion c : primeros)
			if (c.getNombre().equals(consumicion.getNombre()))
				return primeros;
		for (Consumicion c : segundos)
			if (c.getNombre().equals(consumicion.getNombre()))
				return segundos;
		for (Consumicion c : postres)
			if (c.getNombre().equals(consumicion.getNombre()))
				return postres;
		return null;
	}

	/* Devuelve el array list donde está el elemento buscado */
	public TipoPlatos tipoPlato(String name) {
		for (Consumicion c : bebidas)
			if (c.getNombre().equals(name))
				return TipoPlatos.BEBIDA;
		for (Consumicion c : primeros)
			if (c.getNombre().equals(name))
				return TipoPlatos.PRIMERO;
		for (Consumicion c : segundos)
			if (c.getNombre().equals(name))
				return TipoPlatos.SEGUNDO;
		for (Consumicion c : postres)
			if (c.getNombre().equals(name))
				return TipoPlatos.POSTRE;
		return null;
	}

	// Actualiza un plato al array del tipo

	public void actualizaConsumicion(Consumicion consAntigua,
			Consumicion consNueva, TipoPlatos tPlato) {
		/*
		 * for (MenuObserver obs: observers)
		 * obs.editConsumption(consAntigua.getNombre(), consNueva.getNombre(),
		 * tipoPlato(consAntigua.getNombre()).toString(), tPlato.toString());
		 * 
		 * dondeEsta(consAntigua).remove(consAntigua);
		 */
		deleteConsumicion(consAntigua);
		addConsumicion(consNueva, tPlato);

	}

	// Añade un plato al array del tipo

	public void addConsumicion(Consumicion consumicion, TipoPlatos tPlato) {
		if (dondeEsta(consumicion) == null) {
			switch (tPlato) {
			case BEBIDA:
				bebidas.add(consumicion);
				break;// TODO notificar observers
			case PRIMERO:
				primeros.add(consumicion);
				break;
			case SEGUNDO:
				segundos.add(consumicion);
				break;
			case POSTRE:
				postres.add(consumicion);
				break;
			default:
				;
			}
			// TODO kike, esto no se si esta bien
			for (MenuObserver obs : observers)
				obs.addConsumption(consumicion.getNombre(), tPlato.toString());
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

	public Consumicion getConsumicion(String name) {
		for (Consumicion c : bebidas)
			if (c.getNombre().equals(name))
				return c;
		for (Consumicion c : primeros)
			if (c.getNombre().equals(name))
				return c;
		for (Consumicion c : segundos)
			if (c.getNombre().equals(name))
				return c;
		for (Consumicion c : postres)
			if (c.getNombre().equals(name))
				return c;
		return null;
	}

	public void addObserver(MenuObserver verMenu) {
		observers.add(verMenu);
	}

	static final String LINE_SEPARATOR = System.getProperty("line.separator");

	private ArrayList<MenuObserver> observers;

	private ArrayList<Consumicion> bebidas;
	private ArrayList<Consumicion> primeros;
	private ArrayList<Consumicion> segundos;
	private ArrayList<Consumicion> postres;

}
