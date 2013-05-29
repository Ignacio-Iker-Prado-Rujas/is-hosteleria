package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class MainWindow extends JFrame  {
	
	
	
	public MainWindow(){
		super("KIKE HOSTELERIA S.A.");
		this.setSize(1080, 720);
		this.setLayout(new GridLayout(1,2));
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
		ImageIcon kike = createImageIcon("images/kikeHost.png", "KIKE");
		JLabel logo = new JLabel(kike);
		logo.setSize(20, 20);
	//	this.add(logo, BorderLayout.NORTH);
		
		JPanel usuario = new JPanel();
		usuario.setLayout(new FlowLayout());
		JPanel contrasena = new JPanel();
		
		JTextArea textoUsuario = new JTextArea("USUARIO");
		textoUsuario.setEnabled(false);
		textoUsuario.setOpaque(true);
		usuario.add(textoUsuario, BorderLayout.NORTH);
		user = new JTextField();
		usuario.add(user);
		
		JTextArea textoContrasena = new JTextArea("CONTRASEÑA");
		textoContrasena.setEnabled(false);
		textoUsuario.setOpaque(true);
		contrasena.add(textoContrasena, BorderLayout.NORTH);
		password = new JTextField();
		contrasena.add(password);
		this.add(usuario, BorderLayout.CENTER);
	//	this.add(contrasena);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	

	private JMenuBar menuBar;
	private JPanel[] usuarios;
	JTextField user;
	JTextField password;
	
}