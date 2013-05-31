package is.restaurante;

import is.restaurante.consumicion.Consumicion;

import java.util.ArrayList;


//TODO añadir resreva, quitar reserva, edit reserva, añadir mesa quitar mesa editar mesa
//TODO añadir comanda, editar comanda, (Borrar comanda?)
public class Restaurante {
	public Restaurante(){
		
		
	}
	public Restaurante(){
		this.mesas = new ArrayList<Mesa>();
		this.reservas = new LibroReservas();
		this.menu = new Menu();
	}
	public Reserva crearReserva(){
		return null;
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
	
	public void hola(){}




	private ArrayList<Mesa> mesas;
	private LibroReservas reservas;
	private Menu menu;
	
}
