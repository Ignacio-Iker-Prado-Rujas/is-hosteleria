class Restaurante
!!!169605.java!!!	Restaurante()
		this.mesas = new ArrayList<Mesa>(5);
		for (int i=0; i<5; i++)
			mesas.add(new Mesa(i));
		this.reservas = new LibroReservas();
		this.menu = new Menu();
!!!169733.java!!!	añadirReserva(inout reserva : Reserva) : void
		reservas.addReserva(reserva);
!!!169861.java!!!	buscarReservas(in nombre : String) : ReservaInfo
		return this.reservas.buscarReserva(nombre);
!!!169989.java!!!	buscarReservas(in i : int) : ReservaInfo
		return this.reservas.buscarReserva(i);
!!!170117.java!!!	getMenu() : Menu
		return menu;
!!!170245.java!!!	getMenu(in n : int) : Consumicion
		if (n == 0) return menu.getBebidas();
		else if (n == 1) return menu.getPrimeros();
		else if (n == 2) return menu.getSegundos();
		else if (n == 3) return menu.getPostres();
		else return null;
		
		
!!!170373.java!!!	setMenu(inout menu : Menu) : void
		this.menu = menu;
!!!170501.java!!!	buscarMesa(in i : int) : Mesa
		for (Mesa m: mesas) if (m.getNumeroMesa() == i) return m;
		return null;
!!!170629.java!!!	avisaComanda(in numMesa : int, in comandaSelected : int) : void
		mesas.get(numMesa).avisaComanda(comandaSelected);
!!!170757.java!!!	eliminaComanda(in numMesa : int, in comandaSelected : int) : void
		mesas.get(numMesa).eliminaComanda(comandaSelected);
!!!170885.java!!!	addNewConsumption(in numComanda : int, in numMesa : int, inout plato : Consumicion, inout tPlato : TipoPlatos) : void
		mesas.get(numMesa).addConsumption(numComanda, plato, tPlato);
!!!171013.java!!!	getMesas() : MesaInfo
		// TODO Auto-generated method stub
		MesaInfo[] infoMesas = new MesaInfo[this.mesas.size()];
		for (int i=0; i<this.mesas.size(); i++)
			infoMesas[i] = this.mesas.get(i);
		return infoMesas;//(MesaInfo[]) this.mesas.toArray();
!!!171141.java!!!	actualizaConsumicion(inout consAntigua : Consumicion, inout consNueva : Consumicion, inout tPlato : TipoPlatos) : void
		menu.actualizaConsumicion(consAntigua, consNueva, tPlato);
!!!171269.java!!!	deleteConsumicion(inout consumicion : Consumicion) : void
		menu.deleteConsumicion(consumicion);
!!!171397.java!!!	addConsumicion(inout consumicion : Consumicion, inout tPlato : TipoPlatos) : void
		menu.addConsumicion( consumicion, tPlato);
!!!171525.java!!!	registerMenuObserver(inout verMenu : MenuObserver) : void
		menu.addObserver(verMenu);
