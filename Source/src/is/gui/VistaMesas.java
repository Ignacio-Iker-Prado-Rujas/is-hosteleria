package is.gui;

import is.restaurante.MesaInfo;

import java.util.ArrayList;

import javax.swing.JPanel;

public class VistaMesas extends JPanel{

	
	public VistaMesas(GUIController controller){
		this.restController = controller;
		this.mesas = this.restController.requestMesas();
		
		JPanel
	}
	
	
	
	private GUIController restController;
	private MesaInfo[] mesas;
}
