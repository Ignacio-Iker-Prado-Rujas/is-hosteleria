package is.gui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import is.Fecha;
import is.restaurante.ComandaInfo;
import is.restaurante.Menu;
import is.restaurante.Mesa;
import is.restaurante.MesaInfo;
import is.restaurante.Reserva;
import is.restaurante.ReservaInfo;
import is.restaurante.Restaurante;
import is.restaurante.consumicion.Consumicion;



/**
 * Clase que se encarga de llevar los avisos recibidos en la vista al modelo
 * @author JaimeDan
 *
 *TODO: hay que hacer los register observer
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
	public  ArrayList<Consumicion> requestPrimeros(){
		return restaurante.getMenu(1);
		
	}
	public  ArrayList<Consumicion> requestSegundos(){
		return restaurante.getMenu(2);
		
	}
	public  ArrayList<Consumicion> requestPostres(){
		return restaurante.getMenu(3);
		
	}
	public  ArrayList<Consumicion> requestBebidas(){
		return restaurante.getMenu(0);
		
	}
	public ArrayList<ReservaInfo> getReservas(Fecha fecha){
		return restaurante.buscarReservas(fecha);
		
	}
	public void communicateReserva(int año, int mes, int dia, int hora, 
			int minutos, String cliente, int numeroComensales) {
		Fecha fechaRes = new Fecha(año, mes, dia, hora, minutos);
		Reserva reserva = new Reserva(fechaRes, cliente, numeroComensales, null);
		restaurante.añadirReserva(reserva);
	}

	public void comunicarComanda(int año, int mes, int dia, int hora, 

			int minutos, String cliente, int numeroComensales) {
		Fecha fechaRes = new Fecha(año, mes, dia, hora, minutos);
		Reserva reserva = new Reserva(fechaRes, cliente, numeroComensales, null);
		restaurante.añadirReserva(reserva);
	}
	
	public MesaInfo[] requestMesas() {
		return this.restaurante.getMesas();
	}
	
	public ArrayList<ReservaInfo> reservasDeUnCliente(String nombre){
		return this.restaurante.buscarReservas(nombre);
	}
	
	//TODO hay que hacer los avisos de nueva comanda, nuevos platos en el pedido, nueva reserva, editar reserva, editar comanda, etc
	
	public Mesa getMesa(int j) {
		return restaurante.buscarMesa(j);
		
	}
	public Mesa getMesa(String j) {
		int i = Integer.parseInt(j);
		return restaurante.buscarMesa(i);
		
	}
	

	public void avisaComanda(int numMesa, int comandaSelected) {
		this.restaurante.avisaComanda(numMesa, comandaSelected);
	}
	
	public void eliminarComanda(int numMesa, int comandaSelected) {
		this.restaurante.eliminaComanda(numMesa, comandaSelected);
	}

	public void requestNewConsumption(int numComanda, int numMesa) {
		this.restaurante.addNewConsumption(numComanda, numMesa);
	}
	
	private Restaurante restaurante;


}
