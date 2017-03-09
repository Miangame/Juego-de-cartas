package utiles;

/**
 * Distintas utilidades para usarlas en nuestros programas
 * 
 * @author Miguel �ngel Gavil�n Merino
 *
 */
public class Utilidades {

	/**
	 * Genera un entero aleatorio entre un minimo y un maximo
	 * 
	 * @param min
	 *            N�mero m�nimo para generar n�meros aleatorios
	 * @param max
	 *            N�mero m�ximo para generar n�meros aleatorios
	 * @return N�mero aleatorio generado
	 */
	public static int generarEnteroAleatorio(int min, int max) {
		return (int) (Math.round(Math.random() * (max - min) + min));
	}

	/**
	 * Genera un decimal aleatorio entre un minimo y un maximo
	 * 
	 * @param min
	 *            N�mero m�nimo para generar n�meros aleatorios
	 * @param max
	 *            N�mero m�ximo para generar n�meros aleatorios
	 * @return N�mero aleatorio generado
	 */
	public static double generarDecimalAleatorio(int min, int max) {
		return (Math.random() * (max - min) + min);
	}

	/**
	 * Muestra un vector pasado por argumentos
	 * 
	 * @param vector
	 *            Vector que se va a mostrar
	 */
	public static void mostrarVectorEnteros(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i]);
			if (i < vector.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	/**
	 * Metodo que devuelve true si se desea continuar o false si no se quiere
	 * continuar
	 * 
	 * @return true o false
	 */
	public static boolean deseaContinuar(String mensaje) {
		do {
			System.out.print(mensaje);
			switch (Teclado.leerCaracter()) {
			case 's':
			case 'S':
				return true;
			case 'n':
			case 'N':
				return false;
			default:
				System.out.println("\nIntroduzca una opcion correcta");
			}// switch
		} while (true);
	}

}
