package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame  {
	
	
	
	public MainWindow(){
		super("RESTAURANTE");
		this.setSize(1080, 720);
		this.setLayout(new BorderLayout(10, 10));
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem quit = new JMenuItem("Quit");
		menu.add(quit);
		quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//gameController.communicateInstruction(new QuitInstruction());			
			}
			
		});
		this.setJMenuBar(menuBar);	
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	

	private JMenuBar menuBar;

	
}