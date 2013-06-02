package is.restaurante;

import is.Cliente;
import is.Fecha;
import java.util.ArrayList;
import java.util.Date;

public class Reserva implements Comparable<Reserva>, ReservaInfo{
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
		this.nombre = name;
		this.numeroDeComensales = numComensales; 
		this.mesas = listaMesas;
	
	}
	/**
	 * 
	 * @return nombre del cliente que reserva
	 */
	public String getNombre(){
		return this.nombre;
	}
	public Fecha getFecha(){
		return this.fecha;
	}
	
	@Override
	public int compareTo(Reserva o) {
		if (o!= null){
			if (this.fecha.esMayorQue(o.fecha))
				return 1;
			else if (this.fecha.equals(o.fecha))
				return 0;
			else return -1;
		}return -1;
	}
	public String toString(){
		String name = "";
		name += "Nombre: " + this.nombre + LINE_SEPARATOR + "Fecha: " + this.fecha.toString() + LINE_SEPARATOR;
		if (mesas != null){
			name += "Mesas: ";
			for (Mesa m : this.mesas) 
				name += m.getNumeroMesa() + " ";
		}
		name += "Numero de comensales: " + this.numeroDeComensales;
		return name;
	}
	
	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private ArrayList<Mesa> mesas;
	private Fecha fecha;
	//int hora;
	//int minutos;
	private String nombre;
	private int numeroDeComensales;
	public void crearPanel() {
		// TODO Auto-generated method stub
		
	}
	
}
