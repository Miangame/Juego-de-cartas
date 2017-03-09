package utiles;

/**
 * Clase que muestra un men� y recoge la opcion introducida
 * 
 * @author Miguel �ngel Gavil�n Merino
 *
 */
public class Menu {
	/**
	 * Titulo y opciones del men�
	 */
	String titulo;
	String [] opciones;
	
	/**
	 * Constructor de la clase Menu que establece un t�tulo y las distintas opciones de este
	 * @param titulo Titulo del men�
	 * @param opciones Opciones del men�
	 */
	public Menu(String titulo, String [] opciones) {
		setTitulo(titulo);
		setOpciones(opciones);
	}

	/**
	 * Devuelve el t�tulo del men�
	 * @return T�tulo del  men�
	 */
	private String getTitulo() {
		return titulo;
	}

	/**
	 * Asigna un t�tulo al campo titulo de la clase
	 * @param titulo
	 */
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Devuelve un vector con las distintas opciones del men�
	 * @return Vector con las opciones
	 */
	private String[] getOpciones() {
		return opciones;
	}

	/**
	 * Asigna un vector de opciones al vector de la clase
	 * @param opciones Vector con las opciones
	 */
	private void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}
	
	/**
	 * Muestra el men� y recoge la opcion
	 * @return Opci�n recogida por el teclado
	 */
	public int gestionar(){
		mostrar();
		return recogerOpcion();
	}
	
	/**
	 * Muestra el t�tulo y las distintas opciones del menu
	 */
	private void mostrar(){
		System.out.println(getTitulo());
		for (int i = 0; i < getOpciones().length; i++) {
			System.out.println("\n\t" + (i+1) + ". " + getOpciones()[i]);
		}
	}
	
	/**
	 * Recoge una opcion por teclado
	 * @return Opci�n recogida
	 */
	private int recogerOpcion(){
		int resultado;
		
		do{
			resultado = Teclado.leerEntero("\n>>>Opcion: ");
		}while(resultado <= 0 || resultado>opciones.length);
		
		return resultado;
	}
	

}
