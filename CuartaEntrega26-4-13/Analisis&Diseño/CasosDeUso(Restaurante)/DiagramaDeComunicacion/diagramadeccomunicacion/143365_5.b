class Restaurante
!!!162949.java!!!	Restaurante()
		this.mesas = new ArrayList<Mesa>(5);
		for (int i=0; i<5; i++)
			mesas.add(new Mesa(i));
		this.reservas = new LibroReservas();
		this.menu = new Menu();
!!!163077.java!!!	añadirReserva(inout reserva : Reserva) : void
		reservas.addReserva(reserva);
!!!163205.java!!!	buscarReservas(in nombre : String) : ReservaInfo
		return this.reservas.buscarReserva(nombre);
!!!163333.java!!!	getMenu() : Menu
		return menu;
!!!163461.java!!!	getMenu(in n : int) : Consumicion
		if (n == 0) return menu.getBebidas();
		else if (n == 1) return menu.getPrimeros();
		else if (n == 2) return menu.getSegundos();
		else if (n == 3) return menu.getPostres();
		else return null;
		
		
!!!163589.java!!!	setMenu(inout menu : Menu) : void
		this.menu = menu;
!!!163717.java!!!	buscarMesa(in i : int) : Mesa
		for (Mesa m: mesas) if (m.getNumeroMesa() == i) return m;
		return null;
!!!163845.java!!!	getMesas() : MesaInfo
		// TODO Auto-generated method stub
		return (MesaInfo[]) this.mesas.toArray();
!!!167173.java!!!	Mesa(in num : int)
		this.setNumeroMesa(num);
!!!167301.java!!!	addPedido(inout comanda : Comanda) : void
		comandas.add(comanda);
		//comandas.
!!!167429.java!!!	getNumeroMesa() : int
		return numeroMesa;
!!!167557.java!!!	setNumeroMesa(in numeroMesa : int) : void
		this.numeroMesa = numeroMesa;
!!!167685.java!!!	generarFactura() : String
		String factura = "";
		for (Comanda c : comandas){
			factura += c.toString() + LINE_SEPARATOR;
		}
		//return comandas.toString();
		return factura;
!!!167813.java!!!	getListaComandas() : ComandaInfo
		if (this.comandas != null) 
		return (ComandaInfo[]) this.comandas.toArray();
		else return null;
!!!167941.java!!!	avisaComanda(in comandaSelected : int) : void
		if (comandaActual != -1)
			//TODO, al dar al boton de generar comanda o elegir comanda en la vista correspondiente, se añadira el observador (supongo)
			//comandaActual.removeObserver(obs);
			//comandas.get(comandaSelected).addObserver(obs);
		comandaActual = comandaSelected;
!!!168069.java!!!	eliminaComanda(in comandaSelected : int) : void
		comandas.remove(comandaSelected);
		emitirCambios();
!!!168197.java!!!	addConsumption(in numComanda : int, inout plato : Consumicion, inout tPlato : TipoPlatos) : void
		//comandas.get(numComanda).addConsumicion(plato);
		switch (tPlato){
		case PRIMERO: comandas.get(numComanda).addPrimero(plato);
		case SEGUNDO: comandas.get(numComanda).addSegundo(plato);
		case POSTRE: comandas.get(numComanda).addPostre(plato);
		case BEBIDA: comandas.get(numComanda).addBebida(plato);
		}
!!!168325.java!!!	emitirCambios() : void
		for (MesaObserver o: obs)
			o.cambioOcurrido((ComandaInfo[]) comandas.toArray());
