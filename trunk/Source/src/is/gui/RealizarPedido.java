package is.gui;

import is.restaurante.ComandaObserver;
import is.restaurante.Menu;
import is.restaurante.Restaurante;
import is.restaurante.consumicion.Consumicion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;



@SuppressWarnings("serial")
public class RealizarPedido extends JPanel implements ComandaObserver, ItemListener{

	public RealizarPedido(final GUIController rest) {
		this.restaurante = rest;
/*
 * public VerMenu(GUIController controller){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,500);
		
		this.controlador = controller;
		menu = controlador.getMenu();
		menu.getBebidas();
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
		this.add(panel);
		this.setVisible(true);
		//JFrame marco = new JFrame();
		//marco.add(panel);
	}
	
	private GUIController controlador;
	private Menu menu;
	private JPanel[] elementosMenu;
}
 */
		inicializaPaneles();
		this.setLayout(new BorderLayout());
		JPanel tipoPlato = new JPanel();
		panelCentral = new JPanel();
		final CardLayout menu = new CardLayout();
		panelCentral.setLayout(menu);
		for (int i=0; i<4; i++)
			panelCentral.add(this.elementosMenu[i], i);
		tipoPlato.setLayout(new GridLayout(4,1));
		tipoPlato.add(new JButton("Bebidas"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						//panelCentral.add(new PlatosPanel(0, restaurante));
						//panelCentral.add(elementosMenu[0]);
						menu.show(panelCentral, "0");
						
					}
					
				});
			}
		});
		tipoPlato.add(new JButton("Primeros"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						//panelCentral.add(new PlatosPanel(1, restaurante));
						//panelCentral = (elementosMenu[1]);
						menu.show(panelCentral, "1");
						
					}
					
				});
			}
		});
		tipoPlato.add(new JButton("Segundos"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						//panelCentral.add(new PlatosPanel(2, restaurante));
						//panelCentral = (elementosMenu[2]);
						menu.show(panelCentral, "2");
						
					}
					
				});
			}
		});
		tipoPlato.add(new JButton("Postres"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						//panelCentral.add(new PlatosPanel(3, restaurante));
						//panelCentral = (elementosMenu[3]);
						menu.show(panelCentral, "3");
						
					}
					
				});
			}
		});
		
		this.add(tipoPlato, BorderLayout.WEST);
		JFrame frame = new JFrame("Realizar Pedido");
		this.add(panelCentral);
		/*
		 * TitledBorder titled = new TitledBorder("Log");
		text = new JTextArea("");
		text.setEditable(false);
		//ejemplo de como meter imagenes
		cityPanel = new CityPanel(text);
		this.add(cityPanel);
				
		scroller = new JScrollPane(text);
        scroller.setPreferredSize(new Dimension(100,100));
        scroller.setBorder(titled);
		 */
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
		frame.pack();

	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		CardLayout cl = (CardLayout)(panelCentral.getLayout());
		cl.show(panelCentral, (String)e.getItem());
	}

	
	public void inicializaPaneles(){
		elementosMenu = new JPanel[4];
		elementosMenu[0] = new JPanel();
		for (Consumicion c : this.restaurante.getBebidas()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[0].add(plato);
		}
		elementosMenu[1] = new JPanel();
		for (Consumicion c : this.restaurante.getPrimeros()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[1].add(plato);
		}
		elementosMenu[2] = new JPanel();
		for (Consumicion c : this.restaurante.getSegundos()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[2].add(plato);
		}
		elementosMenu[3] = new JPanel();
		for (Consumicion c : this.restaurante.getPostres()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[3].add(plato);
		}
	}
	
	@Override
	public void comandaHaCambiado() {
		// TODO Auto-generated method stub
		
	}
	

	private JPanel panelCentral;
	private PlatosPanel platosPanel;
	private JScrollPane scroller;
	private GUIController restaurante;
	
	private JPanel[] elementosMenu;

	

	
}
