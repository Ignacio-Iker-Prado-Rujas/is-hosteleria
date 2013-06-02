class GenerarFactura
!!!148869.java!!!	GenerarFactura(inout rest : GUIController)
		this.controlador = rest;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		panel.add( new JLabel("Introduzca el numero de mesa"));
		numMesa = new JTextField();
		panel.add(numMesa);
		panel.add(new JButton("Generar Factura"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						numMesa.getText();
					//TODO duda del mvc, aqui hay que llamar al modelo y que te devuelva la mesa?
						
						mesa = controlador.getMesa(numMesa.getText());
						marco = new JFrame();
						//JPanel panel = new JPanel();
						JTextArea factura = new JTextArea(mesa.generarFactura());
						marco.add(factura);
						marco.setVisible(true);
						marco.pack();
						marco.add(new JButton("Aceptar"){
							{
								this.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent e) {
										marco.setVisible(false);
										
									}
									
								});
							}
						});
					}
					
				});
			}
		});
		JFrame marco = new JFrame();
		marco.add(panel);
		marco.setSize(200,200);
		marco.setVisible(true);
	
!!!156805.java!!!	VerMenu(inout controller : GUIController)
		inicializarVerMenu();
		this.controlador = controller;
		
		this.controlador.registerMenuObserver(this);
		
		menu = controlador.getMenu();
		inicializarVentana();
		
		TipoPlatos[] tipoPlatos = TipoPlatos.values();
		for( TipoPlatos tPlato : tipoPlatos){
			nuevoTipoPlato(tPlato);	
		}
		this.setVisible(true);
!!!156933.java!!!	nuevoTipoPlato(inout tPlato : TipoPlatos) : void
		JPanel panel = new JPanel(new BorderLayout());		
		pestanyas.add(tPlato.toString(), panel);
		cadaPestanya.add(panel);
		
		JPanel opciones = new JPanel(new GridLayout());
		panel.add(opciones, BorderLayout.SOUTH);
		
		JButton anyadir = new JButton("add");
		anyadir.addActionListener(new ActionListener(){				
			@Override
			public void actionPerformed(ActionEvent e) {
				anyadirNuevoPlato();					
			}
		});
		JButton editar = new JButton("edit");
		editar.addActionListener(new ActionListener(){				
			@Override
			public void actionPerformed(ActionEvent e) {
				editarPlato();					
			}
		});
		JButton borrar = new JButton("remove");
		borrar.addActionListener(new ActionListener(){				
			@Override
			public void actionPerformed(ActionEvent e) {
				borrarPlato();					
			}
		});
		opciones.add(anyadir);
		opciones.add(editar);
		opciones.add(borrar);
		
		
		/**** Añade los platos correspondientes a un tipo de Plato	****/
		
		JPanel platos = new JPanel(new FlowLayout());
		panel.add(platos);
		ventanas.add(platos);
		
		ArrayList<Consumicion> consum = menu.getPlatos(tPlato);
		for( Consumicion cons: consum){
			/*	Habría que guardar las descripciones tb para mostrarlas	*/
			JToggleButton boton = new JToggleButton(cons.getNombre());
			botones.add(boton);
			platos.add(boton);
			boton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					consumicionPulsada();				
				}
				
			});
		}	
		//añades los JtextFiel para las descripciones
		JTextField descrip = new JTextField();
		descrip.setMaximumSize(new Dimension(1,1));
		JScrollPane js = new JScrollPane(descrip);
		descrip.setEditable(false);
		panel.add(js, BorderLayout.NORTH);
		descriptions.add(descrip);
!!!157061.java!!!	inicializarVentana() : void
		
		panelGeneral = new JPanel();//Creamos el panel principal
		cardLayout = new CardLayout();
		panelGeneral.setLayout(cardLayout);
		
		pestanyas = new JTabbedPane();

		panelGeneral.add(pestanyas, "pestanyas");
		this.add(panelGeneral);
!!!157189.java!!!	inicializarVerMenu() : void
		this.setSize(400,500);
		JFrame.setDefaultLookAndFeelDecorated(true);
	    JDialog.setDefaultLookAndFeelDecorated(true);
	    try {
	    	UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			//.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		this.botones = new ArrayList<JToggleButton>();
		ventanas = new ArrayList<JPanel>();
		cadaPestanya = new ArrayList<JPanel>();
		this.descriptions = new ArrayList<JTextField>();
!!!157317.java!!!	borrarPlato() : void
		if(this.consumicionSeleccionada!=null)
			this.controlador.deleteConsumicion(menu.getConsumicion(consumicionSeleccionada.getText()));
		else notificar("Se debe seleccionar el plato a borrar");
!!!157445.java!!!	editarPlato() : void
		if(this.consumicionSeleccionada!=null){
			//System.out.println(consumicionSeleccionada.getText() + " debe ser editado");
			ConsumicionSwing nuevaCons = new ConsumicionSwing(this, controlador, menu.getConsumicion(consumicionSeleccionada.getText()), true);
			panelGeneral.add(nuevaCons , "editConsumicion");
			cardLayout.show(panelGeneral, "editConsumicion");
		}else notificar("Se debe seleccionar el plato a editar");
!!!157573.java!!!	anyadirNuevoPlato() : void
		ConsumicionSwing nuevaCons = new ConsumicionSwing(this, controlador, null, false);
		panelGeneral.add(nuevaCons , "createConsumicion");
		cardLayout.show(panelGeneral, "createConsumicion");
!!!157701.java!!!	consumicionPulsada() : void
		for( JToggleButton boton: botones)
			if(!boton.isFocusOwner())	//
				boton.setSelected(false);
			else{
				consumicionSeleccionada = boton;
				mostrarDescripcion(menu.getConsumicion(boton.getText()).getDescripcion());
			}
!!!157829.java!!!	mostrarDescripcion(in description : String) : void
		for(JTextField jText: descriptions)
			jText.setText(description);	
!!!157957.java!!!	borrarPlato(in nombre : String) : void
		
!!!158085.java!!!	devolverControlPrincipal() : void
		cardLayout.show(panelGeneral, "pestanyas");
!!!158213.java!!!	notificar(in message : String) : void
		JOptionPane.showMessageDialog(this, message);
!!!158341.java!!!	addConsumption(in consId : String) : void
		
!!!158469.java!!!	deleteConsumption(in consId : String) : void
		
!!!158597.java!!!	editConsumption(in consId : String) : void
		
