package utiles;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Permite lectura desde teclado
 */
public class Teclado {

	/**
	 * Lee un carácter del teclado
	 * 
	 * @return carácter introducido por el usuario
	 */
	public static char leerCaracter() {
		char caracter;
		boolean comprobar = true;
		do {
			try {
				caracter = leerCadena().charAt(0);
				comprobar = false;
			} catch (Exception e) {
				caracter = 0;
			}
		} while (comprobar);
		return caracter;
	}

	/**
	 * Lee un carácter del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return carácter introducido por el usuario
	 */
	public static char leerCaracter(String msj) {
		System.out.print(msj);
		return leerCaracter();
	}

	/**
	 * Lee una cadena del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return cadena introducida por el usuario
	 */
	public static String leerCadena(String msj) {
		System.out.print(msj);
		return leerCadena();
	}

	/**
	 * Lee una cadena del teclado
	 * 
	 * @return cadena introducida por el usuario
	 */

	public static String leerCadena() {
		boolean comprobar = true;
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String cadena;
		do {
			try {
				cadena = bReader.readLine(); // Lee una línea de texto (hasta
												// intro)
				comprobar = false;
			} catch (Exception e) {
				cadena = "";
			}
		} while (comprobar);
		return cadena;
	}

	/**
	 * Lee un entero del teclado
	 * 
	 * 
	 * @return entero introducido por el usuario
	 */
	public static int leerEntero() {
		boolean comprobar = true;
		int x;
		do {
			try {
				x = Integer.parseInt(leerCadena().trim()); // Quita los espacios
															// del
															// String y
															// convierte a
															// int
				comprobar = false;
			} catch (Exception e) {
				x = 0;
			}
		} while (comprobar);
		return x;
	}

	/**
	 * Lee un entero positivo del teclado
	 * 
	 * 
	 * @return entero introducido por el usuario
	 */
	public static int leerEnteroPositivo() {
		int x;
		try {
			do {
				x = Integer.parseInt(leerCadena().trim()); // Quita los espacios
															// del String y
															// convierte a int
			} while (x <= 0);

		} catch (Exception e) {
			x = 0;
		}
		return x;
	}

	/**
	 * Lee una entero del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return entero introducida por el usuario
	 */
	public static int leerEntero(String msj) {
		System.out.print(msj);
		return leerEntero();
	}

	/**
	 * Lee una entero positivo del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return entero introducida por el usuario
	 */
	public static int leerEnteroPositivo(String msj) {
		System.out.print(msj);
		return leerEnteroPositivo();
	}

	/**
	 * Lee un decimal del teclado
	 * 
	 * @return decimal introducido por el usuario
	 */
	public static double leerDecimal() {
		double x;
		boolean comprobar = true;
		do {

			try {
				x = Double.parseDouble(leerCadena().trim()); // Quita los
																// espacios
																// del String y
																// convierte a
																// double
				comprobar = false;
			} catch (Exception e) {
				x = 0;
			}
		} while (comprobar);
		return x;
	}

	/**
	 * Lee una decimal del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return decimal introducida por el usuario
	 */
	public static double leerDecimal(String msj) {
		System.out.print(msj);
		return leerDecimal();
	}

}