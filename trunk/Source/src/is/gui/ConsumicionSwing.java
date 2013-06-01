package is.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class ConsumicionSwing extends JPanel{

	public ConsumicionSwing(GUIController controller, String name, boolean edit){
		this.restControl = controller;
		this.platoName = name;
		
		this.setLayout(new BorderLayout());
		
		JPanel nombre = new JPanel();
		nombre.setLayout(new FlowLayout());
		
			JLabel nombreL = new JLabel("Nombre");
			nombreL.setBorder(BorderFactory.createDashedBorder(Color.black));
			
			nombrePlato = new JTextField();
			
			nombre.add(nombreL);
			nombre.add(nombrePlato);
		this.add(nombre, BorderLayout.NORTH);
		
		JPanel descripcion = new JPanel();
			JLabel descripcionL = new JLabel("Descripción");
			nombreL.setBorder(BorderFactory.createDashedBorder(Color.black));
			
			this.descripcion = new JTextArea();
			
			descripcion.add(nombreL);
			descripcion.add(nombrePlato);
			
		JPanel precioP = new JPanel();
			JLabel precioL = new JLabel("Precio");
			nombreL.setBorder(BorderFactory.createDashedBorder(Color.black));
			
			this.precioField = new JTextField();
			
			precioP.add(precioL);
			precioP.add(precioField);
		
	}
	
	
	
	
	private String platoName;
	private int precio;
	private JTextField precioField;
	private GUIController restControl;
	private JTextField nombrePlato;
	private JTextArea descripcion;
	
}