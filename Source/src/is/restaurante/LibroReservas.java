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
	
	public ArrayList<Reserva> reservasHoy(){
		Date date = new Date();
		return null;
	}

	public boolean eliminarReserva(Reserva res){
		numeroReservas--;
		return listaReservas.erase(res);
	}/*
	public ArrayList<Reserva> buscarReserva(String nombre){
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		for (int i = 0; i <numeroReservas; i++){
			reservas.add(listaReservas.get(new Reserva(null, 0, 59, nombre, 0, null)));
		}
		return reservas;
	}*/
	
	public int buscarReserva(String nombre){
		int i=0;
		while (i<listaReservas.size()){
			if (listaReservas.get(i).getNombre().equals(nombre)) break;
			i++;
		}
		if (i < listaReservas.size()) return i;
		else return -1;
	}
	
	
	private List<Reserva> listaReservas;
	private int numeroReservas;
}
