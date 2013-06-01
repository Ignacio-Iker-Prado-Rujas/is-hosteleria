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
	public ArrayList<ReservaInfo> buscarReservas(Fecha fecha){
		return this.reservas.buscarReserva(fecha);
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
	
	public MesaInfo[] getMesas() {
		// TODO Auto-generated method stub
		return (MesaInfo[]) this.mesas.toArray();
	}
	

	
	private ArrayList<Mesa> mesas;
	private LibroReservas reservas;
	private Menu menu;
	private Tablon tablon;
	
	
}
