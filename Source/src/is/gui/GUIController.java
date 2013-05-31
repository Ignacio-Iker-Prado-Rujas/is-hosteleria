package is.gui;

import java.util.ArrayList;

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
	public  ArrayList<Consumicion> getMenu(){
		return restaurante.getMenu();
		
	}
	//TODO hay que hacer los avisos de nueva comanda, nuevos platos en el pedido, nueva reserva, editar reserva, editar comanda, etc
	
	private Restaurante restaurante;

	public void communicateReserva() {
		// TODO Auto-generated method stub
		
	}

}
