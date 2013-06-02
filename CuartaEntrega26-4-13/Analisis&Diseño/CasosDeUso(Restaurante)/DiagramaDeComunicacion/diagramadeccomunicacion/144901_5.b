class RestauranteSwing
!!!152709.java!!!	RestauranteSwing()
	
		super();
		initializeGUI();
!!!152837.java!!!	RestauranteSwing(inout controlador : GUIController)
		super();
		this.rest = controlador;
		initializeGUI();
!!!152965.java!!!	initializeGUI() : void
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
						new RealizarPedido(rest);
						
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
		
		
!!!153093.java!!!	createImageIcon(in path : String, in description : String) : ImageIcon
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
!!!154245.java!!!	RealizarReserva(inout controller : GUIController)
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
		
!!!154373.java!!!	datosValidos() : boolean
		return comensalesValidos() && nombreValido();
!!!154501.java!!!	comensalesValidos() : boolean
		return (int)comensales.getValue() > 0;
!!!154629.java!!!	nombreValido() : boolean
		return nombre.getText().length() != 0;
!!!154757.java!!!	inicializaBox() : void
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
		
