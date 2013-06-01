package is.gui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
		this.setSize(400,500);
		JFrame.setDefaultLookAndFeelDecorated(true);
	    JDialog.setDefaultLookAndFeelDecorated(true);
	    try {
	    	UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");


			//.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		this.controlador = controller;
		
		this.botones = new ArrayList<JToggleButton>();
		
		menu = controlador.getMenu();
		
		JTabbedPane pestanyas = new JTabbedPane();
		this.add(pestanyas);
		TipoPlatos[] tipoPlatos = TipoPlatos.values();
		
		for( TipoPlatos tPlato : tipoPlatos){
			
			JPanel panel = new JPanel(new BorderLayout());		
			pestanyas.add(tPlato.toString(), panel);
			JPanel opciones = new JPanel(new GridLayout());
			panel.add(opciones, BorderLayout.SOUTH);
			JButton anyadir = new JButton("add",new ImageIcon(this.getClass().getResource("images/flecha.png")));
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
			
			JPanel platos = new JPanel(new FlowLayout());
			panel.add(platos);
			
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
	
	/*	Elimina el plato seleccionado	*/
	private void borrarPlato(){
		if(this.consumicionSeleccionada!=null)
			System.out.println(consumicionSeleccionada.getText() + " deberia ser borrada");
		else System.out.println(" se debe seleccionar algo");
	}
	
	/*	Edita el Plato que esté seleccionado	*/
	private void editarPlato(){
		if(this.consumicionSeleccionada!=null)
			System.out.println(consumicionSeleccionada.getText() + " debe ser editado");
		else System.out.println(" se debe seleccionar algo");
	}
	
	/*	 Añade un nuevo plato al menu	*/
	private void anyadirNuevoPlato(){
		
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
		/*	Hay que añadir un textArea en el medio
		 * para mostrar la descripcion.
		 */
		
	}
	
	/*	Borra de la vista el plato indicado	*/
	public void borrarPlato(String nombre){
		
	}
	private void createConsumicion(){
		
		
	}
	public void anyadePlato(String name, TipoPlatos tPlato){
		/*Para esto hay que guardar atributos del constructor	*/
		createConsumicion();
	}
	
	/* Actualiza un plato	*/
	public void actualizarPlato(){
		
	}
	
	
	private JToggleButton consumicionSeleccionada;
	private ArrayList<JToggleButton> botones;
	private GUIController controlador;
	private Menu menu;
}
