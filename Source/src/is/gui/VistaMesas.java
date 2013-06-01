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
		this.comandasPanel = new JPanel();
		comandasPanel.setLayout(new FlowLayout());
		JPanel panelMesas = new JPanel();
		panelMesas.setLayout(new FlowLayout());
		//this.restController.requestMesas();
		//this.restController.pedirMesas();

		for (int i=0; i<mesas.length; i++){
			final int j= i;//para que pueda ser utilizado por el listener

			JButton mesa = new JButton("Mesa " + mesas[i].getNumeroMesa());
			mesa.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					numMesa = j;
					comandas = restController.getMesa(j).getListaComandas();
					setComandasPanel();
				}
				
			});
		}
		
		
	}
	
	public void setComandasPanel(){
		for (int i=0; i<comandas.length; i++){
			final int j = i;
			JButton comandaMesa = new JButton("Comanda " + i+1);
			comandaMesa.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					comandaSelected = j;
					//restController.avisaComanda(numMesa, comandaSelected);
				}
				
			});
		}
		JButton editarComanda = new JButton("Editar");
		editarComanda.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		JButton añadirComanda = new JButton("Añadir");
		añadirComanda.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		JButton eliminarComanda = new JButton("Eliminar");
		eliminarComanda.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comandaSelected != -1 && numMesa != -1){
					restController.eliminarComanda(numMesa, comandaSelected);
				}
			}
			
		});
	}
	
	
	
	private GUIController restController;
	private MesaInfo[] mesas;
	private ComandaInfo[] comandas;
	private JPanel comandasPanel;
	int comandaSelected = -1;
	private int numMesa=-1;
}
