class Cliente
!!!143493.java!!!	getName() : String
		return name;
!!!143621.java!!!	setName(in name : String) : void
		this.name = name;
!!!143749.java!!!	Fecha(in año : int, in mes : int, in dia : int, in hora : int, in minutos : int)
		this.año = año;
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
		this.minutos = minutos;
		
		
!!!143877.java!!!	getAño() : int
		return año;
!!!144005.java!!!	getMes() : int
		return mes;
!!!144133.java!!!	getDia() : int
		return dia;
!!!144261.java!!!	getHora() : int
		return hora;
!!!144389.java!!!	getMinutos() : int
		return minutos;
!!!144517.java!!!	setAño(in año : int) : void
		this.año = año;
!!!144645.java!!!	setMes(in mes : int) : void
		this.mes = mes;
!!!144773.java!!!	setDia(in dia : int) : void
		this.dia = dia;
!!!144901.java!!!	setHora(in hora : int) : void
		this.hora = hora;
!!!145029.java!!!	setMinutos(in minutos : int) : void
		this.minutos = minutos;
!!!145157.java!!!	siguienteSemana() : Fecha
		if (this.esBisiesto()) this.diasMes[1]++;
		int numDia = this.dia;
		numDia += 7;
		int mes = this.mes, año = this.año;
		int div = numDia / this.diasMes[this.mes-1];
		
		numDia = numDia % this.diasMes[this.mes-1];
		if (div == 1){
			if (this.mes == 12){
				año = this.año+1;
			}else this.mes++;
		}
		
		if (this.esBisiesto()) this.diasMes[1]--;
		return new Fecha(año, mes, dia, this.hora, this.minutos);	
!!!145285.java!!!	esBisiesto() : boolean
	    return ((this.año % 4 == 0 && this.año % 100 != 0) || this.año % 400 == 0);
!!!145413.java!!!	esMayorQue(inout fecha2 : Fecha) : boolean
		
		return ((this.año > fecha2.año) ||
				(this.año == fecha2.año && this.mes > fecha2.mes) ||
				(this.año == fecha2.año && this.mes == fecha2.mes && this.dia > fecha2.dia) ||
				(this.año == fecha2.año && this.mes == fecha2.mes && this.dia == fecha2.dia && 
					this.hora > fecha2.hora) ||
				(this.año == fecha2.año && this.mes == fecha2.mes && this.dia == fecha2.dia && 
					this.hora == fecha2.hora && this.minutos > fecha2.minutos));
		
!!!145541.java!!!	equals(inout fecha2 : Fecha) : boolean
		return (this.año == fecha2.año && this.mes == fecha2.mes && this.dia == fecha2.dia && this.hora == fecha2.hora && this.minutos == fecha2.minutos);
!!!145669.java!!!	mismoDia(inout f : Fecha) : boolean
		return (this.año == f.año && this.mes == f.mes && this.dia == f.dia);
!!!145797.java!!!	parse(in cad : String) : Fecha
		
		String[] comando = cad.split(" ");
		this.año = Integer.parseInt(comando[0]);
		this.mes = Integer.parseInt(comando[1]);
		this.dia = Integer.parseInt(comando[2]);
		this.hora = Integer.parseInt(comando[3]);
		this.minutos = Integer.parseInt(comando[4]);
		return this;
		
!!!145925.java!!!	parseMonth(in cad : String) : int
		if (cad.equalsIgnoreCase("Jan")) return 0;
		else if (cad.equalsIgnoreCase("Feb")) return 1;
		else if (cad.equalsIgnoreCase("Mar")) return 2;
		else if (cad.equalsIgnoreCase("Apr")) return 3;
		else if (cad.equalsIgnoreCase("May")) return 4;
		else if (cad.equalsIgnoreCase("Jun")) return 5;
		else if (cad.equalsIgnoreCase("Jul")) return 6;
		else if (cad.equalsIgnoreCase("Aug")) return 7;
		else if (cad.equalsIgnoreCase("Sep")) return 8;
		else if (cad.equalsIgnoreCase("Oct")) return 9;
		else if (cad.equalsIgnoreCase("Nov")) return 10;
		else if (cad.equalsIgnoreCase("Dec")) return 11;
		else return 0;
!!!146053.java!!!	parse(in cad : String, in horas : int, in minutos : int) : Fecha
		String[] comando = cad.split(" ");
		for (int i=0; i< comando.length; i++){
			System.out.println(comando[i] + " ");
		}
		this.año = Integer.parseInt(comando[5], 10);
		
		this.mes = parseMonth(comando[1]);
		 
		this.dia = Integer.parseInt(comando[2], 10);
		this.hora = horas;
		this.minutos = minutos;
		return this;
!!!146181.java!!!	toString() : String
		return this.dia + "/" + (this.mes+1) + "/" + this.año + " "
				+ (this.hora < 10 ? "0" + this.hora : this.hora) + ":"
				+ (this.minutos < 10 ? "0" + this.minutos : this.minutos);
