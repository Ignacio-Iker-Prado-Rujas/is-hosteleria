package is;

public class Fecha {
	
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

	
	
	public boolean esMayorQue(Fecha fecha2){
		if (this.año > fecha2.año) return true;
			else if (this.año == fecha2.año){
				if (this.mes > fecha2.mes) return true;
				else if (this.mes == fecha2.mes){
					if (this.dia > fecha2.dia)return true;
					else if (this.)
				}
			}
	}


	private int año;
	private int mes;
	private int dia;
	
	private int hora;
	private int minutos;
}
