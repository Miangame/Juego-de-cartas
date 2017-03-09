package juegoDeCartas;

/**
 * Excepción que se lanza cuando un alias está repetido
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public class AliasYaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AliasYaExisteException(String msg) {
		super(msg);
	}

}
