package is.gui;

import java.util.Calendar;

import is.gui.spring.SpringUtilities;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class RealizarReserva extends JPanel{

	public RealizarReserva(){
		super();
		this.inicializaBox();
		this.setLayout(new SpringLayout());
		
		JLabel dia = new JLabel("Día: ");
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
		this.add(this.año);
		
		JLabel hora = new JLabel("Hora: ");
		//hora.add(this.hora);
		this.add(hora);
		this.add(this.hora);
		
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
		int year = Calendar.getInstance().get(Calendar.YEAR);
		mes = new JComboBox(meses);
		año.addItem(year++);
		año.addItem(year++);
		año.addItem(year);
		
	}

	
	
	private boolean error;
	
	private JTextField dia = new JTextField(2);
	private JComboBox mes = new JComboBox();
	private JComboBox año = new JComboBox();
	
	private JTextField hora = new JTextField(2);
	private JTextField minutos = new JTextField(2);
	
	private JTextField nombre = new JTextField(10);
	private JTextField comensales = new JTextField(2);
	
	private String[] meses = {"Enero", "Febrero", "Marzo", "Abri", "Mayo", "Junio", 
			"Julio", "Agosto", "Septiembre"
			, "Octubre", "Noviembre", "Diciembre"};
}
