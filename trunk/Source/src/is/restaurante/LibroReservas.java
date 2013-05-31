package is.restaurante;
import java.util.ArrayList;

import is.List;
public class LibroReservas {
	/**
	 * Constructor
	 */
	public LibroReservas(){
		listaReservas = new List<Reserva>();
		numeroReservas = 0;
	}
	
	
	public boolean addReserva(Reserva res){
		numeroReservas++;
		return listaReservas.add(res);

	}

	public boolean eliminarReserva(Reserva res){
		numeroReservas--;
		return listaReservas.erase(res);
	}
	public ArrayList<Reserva> buscarReserva(String nombre){
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		for (int i = 0; i <numeroReservas; i++){
			reservas.add(listaReservas.get(new Reserva(null, 0, 59, nombre, 0, null)));
		}
		return reservas;
	}
	
	
	private List<Reserva> listaReservas;
	private int numeroReservas;
}
