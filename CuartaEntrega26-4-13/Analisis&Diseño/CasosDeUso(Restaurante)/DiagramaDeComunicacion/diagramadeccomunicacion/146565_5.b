class ListaComandas
!!!159877.java!!!	ListaComandas()
		
!!!160005.java!!!	añadirComanda(inout c : Comanda) : void
		
		
!!!160133.java!!!	actualizarComanda(inout c : Comanda) : void
		
!!!160261.java!!!	eliminarComanda(inout c : Comanda) : void
		
		
!!!162437.java!!!	generarFactura(inout listaComandas : List<Comanda>) : Comanda
		Comanda comanda = new Comanda();
		for (Comanda c : listaComandas)
			comanda.append(c);
		return comanda;
