package is.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import is.restaurante.consumicion.Consumicion;
/**
 * Celda que tiene un plato, y un JSpinner con el número de veces que ha sido elegido
 * @author JaimeDan
 *
 */
@SuppressWarnings("serial")
public class CeldaPlato extends JPanel{

	public CeldaPlato(Consumicion plato){
		this.veces = 0;
		this.plato = plato;
		this.botonPlato = new JButton(plato.getNombre());
		this.flechitas = new JSpinner();
		this.flechitas.setValue(0);
		this.flechitas.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				veces = (int) flechitas.getValue();
			}
			
		});
		this.setLayout(new FlowLayout());
		this.add(botonPlato);
		this.add(flechitas);
	}
	
	public int getVeces(){
		return this.veces;
	}
	
	private int veces;
	private JButton botonPlato;
	private Consumicion plato;
	private JSpinner flechitas;
}
