package is.gui;

import is.gui.spring.SpringUtilities;
import is.restaurante.TipoPlatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class ConsumicionSwing extends JPanel{

	public ConsumicionSwing(VerMenu ventana, GUIController controller, String name, boolean edit){
		
		this.campos = new JPanel();
		this.setLayout(new BorderLayout());
		
		anyadirControles();
		this.campos.setLayout(new SpringLayout());
		this.ventanaGeneral = ventana;
		this.restControl = controller;
		this.platoName = name;
		
		JLabel nombreL = new JLabel(" Nombre ");
		nombreL.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.campos.add(nombreL);
		if(edit)
			nombrePlato = new JTextField(name);
		else
			nombrePlato = new JTextField();

		nombrePlato.setMaximumSize(new Dimension(1, 1));
		this.campos.add(nombrePlato);
		
		JLabel descripcionL = new JLabel(" Descripción ");
		descripcionL.setBorder(BorderFactory.createLineBorder(Color.black));
		this.campos.add(descripcionL);
		if(edit)
			this.descripcion = new JTextArea("Aqui va la descipcion del plato");
		else
			this.descripcion = new JTextArea();
				
		this.campos.add(this.descripcion);
			
		
		JLabel precioL = new JLabel(" Precio ");
		precioL.setBorder(BorderFactory.createLineBorder(Color.black));
	
		this.campos.add(precioL);
		if(edit)
			this.precioField = new JTextField(" 2334 iuros");
		else
			this.precioField = new JTextField();
		
		precioField.setMaximumSize(new Dimension(1, 1));	
		this.campos.add(precioField);
		
		SpringUtilities.makeCompactGrid(campos, 3, 2, 6, 6, 10, 10);
		this.add(campos, BorderLayout.CENTER);
	}
	
	private void anyadirControles(){
		JButton done = new JButton("done");
		done.addActionListener(new ActionListener(){				
			@Override
			public void actionPerformed(ActionEvent e) {
				guardarPlato();					
			}
		});
		JButton cancel = new JButton("cancel");
		cancel.addActionListener(new ActionListener(){				
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaGeneral.devolverControlPrincipal();					
			}
		});
		JPanel controles = new JPanel();
		controles.setLayout(new GridLayout());
		controles.add(done);
		controles.add(cancel);
		this.add(controles, BorderLayout.SOUTH);
		
	}
	private void guardarPlato(){
		/*Esta funcion actualiza en el menu el plato cambiado
		 * le pasa el antiguo y el nuevo
		 */
		//restControl.actualizarConsumicion()
	}
	
	private JPanel campos;
	private String platoName;
	private int precio;
	private JTextField precioField;
	private GUIController restControl;
	private JTextField nombrePlato;
	private JTextArea descripcion;
	private VerMenu ventanaGeneral;
	
}