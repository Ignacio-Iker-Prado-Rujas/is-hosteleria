package is.restaurante;

import java.util.ArrayList;
import java.util.Vector;

public class Mesa implements MesaInfo{
	
	public Mesa(int num){
		this.setNumeroMesa(num);
	}
	
	public void addPedido(Comanda comanda){
		pedidos.add(comanda);
		//pedidos.
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
		for (Comanda c : pedidos){
			factura += c.toString() + LINE_SEPARATOR;
		}
		//return pedidos.toString();
		return factura;
	}
	
	@Override
	public ComandaInfo[] getListaComandas() {
		return (ComandaInfo[]) this.pedidos.toArray();
	}
	
	/**
	 * Escoge una comanda como actual, para realizar acciones sobre ella
	 * @param comandaSelected
	 */
	public void avisaComanda(int comandaSelected) {
		if (comandaActual != -1)
			//TODO, al dar al boton de generar comanda o elegir comanda en la vista correspondiente, se añadira el observador (supongo)
			//comandaActual.removeObserver(obs);
			//pedidos.get(comandaSelected).addObserver(obs);
		comandaActual = comandaSelected;
	}

	public void eliminaComanda(int comandaSelected) {
		pedidos.remove(comandaSelected);
		emitirCambios();
	}

	
	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	private void emitirCambios(){
		for (MesaObserver o: obs)
			o.cambioOcurrido((ComandaInfo[]) pedidos.toArray());
	}
	
	private ArrayList<MesaObserver> obs;
	private Vector<Comanda> pedidos;
	private int numeroMesa;
	private int capacidadMaxima;
	private int comandaActual = -1;
	
	
	
}
