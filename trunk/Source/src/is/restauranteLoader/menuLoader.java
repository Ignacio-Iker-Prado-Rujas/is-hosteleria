package is.restauranteLoader;

import is.restaurante.Menu;
import is.restaurante.consumicion.Consumicion;
import is.restaurante.consumicion.Plato;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;


/**
 * Gestiona la carga del menú desde archivo.
 * @author Villarin
 */

public class menuLoader {

	/**
	 * Comprueba que el siguiente token que se lee es un String que coincide con
	 * la cadena que se pasa. En caso de no coincidir se lanza una excepcion.
	 * 
	 * @param str
	 *            - Cadena que se espera leer.
	 * @throws IOException
	 */
	private void forceString(String str) throws IOException {
		if (!(tokenizer.nextToken() == StreamTokenizer.TT_WORD && tokenizer.sval
				.equals(str))) {
			System.err.println("Fichero dañado");
			System.exit(1);
		}
	}

	/**
	 * Comprueba que el siguiente token leido es un String. En caso de serlo y
	 * coincidir con algunos de los parametros se devuelve un booleano. En caso
	 * contrario se lanza una excepcion.
	 * 
	 * @param str1
	 *            - Primer String valido.
	 * @param str2
	 *            - Segundo String valido.
	 * @return True si el token coincide con el primer String y False si
	 *         coincide con el segundo.
	 * @throws IOException
	 */
	private Boolean forceString(String str1, String str2) throws IOException {
		if (tokenizer.nextToken() == StreamTokenizer.TT_WORD)
			if (tokenizer.sval.equals(str1))
				return true;
			else if (tokenizer.sval.equals(str2))
				return false;
			else {
				System.err.println("Fichero dañado");
				System.exit(1);
			}
		else {
			System.err.println("Fichero dañado");
			System.exit(1);
		}
		return null;
	}

	private float forceFloat() throws IOException {
		if (tokenizer.nextToken() != StreamTokenizer.TT_NUMBER) {
			System.err.println("Fichero dañado");
			System.exit(1);
		}
		return (float) tokenizer.nval;
	}

	private String peek() throws IOException {
		if (tokenizer.nextToken() == StreamTokenizer.TT_WORD)
			return tokenizer.sval;
		return "";
	}

	private ArrayList<Consumicion> forceConsumicion(String tipo)
			throws IOException {
		ArrayList<Consumicion> platos = new ArrayList<Consumicion>();
		while (!peek().equals(tipo)) {
			tokenizer.pushBack();
			tokenizer.nextToken();
			String name = tokenizer.sval;
			tokenizer.nextToken();
			String descripcion = tokenizer.sval;
			float precio = forceFloat();
			boolean disponible = forceString("Disponible", "NoDisponible");
			Plato plato = new Plato(name, precio, disponible, descripcion);
			platos.add(plato);
		}
		return platos;
	}

	public Menu loadMenu(String fileName) throws IOException {
		FileInputStream file;
		try {
			file = new FileInputStream(fileName);
			tokenizer = new StreamTokenizer(new InputStreamReader(file));
			tokenizer.wordChars('\u0021', '\u007E');
			tokenizer.quoteChar('"');
			forceString("BeginMenu");
			forceString("BeginPrimeros");
			ArrayList<Consumicion> listaPrimeros = forceConsumicion("EndPrimeros");
			forceString("BeginSegundos");
			ArrayList<Consumicion> listaSegundos = forceConsumicion("EndSegundos");
			forceString("BeginBebidas");
			ArrayList<Consumicion> listaBebidas = forceConsumicion("EndBebidas");
			forceString("BeginPostres");
			ArrayList<Consumicion> listaPostres = forceConsumicion("EndPostres");
			forceString("EndMenu");
			return new Menu(listaPrimeros, listaSegundos, listaBebidas,
					listaPostres);
		} catch (FileNotFoundException e) {
			System.err.println("El fichero no existe");
			return null;
		}
	}

	private StreamTokenizer tokenizer;
}
