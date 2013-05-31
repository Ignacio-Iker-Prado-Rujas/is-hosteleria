package is.gui;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;

import is.restaurante.Menu;
import is.restaurante.TipoPlatos;
import is.restaurante.consumicion.Consumicion;

@SuppressWarnings("serial")
public class VerMenu extends JFrame{
	public VerMenu(GUIController controller){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,500);
		
		this.controlador = controller;
		menu = controlador.getMenu();
		JTabbedPane pestanyas = new JTabbedPane();
		this.add(pestanyas);
		TipoPlatos[] tipoPlatos = TipoPlatos.values();
		
		for( TipoPlatos tPlato : tipoPlatos){
			JPanel panel = new JPanel();	
			pestanyas.add(tPlato.toString(), panel);
			
			ArrayList<Consumicion> consum = menu.getPlatos(tPlato);
			for( Consumicion cons: consum){
				JToggleButton boton = new JToggleButton(cons.getNombre());
				panel.add(boton);	
			}
			
		}
		
		/*menu.getBebidas();
		JPanel panel = new JPanel();
	//	panel.setLayout()
		elementosMenu = new JPanel[4];
		elementosMenu[0] = new JPanel();
		for (Consumicion c : menu.getBebidas()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[0].add(plato);
		}
		elementosMenu[1] = new JPanel();
		for (Consumicion c : menu.getPrimeros()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[1].add(plato);
		}
		elementosMenu[2] = new JPanel();
		for (Consumicion c : menu.getSegundos()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[2].add(plato);
		}
		elementosMenu[3] = new JPanel();
		for (Consumicion c : menu.getPostres()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[3].add(plato);
		}
		for (JPanel p : elementosMenu) panel.add(p);
		this.add(panel);*/
		this.setVisible(true);
		//JFrame marco = new JFrame();
		//marco.add(panel);
	}
	
	private GUIController controlador;
	private Menu menu;
	private JPanel[] elementosMenu;
}
