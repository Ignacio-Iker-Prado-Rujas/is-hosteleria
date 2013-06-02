package is.gui;

import is.Fecha;
import is.restaurante.LibroReservaObserver;
import is.restaurante.Reserva;
import is.restaurante.ReservaInfo;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
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
		this.controlador.addLibroReservaObserver(this);
		inicializaTabla();
		
		JTable tTodas = new JTable(tablaTodas);
		JScrollPane scrollTodas = new JScrollPane(tTodas);
		JTable tHoy = new JTable(tablaHoy);
		JScrollPane scrollHoy = new JScrollPane(tHoy);
		JTable tSemana = new JTable(tablaSemana);
		JScrollPane scrollSemana = new JScrollPane(tSemana);
		JTable tMes = new JTable(tablaMes);
		JScrollPane scrollMes = new JScrollPane(tMes);
		
		JTabbedPane tabbedPane = new JTabbedPane();

//		carga los datos en las tablas
		this.tablaTodas.actualizarTabla(this.controlador.getReservas(-1));
		this.tablaHoy.actualizarTabla(this.controlador.getReservas(0));
		this.tablaSemana.actualizarTabla(this.controlador.getReservas(1));
		this.tablaMes.actualizarTabla(this.controlador.getReservas(2));
		
//		añade las tablas a las pestañas
		tabbedPane.addTab("Todas", null, scrollTodas, "Muestra todas las reservas");
		tabbedPane.addTab("Hoy", null, scrollHoy, "Muestra las reservas de hoy");
		tabbedPane.addTab("Esta semana",null, scrollSemana,
		                  "Muestra las reservas de esta semana");
		tabbedPane.addTab("Este mes", null, scrollMes,
		                      "Muestra las reservas de este mes");
		//panelTodas.add(tTodas);
		/*for ( ReservaInfo r : controlador.getReservas(-1)){
			JTextArea jt = new JTextArea(r.toString());			
			panelTodas.add(jt);
		}*/
		
		//JPanel panelHoy = new JPanel();
		
		//panelHoy.add(tHoy);
		/*for ( ReservaInfo r : controlador.getReservas(0)){
			JTextArea jt = new JTextArea(r.toString());			
			panelHoy.add(jt);
		}*/
		
		//JPanel panelSemana = new JPanel();
	
		//panelSemana.add(tSemana);
		/*for ( ReservaInfo r : controlador.getReservas(1)){
			JTextArea jt = new JTextArea(r.toString());			
			panelSemana.add(jt);
		}*/
		
		//JPanel panelMes = new JPanel();
		//panelMes.setPreferredSize(new Dimension(410, 50));
		
		//panelMes.add(tMes);
		/*for ( ReservaInfo r : controlador.getReservas(2)){
			JTextArea jt = new JTextArea(r.toString());			
			panelMes.add(jt);
		}*/
		JPanel opciones = new JPanel(new GridLayout());
		
		JButton anyadir = new JButton("add");
		anyadir.addActionListener(new ActionListener(){				
			@Override
			public void actionPerformed(ActionEvent e) {
				//anyadirNuevoPlato();					
			}
		});
		JButton editar = new JButton("edit");
		editar.addActionListener(new ActionListener(){				
			@Override
			public void actionPerformed(ActionEvent e) {
				//editarPlato();					
			}
		});
		JButton borrar = new JButton("remove");
		borrar.addActionListener(new ActionListener(){				
			@Override
			public void actionPerformed(ActionEvent e) {
				borrarReserva();					
			}
		});
		opciones.add(anyadir);
		opciones.add(editar);
		opciones.add(borrar);

		
		JFrame ventana = new JFrame();
		ventana.add(tabbedPane);
		ventana.add(opciones, BorderLayout.SOUTH);
		ventana.setSize(500, 300);
		ventana.setVisible(true);
	}
	
//	borra la reserva seleccionada
	private void borrarReserva(){
		
	}
	
	private void inicializaTabla(){
		tablaTodas = new TableReservas();
		tablaHoy = new TableReservas();
		tablaSemana = new TableReservas();
		tablaMes = new TableReservas();
	}
	private GUIController controlador;
	private JTextField nombreReserva;
	
	@Override
	public void cambioOcurrido(ReservaInfo[] reservas) {
		// TODO Auto-generated method stub
		
	}
	TableReservas tablaTodas;
	TableReservas tablaHoy;
	TableReservas tablaSemana;
	TableReservas tablaMes;
}
