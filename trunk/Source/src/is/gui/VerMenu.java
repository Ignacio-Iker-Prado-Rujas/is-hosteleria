package is.gui;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import is.restaurante.Menu;
import is.restaurante.TipoPlatos;
import is.restaurante.consumicion.Consumicion;

@SuppressWarnings("serial")
public class VerMenu extends JFrame{
	public VerMenu(GUIController controller){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,500);
		JFrame.setDefaultLookAndFeelDecorated(true);
	    JDialog.setDefaultLookAndFeelDecorated(true);
	    try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		this.controlador = controller;
		menu = controlador.getMenu();
		JTabbedPane pestanyas = new JTabbedPane();
		this.add(pestanyas);
		TipoPlatos[] tipoPlatos = TipoPlatos.values();
		
		for( TipoPlatos tPlato : tipoPlatos){
			
			JPanel panel = new JPanel(new BorderLayout());		
			pestanyas.add(tPlato.toString(), panel);
			
			JPanel opciones = new JPanel(new GridLayout());
			panel.add(opciones, BorderLayout.SOUTH);
			JButton anyadir = new JButton("add");
			JButton editar = new JButton("edit");
			JButton borrar = new JButton("remove");
			opciones.add(anyadir);
			opciones.add(editar);
			opciones.add(borrar);
			
			JPanel platos = new JPanel(new GridLayout());
			panel.add(platos);
			
			ArrayList<Consumicion> consum = menu.getPlatos(tPlato);
			for( Consumicion cons: consum){
				JToggleButton boton = new JToggleButton(cons.getNombre());
				platos.add(boton);	
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
