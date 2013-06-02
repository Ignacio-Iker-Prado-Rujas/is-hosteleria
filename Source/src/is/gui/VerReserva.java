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
 *Muestra cuatro pestañas con las reservas de hoy, dentro de una semana, dentro de un mes y todas las reservas.
 * @author JaimeDan
 */

public class VerReserva implements LibroReservaObserver{

	@SuppressWarnings("serial")
	public VerReserva(GUIController rest) {
		this.controlador = rest;
		
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
	public void cambioOcurrido(ReservaInfo[] reservas) {
		// TODO Auto-generated method stub
		
	}
}
