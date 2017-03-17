package juegoDeCartas;

import java.util.ArrayList;

import utiles.Menu;

/**
 * Clase que crea una partida con los jugadores que van a participar
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public class Partida {
	/**
	 * Jugadores que van a participar en la partida
	 */
	private ArrayList<Jugador> jugadores;

	/**
	 * Baraja para jugar la partida
	 */
	private Baraja baraja = new Baraja();

	public Partida(ArrayList<Jugador> participantes) {
		jugadores = participantes;
	}

	/**
	 * Juega la partida
	 * 
	 * @throws CartasAcabadasException
	 *             Cuando se han acabado las cartas
	 */
	public void jugar() throws CartasAcabadasException {
		baraja.barajar();
		incPartidas(); // Se incrementan las partidas jugadas
		Jugador ganador = null;
		for (Jugador jugador : jugadores) {
			ronda(jugador);
		}
		ganador = comprobarSiGanador(); // Al finalizar las rondas comprueba si
										// hay ganador
		if (ganador != null)
			ganador.incPartidasGanadas(); // Se incrementan las partidas ganadas
											// del ganador
		System.out.println("\nEl ganador es: " + ganador.getAlias());
	}

	/**
	 * Comprueba si hay un ganador, si no lo hay, el ganador es la banca
	 * 
	 * @return ganador
	 */
	private Jugador comprobarSiGanador() {
		Jugador ganador = new Jugador("Banca");
		for (Jugador jugador : jugadores) {
			if (jugador.getPuntuacion() == 7.5)
				ganador = jugador;
			else if (jugador.getPuntuacion() > ganador.getPuntuacion() && jugador.getPuntuacion() < 7.5)
				ganador = jugador;
		}

		return ganador;
	}

	/**
	 * Ronda que realiza cada jugador
	 * 
	 * @param jugador
	 *            Jugador que realiza la ronda
	 * @throws CartasAcabadasException
	 *             Si se acaban las cartas
	 */
	private void ronda(Jugador jugador) throws CartasAcabadasException {
		System.out.println("\nTurno del jugador " + jugador.getAlias());
		String[] opciones = { "Sacar carta", "Plantarse" };
		Menu menu = new Menu("\n---Escoja una opción---", opciones);
		int opcion;
		Carta carta; // Va a almacenar la carta sacada
		boolean jugado = false; // Jugado tiene que ser true, no se puede
								// plantar sin haber sacado antes al menos una
								// carta
		double suma = 0;
		do {
			opcion = menu.gestionar();
			switch (opcion) {
			case 1:
				carta = baraja.sacarCarta();
				System.out.println("\nHa salido el " + carta);
				suma += carta.valorCarta(); // Suma los valores que van saliendo
				System.out.println("\nEn total lleva: " + suma + " puntos.");
				jugado = true;
				break;

			default:
				if (!jugado)
					System.out.println("\nDebe jugar primero una carta");
				else
					System.out.println("\n" + jugador.getAlias() + " se ha plantado");
				break;
			}
		} while (opcion != 2 && comprobarResultado(suma) || !jugado);
		jugador.setPuntuacion(suma); // Asigna la puntuación total obtenida al
										// jugador
	}

	/**
	 * Comprueba si el resultado se ha pasado de 7.5 o ha sido 7.5
	 * 
	 * @param suma
	 *            Resultado de un jugador
	 * @return true si suma < 7.5, false si suma >= 7.5
	 */
	private boolean comprobarResultado(double suma) {
		if (suma > 7.5) {
			System.out.println("\nTe has pasado.");
			return false;
		} else if (suma == 7.5) {
			System.out.println("\nEnhorabuena, has ganado!");
			return false;
		}
		return true;
	}

	/**
	 * Incrementa las partidas jugadas a los participantes
	 */
	private void incPartidas() {
		for (int i = 0; i < jugadores.size(); i++) {
			jugadores.get(i).incPartidasJugadas();
		}
	}

}
