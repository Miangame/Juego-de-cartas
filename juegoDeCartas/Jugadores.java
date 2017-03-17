package juegoDeCartas;

import java.util.ArrayList;
import java.util.Collections;

import utiles.Menu;

public class Jugadores {
	/**
	 * Array con todos los jugadores
	 */
	static ArrayList<Jugador> jugadoresTotales;

	public Jugadores() {
		jugadoresTotales = new ArrayList<Jugador>();
	}

	void annadirJugador(String cadena) throws AliasYaExisteException {
		Jugador jugador = new Jugador(cadena);
		if (jugadoresTotales.contains(jugador))
			throw new AliasYaExisteException("Ese alias ya existe");
		jugadoresTotales.add(jugador);
	}

	Jugador eliminar(int indice) throws JugadorNoExisteException {
		if (indice == -1)
			throw new JugadorNoExisteException("No existen jugadores");
		return jugadoresTotales.remove(indice - 1);
	}

	/**
	 * Muestra el ranking de jugadores ordenado por partidas ganadas
	 * 
	 * @return cadena con el ranking
	 * @throws JugadorNoExisteException
	 */
	StringBuilder ranking() throws JugadorNoExisteException {
		if (jugadoresTotales.isEmpty()) 
			throw new JugadorNoExisteException("No existen jugadores");
		Collections.sort(jugadoresTotales);
		StringBuilder cadena = new StringBuilder();
		int i = 1;
		for (Jugador jugador : jugadoresTotales) {
			cadena.append("\n\t" + i + ". " + jugador);
			i++;
		}

		return cadena;
	}

	/**
	 * Indica si el array está vacio
	 * 
	 * @return true si está vacio, false si no lo está
	 */
	public boolean isEmpty() {
		return jugadoresTotales.isEmpty();
	}

	/**
	 * Devuelve el tamaño del array
	 * 
	 * @return tamaño del array
	 */
	public int size() {
		return jugadoresTotales.size();
	}

	/**
	 * Devuelve el jugador pasado por argumentos
	 * 
	 * @param i
	 *            indice del jugador
	 * @return jugador
	 */
	public Jugador get(int i) {
		return jugadoresTotales.get(i);
	}

	/**
	 * Muestra todos los jugadores y devuelve el seleccionado
	 * 
	 * @return Jugador seleccionado
	 */
	int listarJugadores(String msg) {
		if (jugadoresTotales.isEmpty()) {

			return -1;
		}

		int i = 0;
		String[] opcionesJugadoresTotales = new String[jugadoresTotales.size()];
		for (Jugador jugador : jugadoresTotales) {
			opcionesJugadoresTotales[i] = jugador.toString();
			i++;
		}
		Menu menuJugadoresTotales = new Menu(msg, opcionesJugadoresTotales);
		return menuJugadoresTotales.gestionar();
	}

}
