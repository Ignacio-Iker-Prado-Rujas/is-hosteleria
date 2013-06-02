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
import is.restaurante.ComandaObserver;
import is.restaurante.TipoPlatos;
/**
 * Celda que tiene un plato, y un JSpinner con el número de veces que ha sido elegido.
 * Posteriormente se mostrará por pantalla al elegir el menú
 * @author JaimeDan
 */
@SuppressWarnings("serial")
public class CeldaPlato extends JPanel implements ComandaObserver{

	public CeldaPlato(GUIController controller, final Consumicion plato, final int numMesa, final int numComanda, final TipoPlatos tPlato){
		this.restControl = controller;
//		this.restControl.addComandaObserver(this, numMesa, numComanda);
		this.veces = 0;
		this.plato = plato;
		this.botonPlato = new JButton(plato.getNombre()){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						incrementaVeces();
						restControl.requestNewConsumption(numComanda, numMesa, plato, tPlato);
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
				if (veces < 0){
					flechitas.setValue(0);
					veces = 0;
				}
				restControl.requestNewConsumption(numComanda, numMesa, plato, tPlato, veces);
				
			}
			
		});
		this.setLayout(new FlowLayout());
		this.add(botonPlato);
		this.add(flechitas);
		
	}
	
	@Override
	public void comandaHaCambiado(String comanda) {
		
	}

	@Override
	public void setComandaNumber(int n) {
//		this.numComanda = n;
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
	@Override
	public void comandaError(String error) {
		// TODO Auto-generated method stub
		
	}
	
}
