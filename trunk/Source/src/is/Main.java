package is;

import is.gui.GUIController;
import is.gui.UserWindow;
import is.restaurante.Restaurante;

public class Main {
	public Main(){
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Restaurante rest = new Restaurante();
		GUIController controlador = new GUIController (rest);
		UserWindow window = new UserWindow(controlador);
		window.setVisible(true);
	}

}
