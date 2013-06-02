package is.restauranteLoader;

import java.io.IOException;
import java.io.StreamTokenizer;

public abstract class Loader {
	/**
	 * Comprueba que el siguiente token que se lee es un String que coincide con
	 * la cadena que se pasa. En caso de no coincidir se lanza una excepcion.
	 * 
	 * @param str
	 *            - Cadena que se espera leer.
	 * @throws IOException
	 */
	protected void forceString(String str) throws IOException {
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
	protected Boolean forceString(String str1, String str2) throws IOException {
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

	protected float forceFloat() throws IOException {
		if (tokenizer.nextToken() != StreamTokenizer.TT_NUMBER) {
			System.err.println("Fichero dañado");
			System.exit(1);
		}
		return (float) tokenizer.nval;
	}

	protected String peek() throws IOException {
		if (tokenizer.nextToken() == StreamTokenizer.TT_WORD)
			return tokenizer.sval;
		return "";
	}

	protected StreamTokenizer tokenizer;
}
