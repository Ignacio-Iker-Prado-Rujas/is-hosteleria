package is.gui;

import javax.swing.JPanel;

import is.restaurante.Menu;

public class CantidadExistencias {
	
	public CantidadExistencias(GUIController controller){
		this.controlador = controller;
		JPanel panel = new JPanel();
		menu = controlador.getMenu();
		//menu.
	}
	
	private GUIController controlador;
	private Menu menu;
}
