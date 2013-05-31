package is.restaurante;
import is.List;
public class LibroReservas {
	/**
	 * Constructor
	 */
	public LibroReservas(){
		listaReservas = new List<Reserva>();
	}
	
	
	public boolean addReserva(Reserva res){
		return listaReservas.add(res);
	}

	public boolean eliminarReserva(Reserva res){
		return listaReservas.erase(res);
	}
	
	
	private List<Reserva> listaReservas;
}
