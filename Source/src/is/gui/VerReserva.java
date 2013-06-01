package is.gui;

import is.restaurante.Reserva;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *TODO en esta clase se muestran tres pestañas con las reservas de hoy, dentro de una semana y siempre
 * TODO koh, creo que esta clase debería mostrar las reservas de hoy, de la semana y de siempre, mira las pestañas que hizo kike en  ver menu
 * @author JaimeDan
 *
 */
public class VerReserva {

	@SuppressWarnings("serial")
	public VerReserva(GUIController rest) {
		this.controlador = rest;
		JPanel panel = new JPanel();
		JLabel nombre = new JLabel("Introduzca su nombre");
		nombreReserva = new JTextField();
		panel.setLayout(new GridLayout (3,1));
		panel.add(nombre);
		panel.add(nombreReserva);

		
		panel.add(new JButton("Buscar"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						List<Integer> listaReservas = controlador.reservasDeUnCliente(nombreReserva.getText());
						for (Integer r : listaReservas) r.crearPanel(); 
						// TODO AYUDA!! haciendo eso te cargas el mvc pero si no lo hacer tienes que crear mil getters y setters	*/					
					}
					
				});
			}
		});
		
		
		JFrame marco = new JFrame();
		marco.add(panel);
		marco.setVisible(true);
		marco.setSize(150, 150);
	}

	
	private GUIController controlador;
	private JTextField nombreReserva;
}
