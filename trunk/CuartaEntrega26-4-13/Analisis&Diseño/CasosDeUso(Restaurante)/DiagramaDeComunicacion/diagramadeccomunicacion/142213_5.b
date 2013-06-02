class Menu
!!!160389.java!!!	Menu()
		bebidas = new ArrayList<Consumicion>(2);
		bebidas.add(new Bebida("Vodka-Limón", 1, true, null));
		bebidas.add(new Bebida("Anticongelante", 5, true, null));
		primeros = new ArrayList<Consumicion>(2);
		primeros.add(new Plato("Lentejas", 5, true, null));
		primeros.add(new Plato("Canelones", 5, true, null));		
		segundos = new ArrayList<Consumicion>(2);
		segundos.add(new Plato("Filete de caballo", 5, true, null));		
		segundos.add(new Plato("Almondigas", 5, true, null));		
		
		postres = new ArrayList<Consumicion>(2);
		postres.add(new Plato("Helado de gordaco", 5, true, null));		
		postres.add(new Plato("Manzana de Newton", 5, true, null));		

	//	postres.get(index)

!!!160517.java!!!	getPlatos(inout tipoPlato : TipoPlatos) : Consumicion
		switch (tipoPlato) {
		case BEBIDA:
			return bebidas;
		case PRIMERO:
			return primeros;
		case SEGUNDO:
			return segundos;
		case POSTRE:
			return postres;
		default:
			return null;
		}
!!!160645.java!!!	mostrarConsumiciones(inout consumiciones : ArrayList<Consumicion>) : String
		String[] nombres = null;
		/* bucle acumulando todas las consumiciones del array pasado */
		return nombres;
		
!!!160773.java!!!	getBebidas() : Consumicion
		return bebidas;
!!!160901.java!!!	getPrimeros() : Consumicion
		return primeros;
!!!161029.java!!!	getSegundos() : Consumicion
		return segundos;
!!!161157.java!!!	getPostres() : Consumicion
		return postres;
!!!148485.java!!!	CeldaPlato(inout controller : GUIController, in plato : Consumicion, in numMesa : int, in numComanda : int, in tPlato : TipoPlatos)
		this.restControl = controller;
		this.veces = 0;
		this.plato = plato;
		this.botonPlato = new JButton(plato.getNombre()){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						incrementaVeces();
						restControl.requestNewConsumption(numComanda, numMesa, plato, tPlato);
					}
					
				});
			}
		};
		this.flechitas = new JSpinner();
		this.flechitas.setValue(0);
		this.flechitas.addChangeListener(new ChangeListener() {

			//TODO cada vez que se añade un plato, habrá que añadirlo a la lista de pedidos
			//asi que hay que registrar como observador la parte derecha de realizar pedido, que es la lista final con todas las cosas
			@Override
			public void stateChanged(ChangeEvent e) {
				veces = (int) flechitas.getValue();
			}
			
		});
		this.setLayout(new FlowLayout());
		this.add(botonPlato);
		this.add(flechitas);
		
!!!148613.java!!!	incrementaVeces() : void
		//int numero = (int) this.flechitas.getValue();
		//numero++;
		this.veces++;
		this.flechitas.setValue(this.veces);
		//this.veces = numero;
!!!148741.java!!!	getVeces() : int
		return this.veces;
