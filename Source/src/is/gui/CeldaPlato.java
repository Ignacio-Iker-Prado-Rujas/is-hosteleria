package is.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import is.restaurante.consumicion.Consumicion;
/**
 * Celda que tiene un plato, y un JSpinner con el número de veces que ha sido elegido
 * @author JaimeDan
 *TODO PONER COMENTARIOS MAS DETALLADOS
 */
@SuppressWarnings("serial")
public class CeldaPlato extends JPanel{

	public CeldaPlato(GUIController controller, Consumicion plato, int numMesa, int numComanda){
		this.restControl = controller;
		this.veces = 0;
		this.plato = plato;
		this.botonPlato = new JButton(plato.getNombre()){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						incrementaVeces();
						restControl.requestNewConsumption(numComanda, numMesa);
					}
					
				});
			}
		};
		this.flechitas = new JSpinner();
		this.flechitas.setValue(0);
		this.flechitas.addChangeListener(new ChangeListener() {

			//TODO cada vez que se añade un plato, habrá que añadirlo a la lista de pedidos
			//asi que hay que registrar como observador la parte derecha de realizar pedido, que es la lista final con todas las cosas
			@Override
			public void stateChanged(ChangeEvent e) {
				veces = (int) flechitas.getValue();
			}
			
		});
		this.setLayout(new FlowLayout());
		this.add(botonPlato);
		this.add(flechitas);
		
	}
	
	public void incrementaVeces(){
		//int numero = (int) this.flechitas.getValue();
		//numero++;
		this.veces++;
		this.flechitas.setValue(this.veces);
		//this.veces = numero;
	}
	
	public int getVeces(){
		return this.veces;
	}
	private GUIController restControl;
	private int veces;
	private JButton botonPlato;
	private Consumicion plato;
	private JSpinner flechitas;
	
	private int numComanda;
	private int numMesa;
}
