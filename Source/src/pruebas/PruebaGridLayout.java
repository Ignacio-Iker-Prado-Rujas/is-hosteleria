package pruebas;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class PruebaGridLayout {
   private static final int COLUMNAS = 10;
   private static final int FILAS = 5;
   private static Integer veces = 0;
   public static void main(String [] args)
   {
      JFrame v = new JFrame();
      v.getContentPane().setLayout(new GridLayout(FILAS,COLUMNAS));
		
      JTextField [][] textField = new JTextField [FILAS][COLUMNAS];
      for (int i=0;i<FILAS;i++)
         for (int j=0;j<COLUMNAS-2;j++)
         {
            textField[i][j] = new JTextField(1);
            v.getContentPane().add(textField[i][j]);
         }
      JButton boton = new JButton("boton");
      final JTextField text = new JTextField("hola");
      v.getContentPane().add(boton);
      v.getContentPane().add(text);
      boton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			veces++;
			text.setText(veces.toString());
		}
    	  
      });
      //v.getContentPane().add(new JButton("boton"))
      v.pack();
      v.setVisible(true);
      v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
   }
}