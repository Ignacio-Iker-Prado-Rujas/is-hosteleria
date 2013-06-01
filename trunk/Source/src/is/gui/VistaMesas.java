package is.gui;

import is.restaurante.MesaInfo;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class VistaMesas extends JPanel{

	
	public VistaMesas(GUIController controller){
		this.restController = controller;
		this.mesas = this.restController.requestMesas();
		
		JPanel panelMesas = new JPanel();
		panelMesas.setLayout(new FlowLayout());
		this.restController.requestMesas();
		this.restController.pedirMesas();
		
	}
	
	
	
	private GUIController restController;
	private MesaInfo[] mesas;
}
