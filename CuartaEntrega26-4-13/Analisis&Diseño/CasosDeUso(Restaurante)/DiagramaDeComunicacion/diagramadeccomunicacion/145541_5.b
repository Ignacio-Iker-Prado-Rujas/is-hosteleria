class VerReserva
!!!155653.java!!!	VerReserva(inout rest : GUIController)
		this.controlador = rest;
		JPanel panel = new JPanel();
		JLabel nombre = new JLabel("Introduzca su nombre");
		nombreReserva = new JTextField();
		panel.setLayout(new GridLayout (3,1));
		panel.add(nombre);
		panel.add(nombreReserva);

		
		panel.add(new JButton("Buscar"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						List<Integer> listaReservas = controlador.reservasDeUnCliente(nombreReserva.getText());
						for (Integer r : listaReservas) r.crearPanel(); 
						
						// TODO AYUDA!! haciendo eso te cargas el mvc pero si no lo hacer tienes que crear mil getters y setters	*/					
					}
					
				});
			}
		});
		
		
		JFrame marco = new JFrame();
		marco.add(panel);
		marco.setVisible(true);
		marco.setSize(150, 150);
!!!155141.java!!!	RestauranteSwing()
	
		super();
		initializeGUI();
!!!155269.java!!!	RestauranteSwing(inout controlador : GUIController)
		super();
		this.rest = controlador;
		initializeGUI();
!!!155397.java!!!	initializeGUI() : void
	this.setLayout(new GridLayout(3,3, 3, 15));	
	botones = new JButton[9];
		
		botones[0] = new JButton("Realizar reserva"){
			{
				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new RealizarReserva(rest);
					}
					
				});
			}
		};

		botones[1] = new JButton("Generar/modificar comanda"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						//new RealizarPedido(rest);
						new VistaMesas(rest);
					}
				});
			}
		};
		
		botones[2] = new JButton	("Ver/anular reserva") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new VerReserva(rest);
					}

				});

			}

		};
		
		botones[3] = new JButton	("Anular pedido") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

					}

				});

			}

		};
		
		botones[4] = new JButton	("Distribución mesas") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ImageIcon mesas = createImageIcon("images/mesas.png", "mesas");
						JLabel fotoMesas = new JLabel(mesas);
						JFrame marco = new JFrame();
						marco.setVisible(true);
						marco.add(fotoMesas);
						marco.setSize(620, 475);

					}

				});

			}

		};
		
		botones[5] = new JButton	("Generar factura") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
							new GenerarFactura(rest);

					}

				});

			}

		};
		
		botones[6] = new JButton	("Cantidad existencias") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new CantidadExistencias(rest);

					}

				});

			}

		};
		
		botones[7] = new JButton	("Ver/modificar menú") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new VerMenu(rest);

					}

				});

			}

		};
		
		botones[8] = new JButton	("Notificar incidencias") {
			{

				this.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new NotificarIncidencias(rest);

					}

				});

			}

		};
		for(JButton b : botones) this.add(b);
	//	this.add(new JButton("Ver/modificar menú"));
	//	this.add(new JButton("Notificar incidencias"));
		
		
!!!155525.java!!!	createImageIcon(in path : String, in description : String) : ImageIcon
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
