package juegoDeCartas;

import java.util.ArrayList;

/**
 * Ranking de los todos los jugadores
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public class Ranking {
	/**
	 * Ranking
	 */
	private Jugador[] ranking;

	public Ranking(ArrayList<Jugador> jugadores) {
		this.ranking = new Jugador[jugadores.size()];

		int i = 0;
		for (Jugador jugador : jugadores) {
			this.ranking[i] = jugador;
			i++;
		}

		// Ordena los jugadores según el número de partidas ganadas
		for (int j = 0; j < this.ranking.length - 1; j++) {
			if (this.ranking[j].getPartidasGanadas() < this.ranking[j + 1].getPartidasGanadas()) {
				// Intercambiamos valores
				Jugador variableauxiliar = this.ranking[j];
				this.ranking[j] = this.ranking[j + 1];
				this.ranking[j + 1] = variableauxiliar;

			}
		}

	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		if (ranking.length == 0)
			cadena.append("\nNo hay jugadores en el ranking");
		int i = 1;
		for (Jugador jugador : ranking) {
			cadena.append("\n" + i + ". " + jugador);
			i++;
		}

		return cadena.toString();
	}

}
