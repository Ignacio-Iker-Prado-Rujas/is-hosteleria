package is.gui;

import is.restaurante.ComandaInfo;
import is.restaurante.MesaInfo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VistaMesas extends JPanel{

	
	public VistaMesas(GUIController controller){
		this.restController = controller;
		this.mesas = this.restController.requestMesas();
		
		JPanel panelMesas = new JPanel();
		panelMesas.setLayout(new FlowLayout());
		//this.restController.requestMesas();
		//this.restController.pedirMesas();
		for (final int i=0; i<mesas.length; i++){
			JButton mesa = new JButton("Mesa " + mesas[i].getNumeroMesa());
			mesa.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					numMesa = i;
					comandas = restController.getMesa(i).getListaComandas();
				}
				
			});
		}
		
	}
	
	
	
	private GUIController restController;
	private MesaInfo[] mesas;
	private ComandaInfo[] comandas;
	private int numMesa=-1;
}
