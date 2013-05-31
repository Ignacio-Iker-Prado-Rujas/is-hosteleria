package is.restaurante;

import is.Cliente;

import java.util.ArrayList;
import java.util.Date;

public class Reserva {
	public Reserva(){
		
	}
	public Reserva(Date date, int hour, int min, String name, int number, ArrayList<Mesa> listaMesas){
		this.fecha = date;
		this.hora = hour;
		this.minutos = min;
		this.nombre = name;
		this.numeroDeComensales = number; 
		this.mesas = listaMesas;
	
	}
	
	private ArrayList<Mesa> mesas;
	Date fecha;
	int hora;
	int minutos;
	String nombre;
	int numeroDeComensales;
}
