package is.gui;

import is.restaurante.ComandaInfo;
import is.restaurante.Factura;
import is.restaurante.Mesa;
import is.restaurante.MesaInfo;
import is.restaurante.MesaObserver;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * Genera la factura de una mesa, sumando el coste de todas las comandas asociadas a esa mesa, y la muestra por pantalla.
 * @author Villarín
 */
public class GenerarFactura implements MesaObserver{

	@SuppressWarnings({ "serial", "unchecked" })
	public GenerarFactura(GUIController rest) {
		this.controlador = rest;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		panel.add( new JLabel("Introduzca el numero de mesa"));
		
		MesaInfo[] mesasRestaurante = controlador.requestMesas();
		
		String[] stringMesas = new String[mesasRestaurante.length];
		//	{ "Mesa", "Cat", "Dog", "Rabbit", "Pig" };
		for (int i = 0; i < stringMesas.length; i++)
			stringMesas[i] = "Mesa " + i;

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		mesas = new JComboBox(stringMesas);
		panel.add(mesas);
		panel.add(new JButton("Generar Factura"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int j = mesas.getSelectedIndex();
						controlador.getMesa(j).generarFactura();
						marco2 = new JFrame();
						marco2.setLayout(new GridLayout(2,1));
						marco2.add(new JLabel (controlador.getMesa(j).generarFactura()));
						marco2.add(new JButton("Aceptar"){
							{
								this.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent e) {
										marco2.setVisible(false);
									}
									
								});
							}
						});
						marco2.pack();
						marco2.setVisible(true);
					}
					
				});
			}
		});
		JFrame marco = new JFrame();
		marco.add(panel);
		marco.setSize(200,200);
		marco.setVisible(true);
	
	}
	@Override
	public void cambioOcurrido(ComandaInfo[] comandas) {
		// TODO Auto-generated method stub
		
	}
	private JComboBox mesas;
	private JFrame marco;
	private JFrame marco2;
	private Mesa mesa;
	private GUIController controlador;
	private JTextField numMesa;

}
