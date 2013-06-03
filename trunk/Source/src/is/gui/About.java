package is.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class About extends JFrame {
	public About() {
				
		JLabel jt = new JLabel("Equipo de desarrollo: "+ LINE_SEPARATOR +
				"Jesús Aguirre Pemán" + LINE_SEPARATOR + 
				"Enrique Ballesteros Horcajo" + LINE_SEPARATOR + 
				"Jaime Dan Porras Rhee" + LINE_SEPARATOR + 
				"Iker Prado Rujas" + LINE_SEPARATOR + 
				"Alejandro Villarín Prieto" 
				
				);
		 	
		
//		jt.setEditable(false);
		this.add(jt);

		this.setSize(350, 220);
		this.setVisible(true);

	}
	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	private void notificar(String message) {
		JOptionPane.showMessageDialog(this, message);
		this.dispose();
	}


}
