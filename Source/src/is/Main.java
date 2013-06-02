package is;

/**
 * Lanza la aplicación, mediante el Método Modelo-Vista-Controlador
 * @author Jesús
 */
import is.gui.GUIController;
import is.gui.UserWindow;
import is.restaurante.Restaurante;

public class Main {

	public static void main(String[] args) {
		Restaurante rest = new Restaurante();
		GUIController controlador = new GUIController(rest);
		UserWindow window = new UserWindow(controlador);
		window.setVisible(true);
	}
}
