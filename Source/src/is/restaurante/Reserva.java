package is.restaurante;

import is.Cliente;
import is.Fecha;
import java.util.ArrayList;
import java.util.Date;

public class Reserva implements Comparable<Reserva>{
	public Reserva(){
		
	}
	/**
	 * 
	 * @param date
	 * @param hour
	 * @param min
	 * @param name
	 * @param number
	 * @param listaMesas
	 */
	public Reserva(Fecha date, String name, int numComensales, ArrayList<Mesa> listaMesas){
		this.fecha = date;
		//this.hora = hour;
		//this.minutos = min;
		this.nombre = name;
		this.numeroDeComensales = numComensales; 
		this.mesas = listaMesas;
	
	}
	
	@Override
	public int compareTo(Reserva o) {
		if (this.fecha.esMayorQue(o.fecha))
			return 1;
		else if (this.fecha.equals(o.fecha))
			return 0;
		else return -1;
	}
	
	private ArrayList<Mesa> mesas;
	private Fecha fecha;
	//int hora;
	//int minutos;
	String nombre;
	int numeroDeComensales;
	public void crearPanel() {
		// TODO Auto-generated method stub
		
	}
	
}
