package is.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")


public class RestauranteSwing extends JPanel{

	
	public RestauranteSwing(){	
		super();
		initializeGUI();
	}
	public RestauranteSwing(GUIController controlador){
		super();
		this.rest = controlador;
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

		botones[1] = new JButton("Generar/modificar comanda"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						//new RealizarPedido(rest);
						new VistaMesas(rest);
					}
				});
			}
		};
		
		botones[2] = new JButton	("Ver/anular reserva") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new VerReserva(rest);
					}

				});

			}

		};
		
		botones[3] = new JButton	("Anular pedido") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

					}

				});

			}

		};
		
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
		
		botones[5] = new JButton	("Generar factura") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
							new GenerarFactura(rest);

					}

				});

			}

		};
		
		botones[6] = new JButton	("Cantidad existencias") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new CantidadExistencias(rest);

					}

				});

			}

		};
		
		botones[7] = new JButton	("Ver/modificar menú") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new VerMenu(rest);

					}

				});

			}

		};
		
		botones[8] = new JButton	("Notificar incidencias") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new NotificarIncidencias(rest);

					}

				});

			}

		};
		for(JButton b : botones) this.add(b);
	//	this.add(new JButton("Ver/modificar menú"));
	//	this.add(new JButton("Notificar incidencias"));
		
		
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
	private GUIController rest;	
}
