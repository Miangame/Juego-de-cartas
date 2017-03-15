package juegoDeCartas;

/**
 * Crea un jugador con alias, partidas ganadas y partidas jugadas
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public class Jugador implements Comparable<Jugador> {
	/**
	 * Alias del jugador
	 */
	private String alias;
	/**
	 * Número de partidas jugadas
	 */
	private int partidasJugadas;
	/**
	 * Número de partidas ganadas
	 */
	private int partidasGanadas;
	/**
	 * Puntuación de la partida
	 */
	private double puntuacion = 0;

	public Jugador(String alias) {
		this.alias = alias;
		partidasJugadas = 0;
		partidasGanadas = 0;
	}

	public String getAlias() {
		return alias;
	}

	public int getPartidasJugadas() {
		return partidasJugadas;
	}

	public int getPartidasGanadas() {
		return partidasGanadas;
	}

	/**
	 * Incrementa en 1 las partidas jugadas
	 */
	public void incPartidasJugadas() {
		partidasJugadas++;
	}

	/**
	 * Incrementa en 1 las partidas ganadas
	 */
	public void incPartidasGanadas() {
		partidasGanadas++;
	}

	void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	double getPuntuacion() {
		return puntuacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equalsIgnoreCase(other.alias))
			return false;
		return true;
	}

	public int compareTo(Jugador jugador) {
		int comparepg = ((Jugador) jugador).getPartidasGanadas();
		return comparepg - this.partidasGanadas;
	}

	@Override
	public String toString() {
		return "Jugador [alias=" + alias + ", partidasJugadas=" + partidasJugadas + ", partidasGanadas="
				+ partidasGanadas + "]";
	}
}
