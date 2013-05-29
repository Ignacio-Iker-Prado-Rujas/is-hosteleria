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
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
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
		ImageIcon kike = createImageIcon("images/kikeHost2.png", "KIKE");
		JLabel logo = new JLabel(kike);
		logo.setSize(20, 20);

		this.add(logo, BorderLayout.NORTH);
		JPanel front = new JPanel();
		front.setLayout(new GridLayout(3,1));
		JPanel usuario = new JPanel();

		usuario.setLayout(new GridLayout(2,1));
		JPanel contrasena = new JPanel();
		contrasena.setLayout(new GridLayout(2,1));
		JLabel textoUsuario = new JLabel("USUARIO");
		textoUsuario.setOpaque(true);
		usuario.add(textoUsuario, BorderLayout.NORTH);
		user = new JTextField(10);
		usuario.add(user);
		
		JLabel textoContrasena = new JLabel("CONTRASEÑA");
		textoUsuario.setOpaque(true);
		contrasena.add(textoContrasena, BorderLayout.NORTH);
		password = new JPasswordField(10);
		password.getPassword();
		
		contrasena.add(password);
		front.add(usuario);
		front.add(contrasena);
		
		front.add(new JButton("Entrar"));
		this.add(front);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		RestauranteSwing rest = new RestauranteSwing();
		// this.removeAll();
		if (true) { //Si el login es correcto (hay que implementar eso, se borra todo y se muestra la pantalla del restaurante
			this.remove(logo);
			this.remove(front);
			this.setSize(400,300);
			this.add(rest);
		}

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
	JTextField user;
	JPasswordField password;
	Usuario[] usuarios;
	
}