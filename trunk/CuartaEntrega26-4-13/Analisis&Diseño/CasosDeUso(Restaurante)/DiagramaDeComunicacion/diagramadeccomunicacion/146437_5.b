class LibroReservas
!!!159109.java!!!	LibroReservas()
		listaReservas = new List<Reserva>();
		numeroReservas = 0;
!!!159237.java!!!	addReserva(inout res : Reserva) : boolean
		numeroReservas++;
		return listaReservas.add(res);

!!!159365.java!!!	reservasHoy() : Reserva
		Date date = new Date();
		Fecha fecha = new Fecha(0, 0, 0, 0, 0); //new Date (hoy) o algo asi
		ArrayList<Reserva> reservasDeHoy = new ArrayList<Reserva>();
		buscarReservaHoy(fecha);
		Fecha hoy = new Fecha(date.getYear(),
		date.getMonth(),
		date.getDay(),
		date.getHours(),
		date.getMinutes());

		for (int i=0; i< listaReservas.size(); i++){
			if (listaReservas.get(i).equals(hoy))
				reservasDeHoy.add(listaReservas.get(i));
		}
		
		
		return reservasDeHoy;
		
!!!159493.java!!!	eliminarReserva(inout res : Reserva) : boolean
		numeroReservas--;
		return listaReservas.erase(res);
!!!159621.java!!!	buscarReserva(in nombre : String) : ReservaInfo
		ArrayList<ReservaInfo> listaRes = new ArrayList<ReservaInfo>();
		int i=0;
		while (i<listaReservas.size()){
			if (listaReservas.get(i).getNombre().equals(nombre)) ;
			//i++;
			listaRes.add(listaReservas.get(i));
		}
		//if (i < listaReservas.size()) return i;
		/*else*/ return listaRes;
!!!159749.java!!!	buscarReservaHoy(inout date : Fecha) : ReservaInfo
		ArrayList <ReservaInfo> reservasHoy = new ArrayList<ReservaInfo>();
		for ( int i = 0; i < listaReservas.size(); i++){
			if (listaReservas.get(i).getFecha().mismoDia(date)) reservasHoy.add(listaReservas.get(i));
		}
		return reservasHoy;
!!!172549.java!!!	Bebida(in name : String, in price : float, inout disp : boolean, in desc : String)
		this.descripcion = desc;
		this.precio = price;
		this.nombre = name;
		this.disponible = disp;
!!!172677.java!!!	getPrecio() : float
		// TODO Auto-generated method stub
		return this.precio;
!!!172805.java!!!	getNombre() : String
		// TODO Auto-generated method stub
		return this.nombre;
!!!172933.java!!!	getDescripcion() : String
		// TODO Auto-generated method stub
		return this.descripcion;
!!!173061.java!!!	isDisponible() : boolean
		// TODO Auto-generated method stub
		return this.disponible;
!!!173189.java!!!	toString() : String
		String str = "";
		str += "\"" + nombre + "\" \"" + descripcion + "\" " + precio + " ";
		if (disponible)
			str += "Disponible";
		else
			str += "NoDisponible";
		str += LINE_SEPARATOR;
		return str;
