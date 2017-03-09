package juegoDeCartas;

/**
 * Excepción que se lanza cuanto las cartas de la baraja se acaban.
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public class CartasAcabadasException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CartasAcabadasException(String msg) {
		super(msg);
	}
}
