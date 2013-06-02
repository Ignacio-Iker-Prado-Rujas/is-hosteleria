package pruebas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import org.jdesktop.swingx.JXDatePicker;
public class Date {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final JLabel label = new JLabel();
		
		label.setText("Choose Date by selecting below.");
		 
		@SuppressWarnings("deprecation")
		final JXDatePicker datePicker = new JXDatePicker(System.currentTimeMillis());
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText(datePicker.getDate().toString());
				//label.setText(datePicker.getDate().getYear() + "/" + datePicker.getDate().getMonth() +"/" +  datePicker.getDate().getDay());
			}

		});
		 JFrame frame = new JFrame();
		 frame.setVisible(true);
		 
		frame.getContentPane().add(label, BorderLayout.NORTH);
		frame.getContentPane().add(datePicker, BorderLayout.CENTER);
	}

}
