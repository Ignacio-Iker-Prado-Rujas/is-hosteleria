class Comanda
!!!156549.java!!!	Comanda()
		comanda = new HashMap[4];
		for (int i = 0; i < 4; i++)
			comanda[i] = new HashMap<Consumicion, Integer>();
!!!156677.java!!!	addObserver(inout obs : ComandaObserver) : void
		this.observers.add(obs);
!!!156805.java!!!	addConsumicion(inout consumicion : Consumicion, in index : int) : void
		if (comanda[index].containsKey(consumicion)) {
			comanda[index]
					.put(consumicion, comanda[index].get(consumicion) + 1);
		} else
			comanda[index].put(consumicion, 1);
		this.precio += consumicion.getPrecio();
		emitirCambio();
!!!156933.java!!!	deleteConsumicion(inout consumicion : Consumicion, in index : int) : void
		if (comanda[index].containsKey(consumicion)) {
			comanda[index]
					.put(consumicion, comanda[index].get(consumicion) - 1);
			if (comanda[index].get(consumicion) == 0)
				comanda[index].remove(consumicion);
			this.precio -= consumicion.getPrecio();
			emitirCambio();
		} else
			// Emitir un error
			;
!!!157061.java!!!	addPrimero(inout primero : Plato) : void
		addConsumicion(primero, 0);
!!!157189.java!!!	deletePrimero(inout primero : Plato) : void
		deleteConsumicion(primero, 0);
!!!157317.java!!!	setVecesPrimero(inout primero : Plato) : void

!!!157445.java!!!	addSegundo(inout segundo : Plato) : void
		addConsumicion(segundo, 1);
!!!157573.java!!!	deleteSegundo(inout segundo : Plato) : void
		deleteConsumicion(segundo, 1);
!!!157701.java!!!	setVecesSegundo(inout segundo : Plato) : void

!!!157829.java!!!	addPostre(inout postre : Postre) : void
		addConsumicion(postre, 2);
!!!157957.java!!!	deletePostre(inout postre : Postre) : void
		deleteConsumicion(postre, 2);
!!!158085.java!!!	setVecesPostre(inout postre : Postre) : void

!!!158213.java!!!	addBebida(inout bebida : Bebida) : void
		addConsumicion(bebida, 3);
!!!158341.java!!!	deleteBebida(inout bebida : Bebida) : void
		deleteConsumicion(bebida, 3);
!!!158469.java!!!	setVecesBebidas(inout drinking : Bebida) : void

!!!158597.java!!!	append(inout other : Comanda) : void
		for (int tipoPlato = 0; tipoPlato < 4; tipoPlato++) {
			Set<Consumicion> claveOther = other.comanda[tipoPlato].keySet();
			// Obtenemos un vector con los elementos de la otra Comanda del tipo
			// de plato i
			Consumicion[] consumicionesOther = claveOther
					.toArray(new Consumicion[claveOther.size()]);
			// Para cada elemento del vector, los añadimos tanta veces como
			// existira en la otra comanda
			for (int pos = 0; pos < consumicionesOther.length; pos++) {
				int veces = other.comanda[tipoPlato]
						.get(consumicionesOther[pos]);
				for (int num = 0; num < veces; num++)
					addConsumicion(consumicionesOther[pos], tipoPlato);
			}
		}
!!!158725.java!!!	toString() : String
		String pedido = "";
		for (int i = 0; i < 4; i++)
			for (Entry<Consumicion, Integer> entry : comanda[i].entrySet()) {
				pedido = pedido + entry.getKey().getNombre() + " "
						+ entry.getKey().getPrecio() + " Cantidad: "
						+ comanda[i].get(entry.getKey()) + LINE_SEPARATOR;
			}
		pedido += "TOTAL: " + this.precio;
		return pedido;
!!!158853.java!!!	lista() : Consumicion
		return null;

!!!158981.java!!!	emitirCambio() : void
		for (ComandaObserver obs : observers)
			obs.comandaHaCambiado(this.toString());
!!!153733.java!!!	RealizarPedido(in rest : GUIController, in numeroMesa : int, in comandaSeleccionada : int)
		this.restaurante = rest;
		this.numeroComanda = comandaSeleccionada;
		this.numeroMesa = numeroMesa;
		
