package is.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GenerarFactura {

	@SuppressWarnings("serial")
	public GenerarFactura(GUIController rest) {
		this.controlador = rest;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		panel.add( new JLabel("Introduzca el numero de mesa"));
		numMesa = new JTextField();
		panel.add(numMesa);
		panel.add(new JButton("Generar Factura"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						numMesa.getText();
					//TODO duda del mvc, aqui hay que llamar al modelo y que te devuelva la mesa?
						
						controlador.getMesa(numMesa.getText());
						
					}
					
				});
			}
		});
		JFrame marco = new JFrame();
		marco.add(panel);
		marco.setSize(200,200);
		marco.setVisible(true);
	
	}
	private GUIController controlador;
	private JTextField numMesa;
}
