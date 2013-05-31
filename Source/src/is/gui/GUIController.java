package is.gui;

import java.util.ArrayList;
import java.util.Date;

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

	public void communicateReserva(Date fecha) {
		
	}
	//TODO hay que hacer los avisos de nueva comanda, nuevos platos en el pedido, nueva reserva, editar reserva, editar comanda, etc
	
	private Restaurante restaurante;


}
