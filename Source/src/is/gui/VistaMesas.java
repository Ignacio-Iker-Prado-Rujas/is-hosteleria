package is.gui;

import is.restaurante.ComandaInfo;
import is.restaurante.MesaInfo;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VistaMesas extends JPanel{

	
	public VistaMesas(GUIController controller){
		this.restController = controller;
		this.mesas = this.restController.requestMesas();
		comandasPanel = new JPanel[mesas.length];
		comandasContainer = new JPanel();
		final CardLayout comandasLayout = new CardLayout();
		comandasContainer.setLayout(comandasLayout);
		
		final TitledBorder title = new TitledBorder("");
		
		for (int i=0; i< mesas.length; i++){
			comandasPanel[i] = new JPanel();
			comandasPanel[i].setLayout(new FlowLayout());
			comandasPanel[i].setBorder(title);
			
		}
		JPanel panelMesas = new JPanel();
		panelMesas.setLayout(new FlowLayout());
		//this.restController.requestMesas();
		//this.restController.pedirMesas();

		for (int i=0; i<mesas.length; i++){
			//el numero de mesa siempre es el mismo que el indice
			final int j= mesas[i].getNumeroMesa();//para que pueda ser utilizado por el listener

			JButton mesa = new JButton("Mesa " + mesas[i].getNumeroMesa());
			mesa.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					numMesa = j;
					title.setTitle("Mesa " + j);
					comandas = restController.getMesa(j).getListaComandas();
					if (comandas != null)setComandasPanel(j);
					comandasLayout.show(comandasPanel[j], "Mesa " + j);
				}
				
			});
			panelMesas.add(mesa);
		}
		
		this.add(panelMesas);
		this.add(comandasContainer);
		
		JFrame frame = new JFrame("Reservas");

		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
		frame.pack();
		
	}
	
	public void setComandasPanel(int numeroMesa){
		TitledBorder title = new TitledBorder("Mesa " + numMesa);
		comandasPanel[numeroMesa].setBorder(title);
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
			comandasPanel[numMesa].add(comandaMesa);
		}
		comandasContainer.add(comandasPanel[numeroMesa], "Mesa"+numeroMesa);
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
				if (comandaSelected != -1 && numMesa != -1){
					new RealizarPedido(restController, numMesa, comandaSelected);
				}
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
	
	
	private JPanel comandasContainer;
	
	private GUIController restController;
	private MesaInfo[] mesas;
	private ComandaInfo[] comandas;
	private JPanel[] comandasPanel;
	int comandaSelected = -1;
	private int numMesa=-1;
}
