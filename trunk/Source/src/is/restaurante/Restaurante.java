package is.restaurante;

import is.Fecha;
import is.restaurante.consumicion.Consumicion;

import java.util.ArrayList;
import java.util.List;


//TODO añadir resreva, quitar reserva, edit reserva, añadir mesa quitar mesa editar mesa
//TODO añadir comanda, editar comanda, (Borrar comanda?)
public class Restaurante {

	public Restaurante(){
		this.mesas = new ArrayList<Mesa>(5);
		for (int i=0; i<5; i++)
			mesas.add(new Mesa(i));
		this.reservas = new LibroReservas();
		this.menu = new Menu();
	}
	public void añadirReserva(Reserva reserva){
		reservas.addReserva(reserva);
	}
	public ArrayList<ReservaInfo> /*int List<Integer> */ buscarReservas(String nombre){
		return this.reservas.buscarReserva(nombre);
	}
	public ArrayList<ReservaInfo> buscarReservas(int i){
		return this.reservas.buscarReserva(i);
	}
	
	
	public Menu getMenu() {
		return menu;
	}
	
	
	public ArrayList<Consumicion> getMenu(int n){
		if (n == 0) return menu.getBebidas();
		else if (n == 1) return menu.getPrimeros();
		else if (n == 2) return menu.getSegundos();
		else if (n == 3) return menu.getPostres();
		else return null;
		
		
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public Mesa buscarMesa(int i){
		for (Mesa m: mesas) if (m.getNumeroMesa() == i) return m;
		return null;
	}
	
	public void avisaComanda(int numMesa, int comandaSelected) {
		mesas.get(numMesa).avisaComanda(comandaSelected);
	}
	
	public void eliminaComanda(int numMesa, int comandaSelected) {
		mesas.get(numMesa).eliminaComanda(comandaSelected);
	}

	public void addNewConsumption(int numComanda, int numMesa, Consumicion plato, TipoPlatos tPlato) {
		mesas.get(numMesa).addConsumption(numComanda, plato, tPlato);
	}
	
	public MesaInfo[] getMesas() {
		// TODO Auto-generated method stub
		MesaInfo[] infoMesas = new MesaInfo[this.mesas.size()];
		for (int i=0; i<this.mesas.size(); i++)
			infoMesas[i] = this.mesas.get(i);
		return infoMesas;//(MesaInfo[]) this.mesas.toArray();
	}
	
	public void actualizaConsumicion(Consumicion consAntigua, Consumicion consNueva,TipoPlatos tPlato){
		menu.actualizaConsumicion(consAntigua, consNueva, tPlato);
	}
	public void deleteConsumicion(Consumicion consumicion){
		menu.deleteConsumicion(consumicion);
	}
	public void addConsumicion(Consumicion consumicion, TipoPlatos tPlato){
		menu.addConsumicion( consumicion, tPlato);
	}
	
	public void registerMenuObserver(MenuObserver verMenu) {
		menu.addObserver(verMenu);
	}
	
	private int mesaActual = -1;
	private ArrayList<Mesa> mesas;
	private LibroReservas reservas;
	private Menu menu;
	private Tablon tablon;
	
	
	
		
	
}
