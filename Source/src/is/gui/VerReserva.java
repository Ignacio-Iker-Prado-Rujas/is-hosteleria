package is.gui;

import is.Fecha;
import is.restaurante.LibroReservaObserver;
import is.restaurante.Reserva;
import is.restaurante.ReservaInfo;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *TODO en esta clase se muestran tres pestañas con las reservas de hoy, dentro de una semana y siempre
 * TODO koh, creo que esta clase debería mostrar las reservas de hoy, de la semana y de siempre, mira las pestañas que hizo kike en  ver menu
 * @author JaimeDan
 *
 */
public class VerReserva implements LibroReservaObserver{

	@SuppressWarnings("serial")
	public VerReserva(GUIController rest) {
		this.controlador = rest;
		/*JPanel panel = new JPanel();
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
						
						// TODO AYUDA!! haciendo eso te cargas el mvc pero si no lo hacer tienes que crear mil getters y setters						
					}
					
				});
			}
		}); */
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel panelTodas = new JPanel();
		tabbedPane.addTab("Todas", null, panelTodas, "Muestra todas las reservas");
		
		for ( ReservaInfo r : controlador.getReservas(-1)){
			JTextArea jt = new JTextArea(r.toString());			
			panelTodas.add(jt);
		}
		
		JPanel panelHoy = new JPanel();
		tabbedPane.addTab("Hoy", null, panelHoy, "Muestra las reservas de hoy");
		for ( ReservaInfo r : controlador.getReservas(0)){
			JTextArea jt = new JTextArea(r.toString());			
			panelHoy.add(jt);
		}
		
		JPanel panelSemana = new JPanel();
		tabbedPane.addTab("Esta semana",null, panelSemana,
		                  "Muestra las reservas de esta semana");
		for ( ReservaInfo r : controlador.getReservas(1)){
			JTextArea jt = new JTextArea(r.toString());			
			panelSemana.add(jt);
		}
		
		JPanel panelMes = new JPanel();
		panelMes.setPreferredSize(new Dimension(410, 50));
		tabbedPane.addTab("Este mes", null, panelMes,
		                      "Muestra las reservas de este mes");
		for ( ReservaInfo r : controlador.getReservas(2)){
			JTextArea jt = new JTextArea(r.toString());			
			panelMes.add(jt);
		}
		JFrame marco = new JFrame();
		
		marco.add(tabbedPane);
		marco.setVisible(true);
		marco.setSize(150, 150);
	}

	
	private GUIController controlador;
	private JTextField nombreReserva;
	@Override
	public void cambioOcurrido() {
		// TODO Auto-generated method stub
		
	}
}
