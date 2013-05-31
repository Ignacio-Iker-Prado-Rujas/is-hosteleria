package is.gui;

import is.restaurante.Restaurante;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tp.pr5.gui.GUIController;

@SuppressWarnings("serial")


public class RestauranteSwing extends JPanel{

	
	public RestauranteSwing(){	
		super();
	//	this.restaurante = new Restaurante();
		initializeGUI();
	}
	public RestauranteSwing(Restaurante rest){
		super();
	//	this.restaurante = rest;
		initializeGUI();
	}
	
	public void initializeGUI(){
	this.setLayout(new GridLayout(3,3, 3, 15));	
	botones = new JButton[9];
		
		botones[0] = new JButton("Realizar reserva"){
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new RealizarReserva(rest);
					}
					
				});
			}
		};
		this.add(botones[0]);
		botones[1] = new JButton("Generar/modificar pedido"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						new RealizarPedido(rest);
						
					}
				});
			}
		};
		this.add(botones[1]);
		this.add(new JButton("Ver/anular reserva"));
		this.add(new JButton("Anular pedido"));
		
		botones[4] = new JButton	("Distribución mesas") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ImageIcon mesas = createImageIcon("images/mesas.png", "mesas");
						JLabel fotoMesas = new JLabel(mesas);
						JFrame marco = new JFrame();
						marco.setVisible(true);
						marco.add(fotoMesas);
						marco.setSize(620, 475);

					}

				});

			}

		};
		this.add(botones[4]);
		this.add(new JButton("Generar factura"));
		this.add(new JButton("Cantidad existencias"));
		this.add(new JButton("Ver/modificar menú"));
		this.add(new JButton("Notificar incidencias"));
		
		
	}
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	private JButton[] botones;
	//private Restaurante restaurante;
	private GUIController rest;	
}
