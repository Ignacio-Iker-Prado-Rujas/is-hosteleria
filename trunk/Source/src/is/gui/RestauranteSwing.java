package is.gui;

import is.restaurante.Restaurante;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class RestauranteSwing extends JPanel{

	@SuppressWarnings("serial")
	public RestauranteSwing(){
		super();
		this.setLayout(new GridLayout(3,3));
		botones = new JButton[9];
		
		this.add(new JButton("Realizar reserva"));
		this.add(new JButton("Generar/modificar pedido"));
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
						//no se por que cojones no funciona: marco.setDefaultCloseOperation(EXIT_ON_CLOSE);
						marco.add(fotoMesas);
						marco.setSize(620, 475);

					}

				});

			}

		};
	//	this.add(new JButton("Distribución mesas"));
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
	private Restaurante restaurante;
}
