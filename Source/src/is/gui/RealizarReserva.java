package is.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import is.gui.spring.SpringUtilities;
import is.restaurante.Reserva;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.jdesktop.swingx.JXDatePicker;

@SuppressWarnings("serial")
public class RealizarReserva extends JPanel{

	@SuppressWarnings("deprecation")
	public RealizarReserva(GUIController controller){
		super();
		this.controlador = controller;
		this.setLayout(new BorderLayout());
		this.inicializaBox();
		JPanel reserva = new JPanel();
	
		reserva.setLayout(new SpringLayout());
		
		final JLabel fecha = new JLabel("Fecha: ");
		datePicker = new JXDatePicker(System.currentTimeMillis());
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fecha.setText(datePicker.getDate().toString());
				//TODO
			}

		});
		reserva.add(fecha);
		reserva.add(datePicker);	
		
		JLabel hora = new JLabel("Hora: ");
		//hora.add(this.hora);
		reserva.add(hora);
		JPanel eligeHora = new JPanel();
		eligeHora.setLayout(new FlowLayout());
			eligeHora.add(this.hora);
			eligeHora.add(this.minutos);
		reserva.add(eligeHora);
		
		//JLabel minutos = new JLabel("Minutos: ");
		//reserva.add(minutos);
		//reserva.add(this.minutos);
		
		JLabel nombre = new JLabel ("Nombre: ");
		//nombre.add(this.nombre);
		reserva.add(nombre);
		reserva.add(this.nombre);
		
		JLabel comensales = new JLabel ("Número de comensales");
		//comensales.add(this.comensales);
		reserva.add(comensales);
		reserva.add(this.comensales);
		//p.add(comensales);*/

		
		SpringUtilities.makeCompactGrid(reserva, 4, 2, 6, 6, 10, 10);
		this.add(reserva, BorderLayout.CENTER);
		
		this.add(new JButton("Reservar") {
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (compruebaReservaValida())
							controlador.communicateReserva();						//	return reserva;
						
					}

					

				
				});
				
			}

		}, BorderLayout.AFTER_LAST_LINE);
	
		
		

		frame = new JFrame("Reservas");

		JPanel aceptarOCancelar = new JPanel();
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
				//if (esReserva()){
				//	GUIController.comunicaReserva();
				//}
			}
			
		});
		JFrame frame = new JFrame("Reservas");

		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
		frame.pack();
		
	}
	
	public boolean compruebaReservaValida() {
		if (datePicker.getDate().before());
	}
	

	private void inicializaBox(){
		/*for (int i=1; i<=12; i++){
			mes.addItem(meses[i]);
		}
		for (int j = year; j < year+3; j++ ){
			this.año.addItem(j);
		}*/
		Vector<Integer> horas = new Vector<Integer>();
		for (int i=13; i<16; i++){
			horas.add(i);
		}for (int i=21; i<24; i++){
			horas.add(i);
		}
		Vector<Integer> minutos = new Vector<Integer>();
		for (int j=0; j<6; j++){
			minutos.add(j*10);
		}
		//int year = Calendar.getInstance().get(Calendar.YEAR);
		//mes = new JComboBox(meses);
		hora = new JComboBox(horas);
		this.minutos = new JComboBox(minutos);
		//año.addItem(year++);
		//año.addItem(year++);
		//año.addItem(year);
		
	}

	
	private JFrame frame;
	private boolean error;
	private Reserva reserva;
	private JTextField fecha = new JTextField(10);
	private JTextField dia = new JTextField(2);
	private JComboBox mes = new JComboBox();
	private JComboBox año = new JComboBox();
	private GUIController controlador;
	private JComboBox hora;
	private JComboBox minutos;
	
	private final JXDatePicker datePicker;
	
	private JTextField nombre = new JTextField(10);
	private JTextField comensales = new JTextField(2);
	
	private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
			"Julio", "Agosto", "Septiembre"
			, "Octubre", "Noviembre", "Diciembre"};
}
