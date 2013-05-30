package is.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Vector;

import is.gui.spring.SpringUtilities;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.jdesktop.swingx.JXDatePicker;

@SuppressWarnings("serial")
public class RealizarReserva extends JPanel{

	public RealizarReserva(){
		super();
		this.inicializaBox();
		this.setLayout(new SpringLayout());
		
		final JLabel fecha = new JLabel("Fecha: ");
		@SuppressWarnings("deprecation")
		final JXDatePicker datePicker = new JXDatePicker(System.currentTimeMillis());
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecha.setText(datePicker.getDate().toString());
			}

		});
		this.add(fecha);
		this.add(datePicker);
		
		/*JLabel dia = new JLabel("Día: ");
		//dia.add(this.dia);
		this.add(dia);
		this.add(this.dia);
		
		JLabel mes = new JLabel("Mes: ");
		//mes.add(this.mes);
		this.add(mes);
		this.add(this.mes);
		
		JLabel año = new JLabel("Año: ");
		//año.add(this.año);
		this.add(año);
		this.add(this.año);*/
		
		JLabel hora = new JLabel("Hora: ");
		//hora.add(this.hora);
		this.add(hora);
		this.add(this.hora);
		
		JLabel 
		
		JLabel nombre = new JLabel ("Nombre: ");
		//nombre.add(this.nombre);
		this.add(nombre);
		this.add(this.nombre);
		
		JLabel comensales = new JLabel ("Número de comensales");
		//comensales.add(this.comensales);
		this.add(comensales);
		this.add(this.comensales);
		//p.add(comensales);*/
		SpringUtilities.makeCompactGrid(this, 6, 2, 6, 6, 10, 10);
		
		JFrame frame = new JFrame("Reservas");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
		frame.pack();
		
	}
	
	private void inicializaBox(){
		/*for (int i=1; i<=12; i++){
			mes.addItem(meses[i]);
		}
		for (int j = year; j < year+3; j++ ){
			this.año.addItem(j);
		}*/
		Vector<Integer> horas = new Vector<Integer>();
		for (int i=0; i<24; i++){
			horas.add(i);
		}
		Vector<Integer> minutos = new Vector<Integer>();
		for (int j=0; j<4; j++){
			minutos.add(j*15);
		}
		//int year = Calendar.getInstance().get(Calendar.YEAR);
		//mes = new JComboBox(meses);
		hora = new JComboBox(horas);
		this.minutos = new JComboBox(minutos);
		//año.addItem(year++);
		//año.addItem(year++);
		//año.addItem(year);
		
	}

	
	
	private boolean error;
	
	private JTextField fecha = new JTextField(10);
	private JTextField dia = new JTextField(2);
	private JComboBox mes = new JComboBox();
	private JComboBox año = new JComboBox();
	
	private JComboBox hora;
	private JComboBox minutos;
	
	private JTextField nombre = new JTextField(10);
	private JTextField comensales = new JTextField(2);
	
	private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
			"Julio", "Agosto", "Septiembre"
			, "Octubre", "Noviembre", "Diciembre"};
}
