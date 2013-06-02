class Bebida
!!!164741.java!!!	Bebida(in name : String, in price : int, inout disp : boolean, in desc : String)
		this.descripción = desc;
		this.precio = price;
		this.nombre = name;
		this.disponible = disp;
!!!164869.java!!!	getPrecio() : float
		// TODO Auto-generated method stub
		return this.precio;
!!!164997.java!!!	getNombre() : String
		// TODO Auto-generated method stub
		return this.nombre;
!!!165125.java!!!	getDescripcion() : String
		// TODO Auto-generated method stub
		return this.descripción;
!!!165253.java!!!	isDisponible() : boolean
		// TODO Auto-generated method stub
		return this.disponible;
!!!159877.java!!!	Comanda()
		comanda = new HashMap[4];
		for (int i = 0; i < 4; i++)
			comanda[i] = new HashMap<Consumicion, Integer>();
!!!160005.java!!!	addObserver(inout obs : ComandaObserver) : void
		this.observers.add(obs);
!!!160133.java!!!	addConsumicion(inout consumicion : Consumicion, in index : int) : void
		if (comanda[index].containsKey(consumicion)) {
			comanda[index]
					.put(consumicion, comanda[index].get(consumicion) + 1);
		} else
			comanda[index].put(consumicion, 1);
		this.precio += consumicion.getPrecio();
		emitirCambio();
!!!160261.java!!!	deleteConsumicion(inout consumicion : Consumicion, in index : int) : void
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
!!!160389.java!!!	addPrimero(inout primero : Consumicion) : void
		addConsumicion(primero, 0);
!!!160517.java!!!	deletePrimero(inout primero : Consumicion) : void
		deleteConsumicion(primero, 0);
!!!160645.java!!!	setVecesPrimero(inout primero : Consumicion) : void

!!!160773.java!!!	addSegundo(inout segundo : Consumicion) : void
		addConsumicion(segundo, 1);
!!!160901.java!!!	deleteSegundo(inout segundo : Consumicion) : void
		deleteConsumicion(segundo, 1);
!!!161029.java!!!	setVecesSegundo(inout segundo : Consumicion) : void

!!!161157.java!!!	addPostre(inout postre : Consumicion) : void
		addConsumicion(postre, 2);
!!!161285.java!!!	deletePostre(inout postre : Consumicion) : void
		deleteConsumicion(postre, 2);
!!!161413.java!!!	setVecesPostre(inout postre : Consumicion) : void

!!!161541.java!!!	addBebida(inout bebida : Consumicion) : void
		addConsumicion(bebida, 3);
!!!161669.java!!!	deleteBebida(inout bebida : Consumicion) : void
		deleteConsumicion(bebida, 3);
!!!161797.java!!!	setVecesBebidas(inout drinking : Bebida) : void

!!!161925.java!!!	append(inout other : Comanda) : void
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
!!!162053.java!!!	toString() : String
		String pedido = "";
		for (int i = 0; i < 4; i++)
			for (Entry<Consumicion, Integer> entry : comanda[i].entrySet()) {
				pedido = pedido + entry.getKey().getNombre() + " "
						+ entry.getKey().getPrecio() + " Cantidad: "
						+ comanda[i].get(entry.getKey()) + LINE_SEPARATOR;
			}
		pedido += "TOTAL: " + this.precio;
		return pedido;
!!!162181.java!!!	lista() : Consumicion
		return null;

!!!162309.java!!!	emitirCambio() : void
		for (ComandaObserver obs : observers)
			obs.comandaHaCambiado(this.toString());
