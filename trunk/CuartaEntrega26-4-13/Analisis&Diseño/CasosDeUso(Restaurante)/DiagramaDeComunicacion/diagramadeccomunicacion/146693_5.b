class LibroReservas
!!!162565.java!!!	LibroReservas()
		listaReservas = new List<Reserva>();
		numeroReservas = 0;
!!!162693.java!!!	addReserva(inout res : Reserva) : boolean
		numeroReservas++;
		return listaReservas.add(res);

!!!162821.java!!!	reservasHoy() : ReservaInfo
		Date date = new Date();
		Fecha fecha = new Fecha(0,0,0,0,0);
		fecha.parse(date.toString(), 0, 0);
		ArrayList<ReservaInfo> reservasDeHoy = new ArrayList<ReservaInfo>();
		reservasDeHoy = buscarReservaHoy(fecha);
		return reservasDeHoy;
		
!!!162949.java!!!	reservasSemana() : ReservaInfo
		Date date = new Date();
		
		Fecha fecha = new Fecha(date.getYear(), date.getMonth(), date.getDay(), date.getHours(), date.getMinutes()); //new Date (hoy) o algo asi
		ArrayList<ReservaInfo> reservasSemana = new ArrayList<ReservaInfo>();
		reservasSemana = buscarReservaSemana(fecha);
		return reservasSemana;
		
!!!163077.java!!!	reservasMes() : ReservaInfo
		Date date = new Date();
		
		Fecha fecha = new Fecha(date.getYear(), date.getMonth(), date.getDay(), date.getHours(), date.getMinutes()); //new Date (hoy) o algo asi
		ArrayList<ReservaInfo> reservasMes = new ArrayList<ReservaInfo>();
		reservasMes = buscarReservaMes(fecha);
		return reservasMes;
		
!!!163205.java!!!	eliminarReserva(inout res : Reserva) : boolean
		numeroReservas--;
		return listaReservas.erase(res);
!!!163333.java!!!	buscarReserva(in nombre : String) : ReservaInfo
		ArrayList<ReservaInfo> listaRes = new ArrayList<ReservaInfo>();
		int i=0;
		while (i<listaReservas.size()){
			if (listaReservas.get(i).getNombre().equals(nombre)) ;
			//i++;
			listaRes.add(listaReservas.get(i));
		}
		//if (i < listaReservas.size()) return i;
		/*else*/ return listaRes;
!!!163461.java!!!	todasReservas() : ReservaInfo
		ArrayList<ReservaInfo> listaRes = new ArrayList<ReservaInfo>();
		for (int i = 0; i < this.numeroReservas; i++)
			listaRes.add(this.listaReservas.get(i));
			return listaRes;
!!!163589.java!!!	buscarReserva(in j : int) : ReservaInfo
		if (j == -1) return todasReservas();	
		if (j == 0) return reservasHoy();
		else if (j == 1) return reservasSemana();
		else if (j == 2) return reservasMes();		
		return null;
		/*int i=0;
		while (i<listaReservas.size()){
			if (listaReservas.get(i).getNombre().equals(nombre)) ;
			//i++;
			listaRes.add(listaReservas.get(i));
		}
		//if (i < listaReservas.size()) return i;
		//else return listaRes;*/
!!!163717.java!!!	buscarReservaHoy(inout date : Fecha) : ReservaInfo
		ArrayList <ReservaInfo> reservasHoy = new ArrayList<ReservaInfo>();
		for ( int i = 0; i < listaReservas.size(); i++){
			if (listaReservas.get(i).getFecha().mismoDia(date)) reservasHoy.add(listaReservas.get(i));
		}
		return reservasHoy;
!!!163845.java!!!	buscarReservaSemana(inout dateInicial : Fecha) : ReservaInfo
		ArrayList <ReservaInfo> reservasSemana = new ArrayList<ReservaInfo>();
		Fecha dateTope = dateInicial.siguienteSemana();
		for ( int i = 0; i < listaReservas.size(); i++){
			if (!listaReservas.get(i).getFecha().esMayorQue(dateTope) && (listaReservas.get(i).getFecha().esMayorQue(dateInicial) || listaReservas.get(i).getFecha().equals(dateInicial)))
					reservasSemana.add(listaReservas.get(i));
		}
		return reservasSemana;
!!!163973.java!!!	buscarReservaMes(inout dateInicial : Fecha) : ReservaInfo
		ArrayList<ReservaInfo> reservasSemana = new ArrayList<ReservaInfo>();
		Fecha dateTope = dateInicial.siguienteSemana();
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < listaReservas.size(); i++) {
				if (!listaReservas.get(i).getFecha().esMayorQue(dateTope)
						&& (listaReservas.get(i).getFecha()
								.esMayorQue(dateInicial) || listaReservas
								.get(i).getFecha().equals(dateInicial)))
					reservasSemana.add(listaReservas.get(i));
				dateInicial = dateInicial.siguienteSemana();
				dateTope = dateTope.siguienteSemana();

			}
		}
		return reservasSemana;
!!!164101.java!!!	buscarReserva(inout fecha : Fecha) : ReservaInfo
		// TODO Auto-generated method stub
		return null;
