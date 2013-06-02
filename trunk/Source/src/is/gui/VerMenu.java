package is.gui;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

import is.restaurante.Menu;
import is.restaurante.TipoPlatos;
import is.restaurante.consumicion.Consumicion;

@SuppressWarnings("serial")
// MenuObserver
public class VerMenu extends JFrame{
	public VerMenu(GUIController controller){
		inicializarVerMenu();
		this.controlador = controller;
		menu = controlador.getMenu();
		inicializarVentana();
		
		TipoPlatos[] tipoPlatos = TipoPlatos.values();
		for( TipoPlatos tPlato : tipoPlatos){
			nuevoTipoPlato(tPlato);	
		}
		this.setVisible(true);
	}
	//Crea la pestaña para un tipo de plato
	private void nuevoTipoPlato(TipoPlatos tPlato){
		JPanel panel = new JPanel(new BorderLayout());		
		pestanyas.add(tPlato.toString(), panel);
		cadaPestanya.add(panel);
		
		JPanel opciones = new JPanel(new GridLayout());
		panel.add(opciones, BorderLayout.SOUTH);
		JButton anyadir = new JButton("add");
		anyadir.addActionListener(new ActionListener(){				
			@Override
			public void actionPerformed(ActionEvent e) {
				anyadirNuevoPlato();					
			}
		});
		JButton editar = new JButton("edit");
		editar.addActionListener(new ActionListener(){				
			@Override
			public void actionPerformed(ActionEvent e) {
				editarPlato();					
			}
		});
		JButton borrar = new JButton("remove");
		borrar.addActionListener(new ActionListener(){				
			@Override
			public void actionPerformed(ActionEvent e) {
				borrarPlato();					
			}
		});
		opciones.add(anyadir);
		opciones.add(editar);
		opciones.add(borrar);
		
		
		/**** Añade los platos correspondientes a un tipo de Plato	****/
		
		JPanel platos = new JPanel(new FlowLayout());
		panel.add(platos);
		ventanas.add(platos);
		
		ArrayList<Consumicion> consum = menu.getPlatos(tPlato);
		for( Consumicion cons: consum){
			/*	Habría que guardar las descripciones tb para mostrarlas	*/
			JToggleButton boton = new JToggleButton(cons.getNombre());
			botones.add(boton);
			platos.add(boton);
			boton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					consumicionPulsada();				
				}
				
			});
		}
	}
	private void inicializarVentana(){
		
		panelGeneral = new JPanel();//Creamos el panel principal
		cardLayout = new CardLayout();
		panelGeneral.setLayout(cardLayout);
		
		pestanyas = new JTabbedPane();

		panelGeneral.add(pestanyas, "pestanyas");
		this.add(panelGeneral);
	}
	// 	Inicializa la ventana
	private void inicializarVerMenu(){
		this.setSize(400,500);
		JFrame.setDefaultLookAndFeelDecorated(true);
	    JDialog.setDefaultLookAndFeelDecorated(true);
	    try {
	    	UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			//.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		this.botones = new ArrayList<JToggleButton>();
		ventanas = new ArrayList<JPanel>();
		cadaPestanya = new ArrayList<JPanel>();
	}
	/*	Elimina el plato seleccionado	*/
	private void borrarPlato(){
		if(this.consumicionSeleccionada!=null)
			System.out.println(consumicionSeleccionada.getText() + " deberia ser borrada");
		else System.out.println(" se debe seleccionar algo");
	}
	
	/*	Edita el Plato que esté seleccionado	*/
	private void editarPlato(){
		if(this.consumicionSeleccionada!=null){
			//System.out.println(consumicionSeleccionada.getText() + " debe ser editado");
			ConsumicionSwing nuevaCons = new ConsumicionSwing(this, controlador, menu.getConsumicion(consumicionSeleccionada.getText()), true);
			panelGeneral.add(nuevaCons , "editConsumicion");
			cardLayout.show(panelGeneral, "editConsumicion");
		}
	}
	
	/*	 Añade un nuevo plato al menu	*/
	private void anyadirNuevoPlato(){
		ConsumicionSwing nuevaCons = new ConsumicionSwing(this, controlador, null, false);
		panelGeneral.add(nuevaCons , "createConsumicion");
		cardLayout.show(panelGeneral, "createConsumicion");
	}
	
	/*	Libera todos los botones excepto el último pulsado, 
	 * y guarda el plato pulsado	*/
	
	private void consumicionPulsada(){
		for( JToggleButton boton: botones)
			if(!boton.isFocusOwner())	//
				boton.setSelected(false);
			else{
				consumicionSeleccionada = boton;
				mostrarDescripcion(boton.getText());
			}
	}
	/*	Muestra la descripción de la consumición dada */
	private void mostrarDescripcion(String description){
		pestanyas.getTitleAt(pestanyas.getSelectedIndex());
		/*	Hay que añadir un textArea en el medio
		 * para mostrar la descripcion.
		 */
		
	}
	
	/*	Borra de la vista el plato indicado	*/
	public void borrarPlato(String nombre){
		
	}

	public void devolverControlPrincipal(){
		cardLayout.show(panelGeneral, "pestanyas");
	}

	
	private ArrayList<JPanel> cadaPestanya;
	private JTabbedPane pestanyas;
	private CardLayout cardLayout;
	private JPanel panelGeneral;
	private ArrayList<JPanel> ventanas;
	private JToggleButton consumicionSeleccionada;
	private ArrayList<JToggleButton> botones;
	private GUIController controlador;
	private Menu menu;
}
