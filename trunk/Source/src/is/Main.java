package is;

/**
 * Lanza la aplicación, mediante el Método Modelo-Vista-Controlador
 * @author Jesús
 */
import java.io.IOException;

import is.gui.GUIController;
import is.gui.UserWindow;
import is.restaurante.Menu;
import is.restaurante.Reserva;
import is.restaurante.Restaurante;
import is.restauranteLoader.MenuLoader;
import is.restauranteLoader.ReservaLoader;

public class Main {

	public static void main(String[] args) throws IOException {
		ReservaLoader loadReserva = new ReservaLoader();
		List<Reserva> reservas = loadReserva.loadReservas("Reservas.txt");
		MenuLoader loadMenu = new MenuLoader();
		Menu menu = loadMenu.loadMenu("Menu.txt");
		Restaurante rest = new Restaurante(reservas, menu);
		GUIController controlador = new GUIController(rest);
		UserWindow window = new UserWindow(controlador);
		window.setVisible(true);
	}
}
