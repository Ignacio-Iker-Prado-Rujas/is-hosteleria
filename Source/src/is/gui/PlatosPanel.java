package is.gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;



/**
 * Panel con todos los platos disponibles al realizar un pedido, son platos de un determinado tipo
 * @author JaimeDan
 *
 */
@SuppressWarnings("serial")
public class PlatosPanel extends JPanel{

	public PlatosPanel(){
		this.setLayout(new GridLayout(4, 11));
		
	}
	
	private ArrayList<CeldaPlato> platos;
	//hashtable de celdaPlatos, parecido al citypanel de pr4 y 5 private 
}
