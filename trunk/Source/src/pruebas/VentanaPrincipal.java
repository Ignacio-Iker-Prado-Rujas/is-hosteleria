package pruebas;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame
{
	VentanaPrincipal()
	{   
		setSize(400,400);
		setTitle("ventana principal");        
		setLayout(new BorderLayout());
		add(Box.createHorizontalStrut(100),BorderLayout.WEST);
		add(new JLabel("Ventana principal del proyecto "),BorderLayout.CENTER);       

		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void mostrar()
	{
		setVisible(true);
	}

}