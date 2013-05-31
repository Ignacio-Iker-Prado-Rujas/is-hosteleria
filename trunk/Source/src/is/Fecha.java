package is;

public class Fecha {
	/**
	 * 
	 * @param año
	 * @param mes
	 * @param dia
	 * @param hora
	 * @param minutos
	 */
	public Fecha(int año, int mes, int dia, int hora, int minutos){
		this.año = año;
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
		this.minutos = minutos;
		
		
	}
	/**
	 * @return the año
	 */
	public int getAño() {
		return año;
	}

	/**
	 * @return the mes
	 */
	public int getMes() {
		return mes;
	}

	/**
	 * @return the dia
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * @return the hora
	 */
	public int getHora() {
		return hora;
	}

	/**
	 * @return the minutos
	 */
	public int getMinutos() {
		return minutos;
	}

	/**
	 * @param año the año to set
	 */
	public void setAño(int año) {
		this.año = año;
	}

	/**
	 * @param mes the mes to set
	 */
	public void setMes(int mes) {
		this.mes = mes;
	}

	/**
	 * @param dia the dia to set
	 */
	public void setDia(int dia) {
		this.dia = dia;
	}

	/**
	 * @param hora the hora to set
	 */
	public void setHora(int hora) {
		this.hora = hora;
	}

	/**
	 * @param minutos the minutos to set
	 */
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public void sumaDias(int dias){
		int 
	}
	
	public boolean esBisiesto() {
	    return ((this.año % 4 == 0 && this.año % 100 != 0) || this.año % 400 == 0);
	}
	public boolean esMayorQue(Fecha fecha2){
		
		return ((this.año > fecha2.año) ||
				(this.año == fecha2.año && this.mes > fecha2.mes) ||
				(this.año == fecha2.año && this.mes == fecha2.mes && this.dia > fecha2.dia) ||
				(this.año == fecha2.año && this.mes == fecha2.mes && this.dia == fecha2.dia && 
					this.hora > fecha2.hora) ||
				(this.año == fecha2.año && this.mes == fecha2.mes && this.dia == fecha2.dia && 
					this.hora == fecha2.hora && this.minutos > fecha2.minutos));
		
	}
	
	public boolean equals(Fecha fecha2){
		return (this.año == fecha2.año && this.mes == fecha2.mes && this.dia == fecha2.dia && this.hora == fecha2.hora && this.minutos == fecha2.minutos);
	}


	private int año;
	private int mes;
	private int dia;
	
	private int hora;
	private int minutos;
}
