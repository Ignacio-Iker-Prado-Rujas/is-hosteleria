package is.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
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
 * Realiza una reserva para el restaurante a nombre del cliente, permitiendo seleccionar fecha y hora, numero de comensales y mesas.
 * La aplicación exigirá que el nombre no esté vacío y que el número de comensales no sea nulo.
 * Pueden seleccionarse m´´as de una mesa en cada reserva.
 * Tras comprobar que estos campos son correctos, crea la reserva y la añade a la lista de reservas.
 * @author Jaime
 * @author Jesús
 * @author Kike
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
		reserva.add(horaLabel);
		JPanel eligeHora = new JPanel();
		eligeHora.setLayout(new FlowLayout());
		eligeHora.add(this.hora);
		eligeHora.add(this.minutos);
		reserva.add(eligeHora);
		JLabel nombreL = new JLabel ("Nombre: ");
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
		
		reserva.add(comensalesL);
		reserva.add(this.comensales);
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

		//Después de reserva va el número de botones que queremos
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
							String fecha = datePicker.getDate().toString();
							controlador.communicateReserva(fecha, (int)hora.getSelectedItem(), 
									(int)minutos.getSelectedItem(), nombre.getText(), 
									(int)comensales.getValue(), mesasSel);						
							frame.setVisible(false);
							
						}
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
	
		frame = new JFrame("Reservas");
		frame.setPreferredSize(new Dimension(400, 280));
		frame.setVisible(true);	
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
		hora = new JComboBox(horas);
		this.minutos = new JComboBox(minutos);
		
	}
	
	public final class SeleccionMesas extends JFrame implements ChangeListener{
	    private JCheckBox[] checkMesas = new JCheckBox[mesasSel.length];
	    
	    public SeleccionMesas() {
	        JPanel checkPanel = new JPanel(new GridLayout((mesasSel.length +1)/2,2));	        
	        for (int i=0; i<mesasSel.length; i++){
	        	checkMesas[i] = new JCheckBox("Mesa " + i);
	        	checkMesas[i].addChangeListener(this);
	        	checkMesas[i].setSelected(mesasSel[i]);
	        	checkPanel.add(checkMesas[i]);
	        }        
	        checkPanel.add(new JButton ("Seleccionar"){
	        	{
	        		this.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
							SeleccionMesas.this.setVisible(false);
						
						
						}
	        			
	        		});
	        	}

	        }); 
	        this.add(checkPanel);
	    }
	    
	    public void stateChanged(ChangeEvent e){
	        String cad="";
	        for (int i=0; i< checkMesas.length; i++){
	        	mesasSel[i] = checkMesas[i].isSelected();
	        }
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
