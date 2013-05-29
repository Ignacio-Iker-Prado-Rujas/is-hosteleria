package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RestauranteSwing extends JPanel{

	public RestauranteSwing(){
		this.setLayout(new GridLayout());
		this.add(new JButton("Realizar reserva"));
		this.add(new JButton("Generar/modificar pedido"));
		this.add(new JButton("Ver/anular reserva"));
		this.add(new JButton("Anular pedido"));
		this.add(new JButton("Distribución mesas"));
		this.add(new JButton("Generar factura"));
		this.add(new JButton("Cantidad existencias"));
		this.add(new JButton("Ver/modificar menú"));
		this.add(new JButton("Notificar incidencias"));
		
		
		
	}
	
}
