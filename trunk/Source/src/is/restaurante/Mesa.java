package is.restaurante;

import is.restaurante.consumicion.Consumicion;


import java.util.ArrayList;
import java.util.Vector;

/**
 * Contiene la información relativa a la mesa, con la lista de comandas y el número de identificación de la mesa.
 * Permite añadir comandas y generar la factura correspondiente a la mesa.
 * @author Villarin
 */
public class Mesa implements MesaInfo{
	
	public Mesa(int num){
		this.setNumeroMesa(num);
	}
	
	public void addPedido(Comanda comanda){
		comandas.add(comanda);
		//comandas.
	}
	
//TODO editComanda, selectComanda delete Comanda
	
	@Override
	public int getNumeroMesa() {
		return numeroMesa;
	}
	
	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	public String generarFactura(){
		String factura = "";
		//TODO tenemos que usar la clase Factura, con su metodo estatico;
		/*for (Comanda c : comandas){
			factura += c.toString() + LINE_SEPARATOR;
		}
		//return comandas.toString();
		return factura;*/
		return "";
	}
	
	@Override
	//TODO igual habria que crear un metodo que pasara del vector a un array[]
	public ComandaInfo[] getListaComandas() {
		if (this.comandas != null) 
		return (ComandaInfo[]) this.comandas.toArray();
		else return null;
	}
	
	/**
	 * Escoge una comanda como actual, para realizar acciones sobre ella
	 * @param comandaSelected
	 */
	public void avisaComanda(int comandaSelected) {
		if (comandaActual != -1)
			//TODO, al dar al boton de generar comanda o elegir comanda en la vista correspondiente, se añadira el observador (supongo)
			//comandaActual.removeObserver(obs);
			//comandas.get(comandaSelected).addObserver(obs);
		comandaActual = comandaSelected;
	}

	public void eliminaComanda(int comandaSelected) {
		comandas.remove(comandaSelected);
		emitirCambios();
	}

	public void addConsumption(int numComanda, Consumicion plato, TipoPlatos tPlato) {
		//comandas.get(numComanda).addConsumicion(plato);
		switch (tPlato){
		case PRIMERO: comandas.get(numComanda).addPrimero(plato);
		case SEGUNDO: comandas.get(numComanda).addSegundo(plato);
		case POSTRE: comandas.get(numComanda).addPostre(plato);
		case BEBIDA: comandas.get(numComanda).addBebida(plato);
		}
	}
	
	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	private void emitirCambios(){
		for (MesaObserver o: obs)
			o.cambioOcurrido((ComandaInfo[]) comandas.toArray());
	}
	
	
	private ArrayList<MesaObserver> obs;
	private Vector<Comanda> comandas;
	private int numeroMesa;
	private int comandaActual = -1;


	
	
	
}
