package is.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import is.gui.spring.SpringUtilities;
import is.restaurante.Reserva;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jdesktop.swingx.JXDatePicker;

/**
 * TODO en esta clase solo falta al comunicar la reserva que pasamos el array de booleanos mesasSel 
 * como parametro, para que la reserva añada las mesas
 * necesarias, mesasSel[i] es true, quiere 
 * decir que la mesa con indice i esta en la reserva
 */
@SuppressWarnings("serial")
public class RealizarReserva extends JPanel{

	@SuppressWarnings("deprecation")
	public RealizarReserva(GUIController controller){
		super();
		this.controlador = controller;
		this.setLayout(new BorderLayout());
		this.inicializaBox();
		
		
		this.mesasSel = new boolean[controlador.requestMesas().length];
		for (int i=0; i< mesasSel.length; i++)
			mesasSel[i] = false;
		final SeleccionMesas selecciona = new SeleccionMesas();
		
		JPanel reserva = new JPanel();
	
		reserva.setLayout(new SpringLayout());
		
		final JLabel fecha = new JLabel("Fecha: ");
		datePicker = new JXDatePicker(System.currentTimeMillis());
		datePicker.setFormats(new SimpleDateFormat("EEE, dd-MM-yyyy"));
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fecha.setText(datePicker.getDate().toString());
				//TODO
			}

		});
		reserva.add(fecha);
		reserva.add(datePicker);	
		
		JLabel horaLabel = new JLabel("Hora: ");
		//hora.add(this.hora);
		reserva.add(horaLabel);
		JPanel eligeHora = new JPanel();
		eligeHora.setLayout(new FlowLayout());
			eligeHora.add(this.hora);
			eligeHora.add(this.minutos);
		reserva.add(eligeHora);
		
		//JLabel minutos = new JLabel("Minutos: ");
		//reserva.add(minutos);
		//reserva.add(this.minutos);
		
		JLabel nombreL = new JLabel ("Nombre: ");
		//nombre.add(this.nombre);
		reserva.add(nombreL);
		reserva.add(this.nombre);
		
		JLabel comensalesL = new JLabel ("Número de comensales");
		comensales.setValue(0);
		comensales.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				if ((int) comensales.getValue() < 0)
					comensales.setValue(0);
			}
			
		});
		
		//comensales.add(this.comensales);
		reserva.add(comensalesL);
		reserva.add(this.comensales);
		//p.add(comensales);*/
		
		JLabel mesasL = new JLabel("Mesas");
		JButton mesasB = new JButton("Elegir mesas");
		mesasB.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//SeleccionMesas selecciona = new SeleccionMesas();
				selecciona.setBounds(0,0,300,200);
		        selecciona.setVisible(true);
			}
			
		});
		reserva.add(mesasL);
		reserva.add(mesasB);

		/*
		 * Atención!!, después de reserva va el número de botoncitos que queremos
		 */
		SpringUtilities.makeCompactGrid(reserva, 5, 2, 6, 6, 10, 10);
		this.add(reserva, BorderLayout.CENTER);
		
		this.add(new JButton("Reservar") {
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (datosValidos()){
							datePicker.setFormats(new SimpleDateFormat("yyyy MM dd hh mm EEE"));
							Date reservaDate = datePicker.getDate();
							/*int year = reservaDate.getYear();
							int month = reservaDate.getMonth();
							int day = reservaDate.getDay();
							*/
							String fecha = datePicker.getDate().toString();
							
							
							controlador.communicateReserva(fecha, (int)hora.getSelectedItem(), 
									(int)minutos.getSelectedItem(), nombre.getText(), 
									(int)comensales.getValue(), mesasSel);						
							frame.setVisible(false);
							
						}//TODO else mostrar mensaje de error, donde sea, diciendo 
						//que hay que poner un numero de comensales
						else {
							String error = "";
							if (!comensalesValidos()) error += COMENSALES_NO_VALIDOS;
							if (!nombreValido()) error += NOMBRE_RESERVA;
							
						JOptionPane.showMessageDialog(frame,
							    error,
							    "Error",
							    JOptionPane.WARNING_MESSAGE);
					}
						datePicker.setFormats(new SimpleDateFormat("EEE, dd-MM-yyyy"));
						
					}
					

				
				});
				
			}

		}, BorderLayout.AFTER_LAST_LINE);
	
		
		/** Este era otro frame que habia por aqui, si eso unirlo con el otro.
/*
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
		
		*/
		frame = new JFrame("Reservas");

		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
		frame.pack();
		
	}
	
	public boolean datosValidos() {
		return comensalesValidos() && nombreValido();
	}
	
	public boolean comensalesValidos(){
		return (int)comensales.getValue() > 0;
	}
	
	public boolean nombreValido(){
		return nombre.getText().length() != 0;
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
		for (int j=0; j<12; j++){
			minutos.add(j*5);
		}
		//int year = Calendar.getInstance().get(Calendar.YEAR);
		//mes = new JComboBox(meses);
		hora = new JComboBox(horas);
		this.minutos = new JComboBox(minutos);
		//año.addItem(year++);
		//año.addItem(year++);
		//año.addItem(year);
		
	}
	
	public final class SeleccionMesas extends JFrame implements ChangeListener{
	    private JCheckBox[] checkMesas = new JCheckBox[mesasSel.length];
	    public SeleccionMesas() {
	    	 //Put the check boxes in a column in a panel
	    	//TODO jesus, villarin o quien sea, mirad esto del grid layout que no se muy bien como va
	        JPanel checkPanel = new JPanel(new GridLayout(5,5));
	        
	        for (int i=0; i<mesasSel.length; i++){
	        	checkMesas[i] = new JCheckBox("Mesa " + i);
	        	checkMesas[i].addChangeListener(this);
	        	checkMesas[i].setSelected(mesasSel[i]);
	        	//checkMesas[i].setLocation(0, i*10);
	        	//checkMesas[i].setBounds(0,0,i*10, 50);
	        	checkPanel.add(checkMesas[i]);
	        }/*
	        check1=new JCheckBox("Inglés");
	        check1.setBounds(10,10,150,30);
	        check1.addChangeListener(this);
	        add(check1);
	        check2=new JCheckBox("Francés");
	        check2.setBounds(10,50,150,30);
	        check2.addChangeListener(this);        
	        add(check2);
	        check3=new JCheckBox("Alemán");
	        check3.setBounds(10,90,150,30);
	        check3.addChangeListener(this);        
	        add(check3); */  
	        this.add(checkPanel);
	    }
	    
	    public void stateChanged(ChangeEvent e){
	        String cad="";
	        for (int i=0; i< checkMesas.length; i++){
	        	mesasSel[i] = checkMesas[i].isSelected();
	        }
	        /*if (check1.isSelected()==true) {
	            cad=cad+"Inglés-";
	        }
	        if (check2.isSelected()==true) {
	            cad=cad+"Francés-";
	        }
	        if (check3.isSelected()==true) {
	            cad=cad+"Alemán-";
	        }*/
	        setTitle(cad);
	    }
	}
	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private static String COMENSALES_NO_VALIDOS = "Debe seleccionar el número de comensales" + LINE_SEPARATOR;
	private static String NOMBRE_RESERVA = "Debe introcudir el nombre del cliente" + LINE_SEPARATOR;
	
	
	private JFrame frame;
	private boolean error;
	private boolean[] mesasSel;
	
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
	private JSpinner comensales = new JSpinner();
	
	private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
			"Julio", "Agosto", "Septiembre"
			, "Octubre", "Noviembre", "Diciembre"};
}
