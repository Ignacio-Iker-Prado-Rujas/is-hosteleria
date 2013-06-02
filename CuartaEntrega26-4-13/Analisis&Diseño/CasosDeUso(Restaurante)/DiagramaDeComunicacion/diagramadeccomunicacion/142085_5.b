class GUIController
!!!148997.java!!!	crearComanda() : void
		
	//	this.robot.requestStart();
!!!149125.java!!!	GUIController(inout restaurante : Restaurante)
		this.restaurante = restaurante;
!!!149253.java!!!	getMenu() : Menu
		return restaurante.getMenu();
!!!149381.java!!!	requestPrimeros() : Consumicion
		return restaurante.getMenu(1);
		
!!!149509.java!!!	requestSegundos() : Consumicion
		return restaurante.getMenu(2);
		
!!!149637.java!!!	requestPostres() : Consumicion
		return restaurante.getMenu(3);
		
!!!149765.java!!!	requestBebidas() : Consumicion
		return restaurante.getMenu(0);
		
!!!149893.java!!!	communicateReserva(in año : int, in mes : int, in dia : int, in hora : int, in minutos : int, in cliente : String, in numeroComensales : int) : void
		Fecha fechaRes = new Fecha(año, mes, dia, hora, minutos);
		Reserva reserva = new Reserva(fechaRes, cliente, numeroComensales, null);
		restaurante.añadirReserva(reserva);
!!!150021.java!!!	comunicarComanda(in año : int, in mes : int, in dia : int, in hora : int, in minutos : int, in cliente : String, in numeroComensales : int) : void
		Fecha fechaRes = new Fecha(año, mes, dia, hora, minutos);
		Reserva reserva = new Reserva(fechaRes, cliente, numeroComensales, null);
		restaurante.añadirReserva(reserva);
!!!150149.java!!!	requestMesas() : MesaInfo
		return this.restaurante.getMesas();
!!!150277.java!!!	reservasDeUnCliente(in nombre : String) : ReservaInfo
		return this.restaurante.buscarReservas(nombre);
!!!150405.java!!!	getMesa(in j : int) : Mesa
		return restaurante.buscarMesa(j);
		
!!!150533.java!!!	getMesa(in j : String) : Mesa
		int i = Integer.parseInt(j);
		return restaurante.buscarMesa(i);
		
!!!150661.java!!!	avisaComanda(in numMesa : int, in comandaSelected : int) : void
		
!!!164741.java!!!	Menu()
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

		// postres.get(index)

!!!164869.java!!!	Menu(inout listaPrimeros : ArrayList<Consumicion>, inout listaSegundos : ArrayList<Consumicion>, inout listaBebidas : ArrayList<Consumicion>, inout listaPostres : ArrayList<Consumicion>)
		primeros = listaPrimeros;
		segundos = listaSegundos;
		bebidas = listaBebidas;
		postres = listaPostres;
!!!164997.java!!!	getPlatos(inout tipoPlato : TipoPlatos) : Consumicion
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
!!!165125.java!!!	deleteConsumicion(inout consumicion : Consumicion) : void
		dondeEsta(consumicion).remove(consumicion);//TODO notificar observer de borrado
		for (MenuObserver obs: observers)
			obs.deleteConsumption(consumicion.getNombre());
!!!165253.java!!!	dondeEsta(inout consumicion : Consumicion) : Consumicion
		for(Consumicion c: bebidas)
			if(c.getNombre().equals(consumicion.getNombre())) return bebidas;
		for(Consumicion c: primeros)
			if(c.getNombre().equals(consumicion.getNombre())) return primeros;
		for(Consumicion c: segundos)
			if(c.getNombre().equals(consumicion.getNombre())) return segundos;
		for(Consumicion c: postres)
			if(c.getNombre().equals(consumicion.getNombre())) return postres;
		return null;
!!!165381.java!!!	actualizaConsumicion(inout consAntigua : Consumicion, inout consNueva : Consumicion, inout tPlato : TipoPlatos) : void
		dondeEsta(consAntigua).remove(consAntigua);// TODO notificar observer de
													// borrado
		//TODO kike, mira los emitcambios que hay que hacer aqui, que no se
		addConsumicion(consNueva, tPlato);
		for (MenuObserver obs: observers)
			obs.addConsumption(consNueva.getNombre());
!!!165509.java!!!	addConsumicion(inout consumicion : Consumicion, inout tPlato : TipoPlatos) : void
		if (dondeEsta(consumicion) == null) {
			switch (tPlato) {
			case BEBIDA:
				bebidas.add(consumicion);
				break;// TODO notificar observers
			case PRIMERO:
				primeros.add(consumicion);
				break;
			case SEGUNDO:
				segundos.add(consumicion);
				break;
			case POSTRE:
				postres.add(consumicion);
				break;
			default:
				;
			}
			//TODO kike, esto no se si esta bien
			for (MenuObserver obs: observers)
				obs.addConsumption(consumicion.getNombre());
		}
!!!165637.java!!!	mostrarConsumiciones(inout consumiciones : ArrayList<Consumicion>) : String
		String[] nombres = null;
		/* bucle acumulando todas las consumiciones del array pasado */
		return nombres;

!!!165765.java!!!	getBebidas() : Consumicion
		return bebidas;
!!!165893.java!!!	getPrimeros() : Consumicion
		return primeros;
!!!166021.java!!!	getSegundos() : Consumicion
		return segundos;
!!!166149.java!!!	getPostres() : Consumicion
		return postres;
!!!166277.java!!!	stringConsumiciones(inout listaConsumiciones : ArrayList<Consumicion>) : String
		String str = "";
		for (Consumicion consumicion : listaConsumiciones)
			str += consumicion.toString();
		return str;
!!!166405.java!!!	toString() : String
		String menu = "";
		menu += "BeginMenu" + LINE_SEPARATOR + "BeginPrimeros" + LINE_SEPARATOR;
		menu += stringConsumiciones(primeros);
		menu += "EndPrimeros" + LINE_SEPARATOR + "BeginSegundos"
				+ LINE_SEPARATOR;
		menu += stringConsumiciones(segundos);
		menu += "EndSegundos" + LINE_SEPARATOR + "BeginBebidas"
				+ LINE_SEPARATOR;
		menu += stringConsumiciones(bebidas);
		menu += "EndBebidas" + LINE_SEPARATOR + "BeginPostres" + LINE_SEPARATOR;
		menu += stringConsumiciones(postres);
		menu += "EndPostres" + LINE_SEPARATOR + "EndMenu" + LINE_SEPARATOR;
		return menu;
!!!166533.java!!!	saveMenu(in fileName : String) : boolean
		String menu = toString();
		try {
			FileWriter fichero = new FileWriter(fileName + ".txt");
			PrintWriter printer = new PrintWriter(fichero);
			printer.println(menu);
			fichero.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
!!!166661.java!!!	getConsumicion(in name : String) : Consumicion
		for(Consumicion c: bebidas)
			if(c.getNombre().equals(name)) return c;
		for(Consumicion c: primeros)
			if(c.getNombre().equals(name)) return c;
		for(Consumicion c: segundos)
			if(c.getNombre().equals(name)) return c;
		for(Consumicion c: postres)
			if(c.getNombre().equals(name)) return c;
		return null;
!!!166789.java!!!	addObserver(inout verMenu : MenuObserver) : void
		observers.add(verMenu);
