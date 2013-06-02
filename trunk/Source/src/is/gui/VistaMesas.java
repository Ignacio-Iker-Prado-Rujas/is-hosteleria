package is.gui;

import is.restaurante.Comanda;
import is.restaurante.ComandaInfo;
import is.restaurante.MesaInfo;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
/**
 * TODO por alguna extraña razón al cambiar de mesa no se ponen los botones de editar y esas cosas
 * @author JaimeDan
 *
 */
public class VistaMesas extends JPanel{

	
	public VistaMesas(final GUIController controller){
		this.restController = controller;
		this.mesas = this.restController.requestMesas();
		this.setLayout(new BorderLayout());
		comandasPanel = new JPanel[mesas.length];
		comandasContainer = new JPanel();
		final CardLayout comandasLayout = new CardLayout();
		comandasContainer.setLayout(comandasLayout);
		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(comandasLayout);
		
	     
		
		final TitledBorder title = new TitledBorder("hola");
		for (int j=0; j<mesas.length; j++){
			comandasPanel[j] = new JPanel();
			setComandasPanel(j);
			
		}
			//comandas = restController.getMesa(j).getListaComandas();				 
		
		/*for (int i=0; i< mesas.length; i++){
			comandasPanel[i] = new JPanel();
			comandasPanel[i].setLayout(new FlowLayout());
			comandasPanel[i].setBorder(title);
			
		}*/
		for (Integer i = 0; i < mesas.length; i++)
			comandasContainer.add(comandasPanel[i], i.toString());
		
		JPanel panelMesas = new JPanel();
		panelMesas.setLayout(new FlowLayout());
		//this.restController.requestMesas();
		//this.restController.pedirMesas();

		for (int i=0; i<mesas.length; i++){
			//el numero de mesa siempre es el mismo que el indice
			final Integer j= mesas[i].getNumeroMesa();//para que pueda ser utilizado por el listener

			JButton mesa = new JButton("Mesa " + mesas[i].getNumeroMesa());
			mesa.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					numMesa = j;
					int k = j;
					title.setTitle("Mesa " + j);
					/*
					  Comanda[] comandas = new Comanda[controller.getMesa(j).getListaComandas().length];
					 
					for (int i = 0; i< comandas.length; i++)
					*/
					//comandas = restController.getMesa(j).getListaComandas();
					
				 	//setComandasPanel(j);
					//comandasPanel[j].add(new JLabel("Bubidibu"), BorderLayout.SOUTH);
					comandasLayout.show(/*comandasPanel[j]*/comandasContainer, j.toString());
					
					
				}
				
			});
			panelMesas.add(mesa);
		}
		
		this.add(panelMesas, BorderLayout.NORTH);
		this.add(comandasContainer, BorderLayout.CENTER);
		
		JFrame frame = new JFrame("Comandas por mesa");

		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
		frame.pack();
		
	}
	
	public void setComandasPanel(Integer numeroMesa){
		TitledBorder title = new TitledBorder("Mesa " + numMesa);
		comandas = restController.getMesa(numeroMesa).getListaComandas();
		comandasPanel[numeroMesa].setBorder(title);
		comandasPanel[numeroMesa].setLayout(new BorderLayout());
		JPanel comanditasPanel = new JPanel();
		comanditasPanel.setLayout(new FlowLayout());
		if (comandas != null) {
			for (int i = 0; i < comandas.length; i++) {
				final int j = i;
				JButton comandaMesa = new JButton("Comanda " + i + 1);
				comandaMesa.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						comandaSelected = j;
						// restController.avisaComanda(numMesa,
						// comandaSelected);
					}

				});
				comanditasPanel.add(comandaMesa);
			}
			comandasPanel[numeroMesa].add(comanditasPanel, BorderLayout.CENTER);
		}
		
		
		JPanel botoncitosPanel = new JPanel();
		botoncitosPanel.setLayout(new FlowLayout());
		
		JButton editarComanda = new JButton("Editar");
		editarComanda.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		botoncitosPanel.add(editarComanda);
		
		JButton añadirComanda = new JButton("Añadir");
		añadirComanda.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comandaSelected != -1 && numMesa != -1){
					new RealizarPedido(restController, numMesa, comandaSelected);
				}
			}
			
		});
		botoncitosPanel.add(añadirComanda);
		
		JButton eliminarComanda = new JButton("Eliminar");
		eliminarComanda.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comandaSelected != -1 && numMesa != -1){
					restController.eliminarComanda(numMesa, comandaSelected);
				}
			}
			
		});
		botoncitosPanel.add(eliminarComanda);
		comandasPanel[numeroMesa].add(botoncitosPanel, BorderLayout.SOUTH);
		
		
		comandasContainer.add(comandasPanel[numeroMesa], numeroMesa.toString());
		
		//comandasContainer.add(editarComanda);
		//comandasContainer.add(añadirComanda);
		//comandasContainer.add(eliminarComanda);
	}//
	
	
	private JPanel comandasContainer;
	
	private GUIController restController;
	private MesaInfo[] mesas;
	private ComandaInfo[] comandas;
	private JPanel[] comandasPanel;
	int comandaSelected = -1;
	private int numMesa=-1;
}
