package is.restaurante;

import java.util.ArrayList;

public class Tablon {

	public Tablon(){
		notas = new ArrayList<String>();
	}
	public void crearNota(String nota){
		notas.add(nota);
	}
	
	private ArrayList<String> notas;
}
