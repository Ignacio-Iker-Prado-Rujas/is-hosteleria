package is.gui;

import java.util.ArrayList;
import java.util.Date;

import is.Fecha;
import is.restaurante.Menu;
import is.restaurante.Mesa;
import is.restaurante.Reserva;
import is.restaurante.Restaurante;
import is.restaurante.consumicion.Consumicion;



/**
 * Clase que se encarga de llevar los avisos recibidos en la vista al modelo
 * @author JaimeDan
 *
 */
public class GUIController {

	
	public void crearComanda(){
		
	//	this.robot.requestStart();
	} 
	
	public GUIController(Restaurante restaurante){
		this.restaurante = restaurante;
	}
	public  Menu getMenu(){
		return restaurante.getMenu();
	}
	public  ArrayList<Consumicion> getPrimeros(){
		return restaurante.getMenu(1);
		
	}
	public  ArrayList<Consumicion> getSegundos(){
		return restaurante.getMenu(2);
		
	}
	public  ArrayList<Consumicion> getPostres(){
		return restaurante.getMenu(3);
		
	}
	public  ArrayList<Consumicion> getBebidas(){
		return restaurante.getMenu(0);
		
	}

	public void communicateReserva(int año, int mes, int dia, int hora, 
			int minutos, String cliente, int numeroComensales) {
		Fecha fechaRes = new Fecha(año, mes, dia, hora, minutos);
		Reserva reserva = new Reserva(fechaRes, cliente, numeroComensales, null);
		restaurante.añadirReserva(reserva);
	}
	public ArrayList<Reserva> reservasDeUnCliente(String nombre){
		return this.restaurante.buscarReservas(nombre);
	}
	
	//TODO hay que hacer los avisos de nueva comanda, nuevos platos en el pedido, nueva reserva, editar reserva, editar comanda, etc
	
	public Mesa getMesa(String mesa) {
		int i = Integer.parseInt(mesa);
		return restaurante.buscarMesa(i);
		
	}
	private Restaurante restaurante;




}
