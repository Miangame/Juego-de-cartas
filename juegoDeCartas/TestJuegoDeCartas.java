package juegoDeCartas;

import java.util.ArrayList;
import utiles.Menu;
import utiles.TecladoScanner;
import utiles.Utilidades;

public class TestJuegoDeCartas {
	/**
	 * Opciones para el menú principal
	 */
	static String[] opciones = { "Gestión de jugadores", "Jugar", "Salir" };

	/**
	 * Menú principal
	 */
	static Menu menuPpal = new Menu("\n---Juego de cartas---", opciones);

	/**
	 * Opciones para el menú que gestiona los jugadores
	 */
	static String[] opcionesJugadores = { "Dar de alta", "Mostrar ranking", "Dar de baja", "Volver al menú principal" };

	/**
	 * Menú que gestiona los jugadores
	 */
	static Menu menuJugadores = new Menu("\n---Gestión de jugadores---", opcionesJugadores);

	/**
	 * Opciones para el menú jugar
	 */
	static String[] opcionesJugar = {};

	/**
	 * Menu jugar
	 */
	static Menu menuJugar = new Menu("\n---Menú jugar---", opcionesJugar);

	/**
	 * Creación de una nueva partida
	 */
	static Partida partida;

	/**
	 * Array con todos los jugadores
	 */
	static Jugadores jugadoresTotales = new Jugadores();

	public static void main(String[] args) {
		int opcion;

		do {
			opcion = menuPpal.gestionar();
			switch (opcion) {
			case 1:
				gestionarJugadores();
				break;

			case 2:
				jugar();
				break;

			default:
				System.out.println("\nSALIENDO...");
				break;
			}
		} while (opcion != 3);
	}

	/**
	 * Gestiona los jugadores mediante un menú. Puede dar de alta, mostrar el
	 * ranking o dar de baja.
	 */
	private static void gestionarJugadores() {
		int opcion = menuJugadores.gestionar();
		do {
			switch (opcion) {
			case 1:
				try {
					annadirJugador();
				} catch (AliasYaExisteException e) {
					System.err.println(e.getMessage());
				}
				return;

			case 2:
				try {
					System.out.println(jugadoresTotales.ranking());
				} catch (JugadorNoExisteException e) {
					System.err.println(e.getMessage());
				}
				return;

			case 3:
				eliminarJugador();
				return;

			default:
				return;
			}
		} while (opcion != 4);
	}

	/**
	 * Elimina a un jugador de la lista
	 */
	public static void eliminarJugador() {
		try {
			jugadoresTotales.eliminar(jugadoresTotales.listarJugadores("\n---Escoja el jugador que desea eliminar---"));
		} catch (JugadorNoExisteException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Muestra los jugadores de un arrayList pasado por parametro
	 * 
	 * @param jugadores
	 *            ArrayList con los jugadores
	 */
	private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
		if (jugadoresTotales.isEmpty())
			System.out.println("\nNo existen jugadores");

		int i = 1;
		for (Jugador jugador : jugadores) {
			System.out.println("\n\t" + i + ". " + jugador.getAlias());
			i++;
		}
	}

	/**
	 * Método para jugar
	 */
	private static void jugar() {
		ArrayList<Jugador> participantes;

		if (jugadoresTotales.isEmpty() || jugadoresTotales.size() < 2) {
			System.out.println("\nLos jugadores son insuficientes.");
			return;
		}

		participantes = pedirJugadores(); // Pide los jugadores que van a
											// participar
		System.out.println("\nVan a jugar:");
		mostrarJugadores(participantes); // Muestra los jugadores que van a
											// participar
		partida = new Partida(participantes); // Crea una nueva partida con los
												// participantes
		try {
			partida.jugar();
		} catch (CartasAcabadasException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Pide los jugadores que van a participar de entre los jugadores totales
	 * 
	 * @return participantess
	 */
	private static ArrayList<Jugador> pedirJugadores() {
		ArrayList<Jugador> participantes = new ArrayList<Jugador>(); // ArrayList
																		// con
																		// los
																		// participantes
		int numJugador;
		int numParticipantes = 0; // Número de participantes para controlar que
									// haya mínimo 2
		int i = 0;
		do {
			numJugador = jugadoresTotales
					.listarJugadores("\n---Escoja los jugadores que van a  participar (mínimo 2)---");

			if (participantes.contains(new Jugador(jugadoresTotales.get(numJugador - 1).getAlias()))) {
				System.out.println("\nEse jugador ya va a jugar");
			} else { // El jugador se añade a la lista
				participantes.add(jugadoresTotales.get(numJugador - 1));
				numParticipantes++;
				System.out.println("\nJugador añadido correctamente");
				i++;
			}
		} while (Utilidades.deseaContinuar("\nDesea introducir otro jugador? s/n: ") && i < jugadoresTotales.size()
				|| numParticipantes < 2);

		if (i == jugadoresTotales.size())
			System.out.println("\nYa no se pueden escoger más jugadores.");

		return participantes;

	}

	/**
	 * Añade un jugador a los jugadores totales
	 * 
	 * @throws AliasYaExisteException
	 */
	private static void annadirJugador() throws AliasYaExisteException {

		String cadena = TecladoScanner.leerCadena("\nIntroduzca un alias: ");
		jugadoresTotales.annadirJugador(cadena);
		System.out.println("\nJugador añadido correctamente.");

	}

}
