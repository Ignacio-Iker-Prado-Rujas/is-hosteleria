package is.restaurante;

import is.restaurante.consumicion.Bebida;
import is.restaurante.consumicion.Consumicion;
import is.restaurante.consumicion.Plato;
import is.restaurante.consumicion.Postre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

//hay que registrar los observadores en realizar pedido
//TODO delete  consumicion

//TODO @Alejandro, hay mucha repeticion con los add y tal, en los hashmap que hay como atributo
//		, podriamos hacer que los atributos que son hashmap heredaran de una clase que tuviera
//		implementados todos esos add, y también los remove
//		El remove debbería ser igual que el add pero a la inversa, es decir si lo encuentra reduce su int, y si su int esta a 0 eliminarlo
public class Comanda implements ComandaInfo {

	@SuppressWarnings("unchecked")
	public Comanda() {
		comanda = new HashMap[4];
		for (int i = 0; i < 4; i++)
			comanda[i] = new HashMap<Consumicion, Integer>();
	}

	public void addObserver(ComandaObserver obs) {
		this.observers.add(obs);
	}

	private void addConsumicion(Consumicion consumicion, int index) {
		if (comanda[index].containsKey(consumicion)) {
			comanda[index]
					.put(consumicion, comanda[index].get(consumicion) + 1);
		} else
			comanda[index].put(consumicion, 1);
		this.precio += consumicion.getPrecio();
		emitirCambio();
	}

	private void deleteConsumicion(Consumicion consumicion, int index) {
		if (comanda[index].containsKey(consumicion)) {
			comanda[index]
					.put(consumicion, comanda[index].get(consumicion) - 1);
			if (comanda[index].get(consumicion) == 0)
				comanda[index].remove(consumicion);
			this.precio -= consumicion.getPrecio();
			emitirCambio();
		} else
			// Emitir un error
			;
	}

	public void addPrimero(Consumicion primero) {
		addConsumicion(primero, 0);
	}

	public void deletePrimero(Consumicion primero) {
		deleteConsumicion(primero, 0);
	}

	public void setVecesPrimero(Consumicion primero) {

	}

	public void addSegundo(Consumicion segundo) {
		addConsumicion(segundo, 1);
	}

	public void deleteSegundo(Consumicion segundo) {
		deleteConsumicion(segundo, 1);
	}

	public void setVecesSegundo(Consumicion segundo) {

	}

	public void addPostre(Consumicion postre) {
		addConsumicion(postre, 2);
	}

	public void deletePostre(Consumicion postre) {
		deleteConsumicion(postre, 2);
	}

	public void setVecesPostre(Consumicion postre) {

	}

	public void addBebida(Consumicion bebida) {
		addConsumicion(bebida, 3);
	}

	public void deleteBebida(Consumicion bebida) {
		deleteConsumicion(bebida, 3);
	}

	public void setVecesBebidas(Bebida drinking) {

	}

	public void append(Comanda other) {
		for (int tipoPlato = 0; tipoPlato < 4; tipoPlato++) {
			Set<Consumicion> claveOther = other.comanda[tipoPlato].keySet();
			// Obtenemos un vector con los elementos de la otra Comanda del tipo
			// de plato i
			Consumicion[] consumicionesOther = claveOther
					.toArray(new Consumicion[claveOther.size()]);
			// Para cada elemento del vector, los añadimos tanta veces como
			// existira en la otra comanda
			for (int pos = 0; pos < consumicionesOther.length; pos++) {
				int veces = other.comanda[tipoPlato]
						.get(consumicionesOther[pos]);
				for (int num = 0; num < veces; num++)
					addConsumicion(consumicionesOther[pos], tipoPlato);
			}
		}
	}

	public String toString() {
		String pedido = "";
		for (int i = 0; i < 4; i++)
			for (Entry<Consumicion, Integer> entry : comanda[i].entrySet()) {
				pedido = pedido + entry.getKey().getNombre() + " "
						+ entry.getKey().getPrecio() + " Cantidad: "
						+ comanda[i].get(entry.getKey()) + LINE_SEPARATOR;
			}
		pedido += "TOTAL: " + this.precio;
		return pedido;
	}

	public List<Consumicion> lista() {
		return null;

	}

	private void emitirCambio() {
		for (ComandaObserver obs : observers)
			obs.comandaHaCambiado(this.toString());
	}

	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private HashMap<Consumicion, Integer> comanda[];

	private double precio = 0;
	private ArrayList<ComandaObserver> observers = new ArrayList<ComandaObserver>();

}
