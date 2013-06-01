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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



@SuppressWarnings("serial")
public class RealizarPedido extends JPanel implements ComandaObserver{

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
		/*
		 * Inicialización de los paneles que tendrán información de las consumiciones que se pueden pedir
		 * 	y cuantas consumiciones se han pedido de cada tipo 
		 */
		inicializaPaneles();
		this.setLayout(new BorderLayout());
		JPanel tipoPlato = new JPanel();
		panelCentral = new JPanel();
		final CardLayout menu = new CardLayout();
		panelCentral.setLayout(menu);
		for (Integer i=0; i<4; i++)
			panelCentral.add(this.elementosMenu[i], i.toString());
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
		frame = new JFrame("Realizar Pedido");
		this.add(panelCentral);
		
        String[] nombresMesa = { "Mesa 1: 2 personas", "Mesa 2: 4 personas", "Mesa 3: 4 personas", "Mesa 4: 6 personas", "Mesa 5: 8 personas" };
        
        //Create the combo box, select the item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        mesas = new JComboBox(nombresMesa);
		this.add(mesas, BorderLayout.SOUTH);
		this.add(new JButton("Realizar Pedido"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
					//	restaurante.communicatePedido(año, mes, dia, hora, minutos, cliente, numeroComensales);
						//elementosMenu[1].
					}
					
				});
			}
		}, BorderLayout.LINE_END);
		TitledBorder titled = new TitledBorder("Pedido");
		text = new JTextArea("");
		text.setEditable(false);
		//ejemplo de como meter imagenes
				
		scroller = new JScrollPane(text);
        scroller.setPreferredSize(new Dimension(100,100));
        scroller.setBorder(titled);
        
        this.add(scroller, BorderLayout.EAST);
		
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
		frame.pack();

	}
	

	
	public void inicializaPaneles(){
		elementosMenu = new JPanel[4];
		elementosMenu[0] = new JPanel();
		for (Consumicion c : this.restaurante.requestBebidas()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[0].add(plato);
		}
		elementosMenu[1] = new JPanel();
		for (Consumicion c : this.restaurante.requestPrimeros()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[1].add(plato);
		}
		elementosMenu[2] = new JPanel();
		for (Consumicion c : this.restaurante.requestSegundos()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[2].add(plato);
		}
		elementosMenu[3] = new JPanel();
		for (Consumicion c : this.restaurante.requestPostres()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[3].add(plato);
		}
	}
	
	@Override
	public void comandaHaCambiado(String comanda) {
		this.text.setText(comanda);
	}
	
	private JFrame frame;
	private JPanel panelCentral;
	private PlatosPanel platosPanel;
	private JScrollPane scroller;
	private JTextArea text;
	private GUIController restaurante;
	private JComboBox mesas;
	private JPanel[] elementosMenu;

	

	
}
