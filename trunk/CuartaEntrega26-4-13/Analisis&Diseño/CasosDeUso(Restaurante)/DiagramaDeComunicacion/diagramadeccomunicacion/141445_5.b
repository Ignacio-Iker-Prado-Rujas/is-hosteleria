class Fecha
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
!!!146309.java!!!	List()
		list = new Object[MIN_VALUE];
		size = 0;
!!!146437.java!!!	size() : int
		return this.size;
!!!146565.java!!!	get(inout object : Tipo) : Tipo
		if (object != null) {
			int pos = binary(object, 0, size - 1);
			if (object.compareTo((Tipo) list[pos]) == 0)
				return (Tipo) list[pos];
		}
		return null;
!!!146693.java!!!	get(in i : int) : Tipo
		if (i >= this.size())
			return null;
		else return (Tipo) list[i];
!!!146821.java!!!	add(inout object : Tipo) : boolean
		if (object == null)
			return false;
		int pos = binary(object, 0, size - 1);
		if (object.compareTo((Tipo) list[pos]) == 0)
			return false;
		else {
			if (size == list.length)
				biggerList();
			for (int i = size; i > pos; i--)
				list[i] = list[i - 1];
			list[pos] = object;
			size++;
			return true;
		}
!!!146949.java!!!	erase(inout object : Tipo) : boolean
		if (object != null) {
			int pos = binary(object, 0, size - 1);
			if (object.compareTo((Tipo) list[pos]) == 0) {
				list[pos] = null;
				size--;
				for (int i = pos; i < size; i++)
					list[i] = list[i + 1];
				return true;
			}
		}
		return false;
!!!147077.java!!!	biggerList() : void
		Object[] object = new Object[2 * size];
		for (int i = 0; i < size; i++)
			object[i] = list[i];
		list = object;
!!!147205.java!!!	binary(inout object : Tipo, in first : int, in last : int) : int
		if (first > last)
			return first;
		int pos = (first + last) / 2;
		if (object.compareTo((Tipo) list[pos]) < 0)
			return binary(object, first, pos - 1);
		if (object.compareTo((Tipo) list[pos]) > 0)
			return binary(object, pos + 1, last);
		return pos;
