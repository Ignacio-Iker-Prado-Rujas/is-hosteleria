package is.gui;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class RealizarReserva extends JPanel{

	public RealizarReserva(){
		super();
		
		this.setLayout(new SpringLayout());
		JLabel dia = new JLabel("Día: ");
		JLabel hora = new JLabel("Hora: ");
		JLabel nombre = new JLabel ("Nombre: ");
		JLabel comensales = new JLabel ("Número de comensales");
	}
	
	private void inicializaBox(){
		for (int i=1; i<=31; i++){
			dia.addItem(i);
		}
		for (int i=1; i<=12; i++){
			mes.addItem(i);
		}
		
	}

	
	
	
	private JComboBox dia;
	private JComboBox mes;
	private JComboBox año;
	
	private JComboBox hora;
	private JComboBox minutos;
}