/*
 * public VerMenu(GUIController controller){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,500);
		
		this.controlador = controller;
		menu = controlador.getMenu();
		menu.getBebidas();
		JPanel panel = new JPanel();
	//	panel.setLayout()
		elementosMenu = new JPanel[4];
		elementosMenu[0] = new JPanel();
		for (Consumicion c : menu.getBebidas()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[0].add(plato);
		}
		elementosMenu[1] = new JPanel();
		for (Consumicion c : menu.getPrimeros()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[1].add(plato);
		}
		elementosMenu[2] = new JPanel();
		for (Consumicion c : menu.getSegundos()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[2].add(plato);
		}
		elementosMenu[3] = new JPanel();
		for (Consumicion c : menu.getPostres()){
			CeldaPlato plato = new CeldaPlato(c);
			elementosMenu[3].add(plato);
		}
		for (JPanel p : elementosMenu) panel.add(p);
		this.add(panel);
		this.setVisible(true);
		//JFrame marco = new JFrame();
		//marco.add(panel);
	}
	
	private GUIController controlador;
	private Menu menu;
	private JPanel[] elementosMenu;
}
 */
		/*
		 * Inicialización de los paneles que tendrán información de las consumiciones que se pueden pedir
		 * 	y cuantas consumiciones se han pedido de cada tipo 
		 */
		inicializaPaneles();
		
		
		this.setLayout(new BorderLayout());
		JPanel tipoPlato = new JPanel();
		panelCentral = new JPanel();
		final CardLayout menu = new CardLayout();
		panelCentral.setLayout(menu);
		
		
		for (Integer i=0; i<4; i++)
			panelCentral.add(this.elementosMenu[i], i.toString());
		tipoPlato.setLayout(new GridLayout(4,1));
		tipoPlato.add(new JButton("Bebidas"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						//panelCentral.add(new PlatosPanel(0, restaurante));
						//panelCentral.add(elementosMenu[0]);
						menu.show(panelCentral, "0");
						tPlato = TipoPlatos.BEBIDA;
					}
					
				});
			}
		});
		tipoPlato.add(new JButton("Primeros"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						//panelCentral.add(new PlatosPanel(1, restaurante));
						//panelCentral = (elementosMenu[1]);
						menu.show(panelCentral, "1");
						tPlato = TipoPlatos.PRIMERO;
						
					}
					
				});
			}
		});
		tipoPlato.add(new JButton("Segundos"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						//panelCentral.add(new PlatosPanel(2, restaurante));
						//panelCentral = (elementosMenu[2]);
						menu.show(panelCentral, "2");
						tPlato = TipoPlatos.SEGUNDO;
						
					}
					
				});
			}
		});
		tipoPlato.add(new JButton("Postres"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						//panelCentral.add(new PlatosPanel(3, restaurante));
						//panelCentral = (elementosMenu[3]);
						menu.show(panelCentral, "3");
						tPlato = TipoPlatos.POSTRE;
						
					}
					
				});
			}
		});
		
		this.add(tipoPlato, BorderLayout.WEST);
		frame = new JFrame("Realizar Pedido");
		this.add(panelCentral);
		
        String[] nombresMesa = { "Mesa 1: 2 personas", "Mesa 2: 4 personas", "Mesa 3: 4 personas", "Mesa 4: 6 personas", "Mesa 5: 8 personas" };
        
        //Create the combo box, select the item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        mesas = new JComboBox(nombresMesa);
		this.add(mesas, BorderLayout.SOUTH);
		this.add(new JButton("Realizar Pedido"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
						//TODO, hay que hacer un restaurante
						//restaurante.comunicarComanda(mesa, mes, dia, hora, minutos, cliente, numeroComensales);
						//Mesa mesa = restaurante.getMesa(mesas.getSelectedIndex());
						//comanda = new Comanda();
						
						//mesa.addPedido(comanda);

						//restaurante.communicatePedido(año, mes, dia, hora, minutos, cliente, numeroComensales);


					//	elementosMenu[1].

					}
					
				});
			}
		}, BorderLayout.AFTER_LAST_LINE);
		TitledBorder titled = new TitledBorder("Pedido");
		text = new JTextArea("");
		text.setEditable(false);
			/** TODO Jaime, necesito ayuda aqui para meter las cosas que se van pidiendo en el textarea
			 *  Porque básicamente no se donde leches estan los spinners esos ni como van
			 *  Con lo que he cambiado de inicializaPaneles() ya tenemos los celdaPlato para sacar la informacion de ellos
			 */
		scroller = new JScrollPane(text);
        scroller.setPreferredSize(new Dimension(100,100));
        scroller.setBorder(titled);
        
        this.add(scroller, BorderLayout.EAST);
		
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
		frame.pack();

!!!153861.java!!!	RealizarPedido(inout controller : GUIController, inout comandaEdit : ComandaInfo)
		
!!!153989.java!!!	inicializaPaneles() : void
		elementosMenu = new JPanel[4];
		ArrayList<Consumicion> beb = this.restaurante.requestBebidas(),
		prim = this.restaurante.requestPrimeros(),
		seg = this.restaurante.requestSegundos(), 
		pos = this.restaurante.requestPostres();
		bebidas = new CeldaPlato[beb.size()];
		primeros = new CeldaPlato[prim.size()];
		segundos = new CeldaPlato[seg.size()];
		postres = new CeldaPlato[pos.size()];
		
		elementosMenu[0] = new JPanel();
		int i = 0;
		for (Consumicion c : beb){
			bebidas[i] = new CeldaPlato(restaurante, c, numeroMesa, numeroComanda, TipoPlatos.BEBIDA);
			elementosMenu[0].add(bebidas[i]);
		}
		elementosMenu[1] = new JPanel();
		for (Consumicion c : prim){
			CeldaPlato plato = new CeldaPlato(restaurante, c, numeroMesa, numeroComanda, TipoPlatos.PRIMERO);
			elementosMenu[1].add(plato);
		}
		elementosMenu[2] = new JPanel();
		for (Consumicion c : seg){
			CeldaPlato plato = new CeldaPlato(restaurante, c, numeroMesa, numeroComanda, TipoPlatos.SEGUNDO);
			elementosMenu[2].add(plato);
		}
		elementosMenu[3] = new JPanel();
		for (Consumicion c : pos){
			CeldaPlato plato = new CeldaPlato(restaurante, c, numeroMesa, numeroComanda, TipoPlatos.POSTRE);
			elementosMenu[3].add(plato);
		}
!!!154117.java!!!	comandaHaCambiado(in comanda : String) : void
		this.text.setText(comanda);
